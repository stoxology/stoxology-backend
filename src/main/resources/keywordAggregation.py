import json

with open('mock.json') as data_file:    
    data = json.load(data_file)

articles_list = data["list_of_keywords"]

rawkeywords = []

for article in articles_list:
	tweet = article["tweet"]
	like = article["like"]
	keywordlist = article["keywords"]
	for keyword in keywordlist:
		newkeyword = {}
		newkeyword["keyword"] = keyword["text"]
		newkeyword["score"] = (float(tweet) + float(like)) * float(keyword["relevance"])
		rawkeywords.append(newkeyword)

rawkeywords.sort(key=lambda x: x["score"], reverse=True)

topten = rawkeywords[:10]

print(topten)
