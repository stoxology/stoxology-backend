package stoxology.datacollator.twitterapi;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.commons.io.IOUtils;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import stoxology.datacollator.DataRetrieval;

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
	public void GetData() {
		
		OAuthConsumer consumer = new CommonsHttpOAuthConsumer(ConsumerKey, ConsumerSecret);
		consumer.setTokenWithSecret(AccessToken, AccessSecret);
		HttpGet request = new HttpGet("https://api.twitter.com/1.1/statuses/user_timeline.json?user_id=ISW&screen_name=TheStudyofWar");
		try
		{
			consumer.sign(request);
		
			HttpClient client = HttpClientBuilder.create().build();
			HttpResponse response = client.execute(request);
			int statusCode = response.getStatusLine().getStatusCode();
	
	        System.out.println(statusCode + ":" + response.getStatusLine().getReasonPhrase());
	        System.out.println(IOUtils.toString(response.getEntity().getContent()));
		}
		catch (Exception e)
		{
			//handle something			
		}
	}
}
