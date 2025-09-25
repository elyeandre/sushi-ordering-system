
package restaurantorderingandpayment;
   import java.net.*;
/**
 *
 * @author Jerickson Mayor
 */
public class SMS2 {
                       String recipient = "+639128562896";
                        String message = "im sms api";
                        String username = "jerickson";
                        String password = "jerickson";
                        String originator = "SUSHINIJERICK";
 
        public void sendSMS(String recipient, String message) {
                this.recipient = recipient;
                this.message = message;
                try {
                     
 
                        String requestUrl  ="https://5865-175-176-13-243.ap.ngrok.io/api?action=sendmessage&" +
            "username=" + URLEncoder.encode(username, "UTF-8") +
            "&password=" + URLEncoder.encode(password, "UTF-8") +
            "&recipient=" + URLEncoder.encode(recipient, "UTF-8") +
            "&messagetype=SMS:TEXT" +
            "&msg=" + URLEncoder.encode(message, "UTF-8") +
            "&originator=" + URLEncoder.encode(originator, "UTF-8") +
            "&serviceprovider=GSMModem1" +
            "&responseformat=html";
                        URL url = new URL(requestUrl);
                        HttpURLConnection uc = (HttpURLConnection)url.openConnection();
 
                        System.out.println(uc.getResponseMessage());
 
                        uc.disconnect();
 
                } catch(Exception ex) {
                        System.out.println(ex.getMessage());
 
                }
        }
 
} 

