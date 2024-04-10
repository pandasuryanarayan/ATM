package atm;

import java.sql.*;

public class conn {
    Connection c;
    Statement s;

    conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bnkmngsys";
            String username = "surya";
            String password = "surya";
            c = DriverManager.getConnection(url, username, password);
            s = c.createStatement();

            // Check if these tables exist
            DatabaseMetaData dbm = c.getMetaData();
            ResultSet signupTable = dbm.getTables(null, null, "signup", null);
            ResultSet signuptwoTable = dbm.getTables(null, null, "signuptwo", null);
            ResultSet signupthree = dbm.getTables(null, null, "signupthree", null);
            ResultSet login = dbm.getTables(null, null, "login", null);
            ResultSet account_details = dbm.getTables(null, null, "account_details", null);

            if (!signupTable.next()) {
                // signup table doesn't exist, create it
                String createSignupTableQuery = "create table signup (formno varchar(255), name varchar(255), fathername varchar(255), dob varchar(255), gender varchar(255), email varchar(255), maritalstatus varchar(255), address varchar(255), city varchar(255), pin varchar(255), state varchar(255))";
                s.executeUpdate(createSignupTableQuery);
            }

            if (!signuptwoTable.next()) {
                // signuptwo table doesn't exist, create it
                String createSignuptwoTableQuery = "create table signuptwo (formno varchar(255), religion varchar(255), category varchar(255), income varchar(255), education varchar(255), occupation varchar(255), pan varchar(255), adhar varchar(255))";
                s.executeUpdate(createSignuptwoTableQuery);
            }
            
            if (!signupthree.next()) {
                // signupthree table doesn't exist, create it
                String createSignupthreeTableQuery = "create table signupthree (formno varchar(255), name varchar(255), Account_Number varchar(255), PIN varchar(255))";
                s.executeUpdate(createSignupthreeTableQuery);
            }
            
            if (!login.next()) {
                // login table doesn't exist, create it
                String createloginTableQuery = "create table login (formno varchar(255), name varchar(255), Account_Number varchar(255), PIN varchar(255))";
                s.executeUpdate(createloginTableQuery);
            }
            
            if (!account_details.next()) {
                // login table doesn't exist, create it
                String createaccount_detailsTableQuery = "create table account_details (Account_Number varchar(255), balance int)";
                s.executeUpdate(createaccount_detailsTableQuery);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
