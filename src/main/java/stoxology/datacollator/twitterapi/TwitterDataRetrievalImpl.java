package stoxology.datacollator.twitterapi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

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

		ArrayList<Example> tweetData = (ArrayList<Example>) GetTweets();

		if (tweetData == null)
			return new ArrayList<TwitterDataExtract>();

		List<TwitterDataExtract> twitterDataExtracts = new ArrayList<TwitterDataExtract>();

		for (Example tweet : tweetData) {
			TwitterDataExtract tde = new TwitterDataExtract();
			for (Url_____ url : tweet.getEntities().getUrls()) {
				tde.getUrlsOfInterest().add(url.getUrl());
			}
			tde.setFavouriteCount(tweet.getFavoriteCount());
			tde.setRetweetCount(tweet.getRetweetCount());
			tde.setCreatedAt(tweet.getCreatedAt());
			
			if (tde.getUrlsOfInterest().size() > 0 
					&& (tde.getFavouriteCount() + tde.getRetweetCount() > 25))
			{
				twitterDataExtracts.add(tde);
			}
		}
		return twitterDataExtracts;
	}

	/**
	 * Retrieves tweet raw data for a (currently hardcoded) source
	 * 
	 * @return An array of populated Example objects
	 */
	private List<Example> GetTweets() {
		// get tweets up to a year

		List<Example> examples = new ArrayList<Example>();
		boolean requestMore = true;
		long maxId = 0L;
		int requestCount = 0;
		while (requestMore && requestCount < 20) //requestCount is a safety limit
		{
			OAuthConsumer consumer = new CommonsHttpOAuthConsumer(ConsumerKey,ConsumerSecret);
			consumer.setTokenWithSecret(AccessToken, AccessSecret);
			String baseUri = "https://api.twitter.com/1.1/statuses/user_timeline.json?user_id=ISW&screen_name=TheStudyofWar&count=200";
			if (maxId > 0)
			{
				baseUri = baseUri + "&max_id=" + maxId;
			}			
			HttpGet request = new HttpGet(baseUri);			
				
			try {
				// must be up to a years worth of data
				consumer.sign(request);

				HttpClient client = HttpClientBuilder.create().build();
				HttpResponse response = client.execute(request);
				int statusCode = response.getStatusLine().getStatusCode();

				String rawData = IOUtils.toString(response.getEntity()
						.getContent());

				System.out.println(statusCode + ":"
						+ response.getStatusLine().getReasonPhrase());
				System.out.println(rawData);

				Example[] retrievedData = Utility.convertToObject(Example[].class, rawData);
				
				if (retrievedData.length <= 0)
				{
					requestMore = false;
					break;
				}
								
				//Get the last ID of the last in the list if the tweets have still not reached post 1 year
				Example lastValueInCollection = retrievedData[retrievedData.length - 1];
				
				if (GetDateFromTwitterString(lastValueInCollection.getCreatedAt())
						.isAfter(LocalDateTime.now().minusYears(1)))
				{
					maxId = lastValueInCollection.getId();
					requestMore = true;
				}
				else
				{
					requestMore = false;
				}
				
				examples.addAll(Arrays.asList(retrievedData));
				
			} catch (Exception e) {
				// handle something
				System.out.println("An exception occurred");
				System.out.println(e.toString());
				requestMore = false;
			}
			requestCount++;
		}
		return examples;
	}
	
	/**
	 * Convert the passed in date string formatted in twitter style and convert to a java object
	 * @param dateStr A date time as a string as formatted by the Twitter API
	 * @return A LocalDateTime object
	 */
	private LocalDateTime GetDateFromTwitterString(String dateStr)
	{//EEE MMM dd HH:mm:ss ZZZZZ yyyy
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss Z yyyy").withLocale(Locale.ENGLISH);		
		return LocalDateTime.parse(dateStr, formatter);
	}
}
