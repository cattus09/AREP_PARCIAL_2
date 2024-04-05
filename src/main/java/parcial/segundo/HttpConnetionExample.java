package parcial.segundo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Hello world!
 */
public final class HttpConnetionExample {
     private static final String USER_AGENT = "Mozilla/5.0";
     private static String[] res; 
     private static int count = 0;

    public static String conect(String[] url) throws IOException {
        res = url;
        String urls = (count++ % 2 == 0) ? res[0] : res[1];
        System.out.println(urls);
        URL obj = new URL(urls);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        
        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response);
            // print result
            return response.toString();
        } else {
            return "GET request not worked";
        }
    }
}
