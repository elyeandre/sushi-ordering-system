
package restaurantorderingandpayment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//jdbc:mysql://localhost:3306/sushi_restaurant
//jdbc:mysql://sql6.freesqldatabase.com/sql6503781
public class SushiDBConnection {
      private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
      private static final String DB_URL = "jdbc:mysql://localhost:3306/sushi_restaurant";
      private static final String USER = "root";
      private static final String PASS = "jerickson";
      
      public static Connection connectDB() {
          Connection conn = null;
          
          try {
               // Load the driver not necessary in the fewer version of java
              Class.forName(DATABASE_DRIVER);
              // Getting connection to my database
              conn = DriverManager.getConnection(DB_URL, USER, PASS);
              System.out.println("connected");
              return conn;
          } catch (Exception e) {
              System.out.println("theres an error while connecting to db");
              
              return null;
          } 
          
      }
      public static void main(String[] args) {
        connectDB();
    }
}

