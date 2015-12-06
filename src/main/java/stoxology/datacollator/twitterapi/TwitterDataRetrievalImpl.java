package stoxology.datacollator.twitterapi;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.commons.io.IOUtils;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import stoxology.datacollator.DataRetrieval;
import stoxology.datacollator.Utility;
import stoxology.datacollator.twitterapi.entities.Example;
import stoxology.datacollator.twitterapi.entities.TwitterDataExtract;
import stoxology.datacollator.twitterapi.entities.Url_____;

public class TwitterDataRetrievalImpl implements DataRetrieval {

	private static String AccessToken = "265560692-HYjU3AIHNoHXIsB7Mu4pQZpQB2t5uyYLIeeyzzgw";
	private static String AccessSecret = "fnr2QCkh8mUkJsYN48wlZV9S9GZByJhVGQfnSLqO4P4aA";
	private static String ConsumerKey = "YwRrMqjrmBQ5u8y7OlAkXLaPn";
	private static String ConsumerSecret = "OqbvV88DEAAPIsFUri9h6oGEy8ZgA4QX0mP6ZmFd9Fco2mI3gE";
	
	public TwitterDataRetrievalImpl() {
		
	}
	
	/**
	 * @inheritDoc
	 */
	@Override
	public List<TwitterDataExtract> GetData() {
		
		Example[] tweetData = GetTweets();
		
		if (tweetData == null)
			return new ArrayList<TwitterDataExtract>();
		
		List<TwitterDataExtract> twitterDataExtracts = new ArrayList<TwitterDataExtract>();
		
		for(Example tweet : tweetData)
		{
			TwitterDataExtract tde = new TwitterDataExtract();
			for (Url_____ url : tweet.getEntities().getUrls())
			{
				tde.getUrlsOfInterest().add(url.getUrl());
			}
			tde.setFavouriteCount(tweet.getFavoriteCount());
			tde.setRetweetCount(tweet.getRetweetCount());
			tde.setCreatedAt(tweet.getCreatedAt());
			twitterDataExtracts.add(tde);
		}		
		return twitterDataExtracts;
	}
	
	/**
	 * Retrieves tweet raw data for a (currently hardcoded) source 
	 * @return An array of populated Example objects
	 */
	private Example[] GetTweets()
	{
		OAuthConsumer consumer = new CommonsHttpOAuthConsumer(ConsumerKey, ConsumerSecret);
		consumer.setTokenWithSecret(AccessToken, AccessSecret);
		HttpGet request = new HttpGet("https://api.twitter.com/1.1/statuses/user_timeline.json?user_id=ISW&screen_name=TheStudyofWar");
		try
		{
			consumer.sign(request);
		
			HttpClient client = HttpClientBuilder.create().build();
			HttpResponse response = client.execute(request);
			int statusCode = response.getStatusLine().getStatusCode();
	
			String rawData = IOUtils.toString(response.getEntity().getContent());
			
	        System.out.println(statusCode + ":" + response.getStatusLine().getReasonPhrase());
	        System.out.println(rawData);
	        
	        return Utility.convertToObject(Example[].class, rawData);
		}
		catch (Exception e)
		{
			//handle something	
			System.out.println("An exception occurred");
			System.out.println(e.toString());
		}
		return null;
	}
}
