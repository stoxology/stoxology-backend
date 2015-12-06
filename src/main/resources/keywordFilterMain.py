import json
from datetime import datetime, timedelta

import keywordAggregation

with open( 'mock.json' ) as data_file:    
 	    data = json.load(data_file)


batch = {} 
batch["list_of_keywords"] = [] #This is a list of json-s sorted in weekly basis

articles_list = data["list_of_keywords"]

first_article = articles_list[1]

start_date = datetime.strptime( first_article["timestamp"], "%Y-%m-%d")

# Sort dates by 10-day periods
i = 0
for article in articles_list :
	current_date = datetime.strptime( article["timestamp"], "%Y-%m-%d")
	if current_date < start_date + timedelta(days=10) :
		batch["list_of_keywords"].append(article)

	else :
		print( keywordAggregation.top_ten( batch ) )
		start_date = current_date
		batch["list_of_keywords"] = []
		batch["list_of_keywords"].append(article)

print( keywordAggregation.top_ten( batch ) )		
