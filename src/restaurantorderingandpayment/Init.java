
package restaurantorderingandpayment;

/**
 *
 * @author Jerickson Mayor
 */
public class Init {
    public static void main(String[] args) {
//        SplashScreen splash = new SplashScreen();
//        LoginForm login = new LoginForm();
//        splash.setVisible(true);
//        while (num < 2000) {
//        splash.progressbar.setValue(num);
//        try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) { }
//            num += 95;
//        }
//        splash.setVisible(false);
//        login.setVisible(true);
 SplashScreen splash = new SplashScreen();
 LoginForm login = new LoginForm();
 splash.setVisible(true);
 try {
     for (int i = 0; i <= 100; i++) {
         Thread.sleep(100);
         splash.ProgressBar.setValue(i);
         if (i == 100) {
             splash.dispose();
             login.setVisible(true);
         }
     }
 } catch (Exception e) {
     
 }

       
        
        
    


    }

}
