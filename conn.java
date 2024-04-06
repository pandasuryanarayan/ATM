package atmsimulation;

import java.sql.*;


public class conn {
    Connection c;
    Statement s;
    conn() {
    try{
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	String url = "jdbc:mysql://localhost:3307/bnkmngsys";
    	String username = "root";
    	String password = "siws";
    	c = DriverManager.getConnection(url,username,password);
        s=c.createStatement();
        
    }catch(Exception e){
        System.out.println(e);
    }
   }
}
