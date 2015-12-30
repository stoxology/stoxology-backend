import json
import collections

with open( "input_object.json" ) as data_file:    
 	    data = json.load(data_file)

totalListOfKeywords = []

articles_list = data

#Delete empty objects
for article in list(articles_list) :
	if article["keywordResults"][0] is None :
		articles_list.remove(article)
	else :
		for item in article["keywordResults"][0]["keywordDetails"] :
			totalListOfKeywords.append( item["keyword"])

cnt = collections.Counter()

for word in totalListOfKeywords :
	cnt[word] += 1

print cnt