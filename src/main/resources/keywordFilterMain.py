import json
import csv
from datetime import datetime, timedelta
from decimal import Decimal

import keywordAggregation

#This function takes care of the encoding
def byteify(input) :
    if isinstance(input, dict):
        return {byteify(key):byteify(value) for key,value in input.iteritems()}
    elif isinstance(input, list):
        return [byteify(element) for element in input]
    elif isinstance(input, unicode):
        return input.encode('utf-8')
    else:
        return input

def matchPrice( findDate, prices ) :
	result = 200
	for item in prices[1:200] :
		currentDate = datetime.strptime( item[0], '%Y-%m-%d' )
		if currentDate >= findDate :
			result = float(item[6])
	return result

def calcDailyReturn( findDate, prices ) :
	result = 0.0
	nextItem = prices[1]
	for item in prices[1:200] :
		currentDate = datetime.strptime( item[0], '%Y-%m-%d' )
		if currentDate >= findDate :
			price0 = float(item[6])
			price1 = float(nextItem[6])
			result = Decimal(price1/price0 - 1.0)
		nextItem = item
	return round(result,5)

with open( "input_object.json" ) as data_file:    
 	    data_raw = json.load(data_file)


data = byteify(data_raw)

batch = {} 
batch["article_extraction"] = [] 

front_end_object = {}
front_end_object["keyword_lists"] = []

articles_list = data

#Delete articles with empty keyword results
for article in list(articles_list) :
	#print article
	if article is None :
		articles_list.remove(article)
	elif not article["keywordResults"] :
		print article
		articles_list.remove(article)

articles_list.sort(key=lambda x: int( x["keywordResults"][0]["timestamp"] ), reverse=True)

first_article = articles_list[0]

start_date = datetime.fromtimestamp( int(first_article["keywordResults"][0]["timestamp"]) )

# Sort dates by periods
for article in articles_list :
	print start_date
	current_date = datetime.fromtimestamp( int(article["keywordResults"][0]["timestamp"]) )
	if current_date + timedelta(days=1)  > start_date :
		batch["article_extraction"].append(article)

	else :
		start_date = current_date

		currentlist = keywordAggregation.top_ten( batch, start_date.strftime('%Y/%m/%d') )
		front_end_object["keyword_lists"].append(currentlist)
		front_end_object

		batch["article_extraction"] = []
		batch["article_extraction"].append(article)

#remaining batch
currentlist = keywordAggregation.top_ten( batch, start_date.strftime('%Y/%m/%d') )		
front_end_object["keyword_lists"].append(currentlist)


#json for front end
with open('front_end_input.json', 'w') as outfile:
    json.dump(front_end_object, outfile, indent=4)


#load Price CSV
with open('prices.csv', 'rb') as f:
    priceData = csv.reader(f, delimiter=',', quotechar='|')
    priceList = list(priceData)

#CSV output
csvData = []
csvData.append( [ 'date', 'keyword', 'score', 'sentiment', 'price', 'dailychange' ])

for item in front_end_object["keyword_lists"] :
	if item["list"] != [] :
		findDate = datetime.strptime( item["timestamp"], '%Y/%m/%d' )
		price = matchPrice( findDate, priceList )
		dailychange = calcDailyReturn( findDate, priceList )
		row = [ item["timestamp"], item["list"][0]["keyword"], item["list"][0]["score"], item["list"][0]["sentiment"], price, dailychange ]
		csvData.append( row )

with open('test.csv', 'wb') as fp:
    a = csv.writer(fp, delimiter=',')
    a.writerows(csvData)

print csvData





