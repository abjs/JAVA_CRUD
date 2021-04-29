import java.sql.*;

public class UpdateData {
  static {
    //STEP 1 : Registering The Driver Class

    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
    } catch (ClassNotFoundException e) {
      System.out.println("Unable To Load The Driver class");
    }
  }

  public static void main(String[] args) {
    Connection con = null;

    Statement stmt = null;

    try {
      //Database Credentials

      String URL = "jdbc:oracle:thin:@localhost:1521:XE";

      String username = "system";

      String password = "abjs";

      //STEP 2 : Creating The Connection Object

      con = DriverManager.getConnection(URL, username, password);

      //STEP 3 : Creating The Statement Object

      stmt = con.createStatement();

      //Constructing The SQL Query

      String sql =
        "UPDATE EMPLOYEE SET FIRST_NAME='Rakesh', " +
        "LAST_NAME='Malhotra' WHERE DISIGNATION='CEO'";

      //Step 4 : Executing The Query

      //We are using executeUpdate() method as we are executing UPDATE statement

      int i = stmt.executeUpdate(sql);

      if (i != 0) {
        System.out.println("Record is updated");
      } else {
        System.out.println("Record is not updated");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      //STEP 5 : Closing The DB Resources

      //Closing the Statement object

      try {
        if (stmt != null) {
          stmt.close();
          stmt = null;
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }

      //Closing the Connection object

      try {
        if (con != null) {
          con.close();
          con = null;
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
