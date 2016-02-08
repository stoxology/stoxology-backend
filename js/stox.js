<script src="https://cdnjs.cloudflare.com/ajax/libs/d3/3.4.1/d3.min.js"></script>
<script src="http://labratrevenge.com/d3-tip/javascripts/d3.tip.v0.6.3.js"></script>
        //Date parser
        var parseDate = d3.time.format("%Y/%m/%d");

        var margin = {top: 20, right: 20, bottom: 30, left: 40},
            width = 960 - margin.left - margin.right,
            height = 450 - margin.top - margin.bottom;

        var x = d3.time.scale.utc()
            .range([0, width]);

        var y = d3.scale.linear()
            .range([height, 0]);

        var color = d3.scale.category10();

        var xAxis = d3.svg.axis()
            .scale(x)
            .orient("bottom");

        var yAxis = d3.svg.axis()
            .scale(y)
            .orient("left");

        var svg = d3.select(".diagram").append("svg")
            .attr("width", width + margin.left + margin.right)
            .attr("height", height + margin.top + margin.bottom)
          .append("g")
            .attr("transform", "translate(" + margin.left + "," + margin.top + ")");

        var tip = d3.tip()
          .attr('class', 'd3-tip')
          //.offset([-10, 0])
          .html(function(d) {
            return "<span style='color:" +  direction(d.dailychange) + "'>" + (d.dailychange*100).toFixed(2) + "% </span>" + "<span style='color:orange'>" + d.keyword + "</span>";
          })

        svg.call(tip);

        d3.selection.prototype.moveToFront = function() {
          return this.each(function(){
            this.parentNode.appendChild(this);
          });
        };

        d3.selection.prototype.moveToBack = function() {  
                return this.each(function() { 
                var firstChild = this.parentNode.firstChild; 
                if (firstChild) { 
                    this.parentNode.insertBefore(this, firstChild); 
                } 
              }); 
            };

        // Reading in the data

        d3.csv("test.csv", type, function(error, data) {
          if (error) throw error;

          console.log(data)

          x.domain([ new Date(data[ data.length - 1].date), new Date(data[0].date)])
            .rangeRound([0, width - margin.left - margin.right]);

          ymin = d3.min(data, function(d) { return d.price - 10.0; });
          ymax = d3.max(data, function(d) { return d.price + 10.0; });

          y.domain([ ymin, ymax ]);

          svg.append("g")
              .attr("class", "x axis")
              .attr("transform", "translate(0," + height + ")")
              .call(xAxis)
              .append("text")
              .attr("class", "label")
              .attr("x", width)
              .attr("y", -6)
              .style("text-anchor", "end")
              .text("Date");

          svg.append("g")
              .attr("class", "y axis")
              .call(yAxis)
            .append("text")
              .attr("class", "label")
              .attr("transform", "rotate(-90)")
              .attr("y", 6)
              .attr("dy", ".71em")
              .style("text-anchor", "end")
              .text("Price")

          svg.selectAll("circle")
              .data(data)
              .enter()
              .append("circle")
                //.attr("class", "circle")
                .attr("cx", function(d) { return x(d.date); })
                .attr("cy", function(d) { return y(d.price); })
                .attr("r", function(d) { return Math.sqrt(d.score); })
                .style("fill", function(d) { return color(d.sentiment); });

        //Mouse over events for tooltip and circle transition
            d3.selectAll("circle")
              .on("mouseover", function(d) {
                d3.select(this).style("fill", "red");
                d3.select(this).moveToFront();
                tip.show(d);
            } )
              .on("mouseout", function(d) {
                d3.select(this).style("fill", function(d) { return color(d.sentiment); });
                d3.select(this).moveToBack();
            } );

          var legend = svg.selectAll(".legend")
              .data(color.domain())
            .enter().append("g")
              .attr("class", "legend")
              .attr("transform", function(d, i) { return "translate(0," + i * 20 + ")"; });

          legend.append("rect")
              .attr("x", width - 18)
              .attr("width", 18)
              .attr("height", 18)
              .style("fill", color);

          legend.append("text")
              .attr("x", width - 24)
              .attr("y", 9)
              .attr("dy", ".35em")
              .style("text-anchor", "end")
              .text(function(d) { return d; });

        });

        function type(d) {
          d.price = +d.price;
          d.dailychange = d.dailychange;
          console.log(d.dailychange);
          d.sentiment = d.sentiment;
          d.score = +d.score;
          d.date = parseDate.parse(d.date);
          d.keyword = d.keyword;

          return d;
        }

        function direction(x) {
          if (x < 0.0) return "red";
          else return "green";

        }