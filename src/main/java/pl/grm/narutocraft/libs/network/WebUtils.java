package pl.grm.narutocraft.libs.network;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

public class WebUtils {
	private static final String	charset		= "UTF-8";
	
	private static final String	USER_AGENT	= "Mozilla/5.0";
	
	public static String sendPost(String webURL, HashMap<String, String> postOptions)
			throws Exception {
		URL obj = new URL(webURL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		
		String urlParameters = "";
		for (String s : postOptions.keySet()) {
			urlParameters = urlParameters
					+ String.format(
							"%s=%s&",
							new Object[]{
									s, URLEncoder.encode(postOptions.get(s), "UTF-8")});
		}
		if (urlParameters.contains("&")) {
			urlParameters = urlParameters.substring(0, urlParameters.lastIndexOf('&'));
		}
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
		
		int responseCode = con.getResponseCode();
		
		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		
		StringBuffer response = new StringBuffer();
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine + "\r\n");
		}
		in.close();
		
		return response.toString();
	}
}
