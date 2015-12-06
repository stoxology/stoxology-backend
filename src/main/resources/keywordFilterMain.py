import json
from datetime import datetime, timedelta

import keywordAggregation

def filter_keyword( object ) :
	with open( object ) as data_file:    
	 	    data = json.load(data_file)

	batch = {} 
	batch["article_extraction"] = [] #This is a list of json-s sorted in weekly basis

	front_end_object = {}
	front_end_object["keyword_lists"] = []

	articles_list = data["article_extraction"]

	first_article = articles_list[1]

	start_date = datetime.strptime( first_article["timestamp"], "%Y-%m-%d")
	start_date_str = first_article["timestamp"]

	# Sort dates by 10-day periods
	i = 0
	for article in articles_list :
		current_date = datetime.strptime( article["timestamp"], "%Y-%m-%d")
		if current_date < start_date + timedelta(days=10) :
			batch["article_extraction"].append(article)

		else :
			start_date = current_date
			start_date_str = article["timestamp"]

			currentlist = keywordAggregation.top_ten( batch, start_date_str)
			front_end_object["keyword_lists"].append(currentlist)
			front_end_object

			batch["article_extraction"] = []
			batch["article_extraction"].append(article)

	#remaining batch
	currentlist = keywordAggregation.top_ten( batch, start_date_str )		
	front_end_object["keyword_lists"].append(currentlist)

	with open('front_end_input.json', 'w') as outfile:
	    json.dump(front_end_object, outfile)

