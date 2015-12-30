import json

# This function takes a list of article objects and lists the top ten keywords aggregated

def top_ten( data, timestamp ):

	articles_list = data["article_extraction"]

	rawkeywords = []

	for article in articles_list:
		if article["keywordResults"][0] is not None :
			tweet = article["retweetCount"]
			like = article["favouriteCount"]
			keywordlist = article["keywordResults"][0]["keywordDetails"]
			for keyword in keywordlist:
				newkeyword = {}
				newkeyword["keyword"] = keyword["keyword"]
				newkeyword["url"] = article["urlsOfInterest"]
				newkeyword["sentiment"] = keyword["type"]
				grade = grade_relevance( float(keyword["relevanceScore"]) )
				newkeyword["score"] = ( float(tweet) + float(like) ) * grade
				if grade > 0 :
					rawkeywords.append(newkeyword)

	rawkeywords.sort(key=lambda x: x["score"], reverse=True)

	toplist = rawkeywords[:1]

	return_object = { "timestamp" : timestamp, "list" : toplist }

	return return_object

def grade_relevance( n ) :
	if n < 0.5 :
		result = 0
	elif n > 0.6 :
		result = 1
	else :
		result = 0
	return result

