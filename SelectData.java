import java.sql.*;

public class SelectData {
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

    ResultSet rs = null;

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

      String sql = "SELECT * FROM EMPLOYEE";

      //Step 4 : Executing The Query

      //We are using executeQuery() method as we are executing SELECT statement

      rs = stmt.executeQuery(sql);

      //Processing the ResultSet object

      while (rs.next()) {
        System.out.println("ID :" + rs.getInt(1));

        System.out.println("First Name : " + rs.getString(2));

        System.out.println("Last Name :" + rs.getString(3));

        System.out.println("Designation :" + rs.getString(4));

        System.out.println("-------------------");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      //STEP 5 : Closing The DB Resources

      //Closing the ResultSet object

      try {
        if (rs != null) {
          rs.close();
          rs = null;
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }

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
