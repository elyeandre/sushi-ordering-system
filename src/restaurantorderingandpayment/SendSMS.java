
package restaurantorderingandpayment;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.methods.HttpPost;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class SendSMS {

  
    public void sendSMS(String number, String message) throws UnsupportedEncodingException, IOException {
              HttpPost post = new HttpPost("https://beta.semaphore.co/api/v4/messages"); // apiurl here

        // add request parameter, form parameters
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("apikey", "486f108b7ba350c7d2e8d8cd1e2810cb"));
        urlParameters.add(new BasicNameValuePair("number", number));
        urlParameters.add(new BasicNameValuePair("message", message));
//        urlParameters.add(new BasicNameValuePair("sendername", "SEMAPHORE"));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            System.out.println(EntityUtils.toString(response.getEntity()));
        }
    }

}
    



