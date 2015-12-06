import json

# This function takes a list of article objects and lists the top ten keywords aggregated

def top_ten( data ):

	articles_list = data["list_of_keywords"]

	rawkeywords = []

	for article in articles_list:
		tweet = article["tweet"]
		like = article["like"]
		keywordlist = article["keywords"]
		for keyword in keywordlist:
			newkeyword = {}
			newkeyword["keyword"] = keyword["text"]
			grade = grade_relevance( float(keyword["relevance"]) )
			newkeyword["score"] = (float(tweet) + float(like)) * grade
			if grade > 0 :
				rawkeywords.append(newkeyword)

	rawkeywords.sort(key=lambda x: x["score"], reverse=True)

	topten = rawkeywords[:10]

	return [topten]

def grade_relevance( n ) :
	if n < 0.5 :
		result = 0
	elif n > 0.9 :
		result = 1.5
	else :
		result = 1
	return result

