package stoxology.datacollator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WebExtractor {
	
	public static String getUrlData(String apiUrl) {

		StringBuilder builder = new StringBuilder();

		try {

			URL url = new URL(apiUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				builder.append(output);
				System.out.println(output);
			}

			conn.disconnect();
			

			return builder.toString();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return "Malformed url exception.";

		} catch (IOException e) {

			e.printStackTrace();
			return "IO Exception.";
		}
	}
}
