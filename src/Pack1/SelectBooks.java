package Pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectBooks {

    private static final String url="jdbc:mysql://localhost:3306/advjdbc";
    private static final String userName ="root";
    private static final String password = "root12";
    private static final String Query = "select book_id,book_name,book_price from books";

    public static void main(String[] args)  throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con = DriverManager.getConnection(url,userName,password);
       Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
       ResultSet rs = stmt.executeQuery(Query);

        System.out.println("Query Execution Completed.. Data Available in ResultSet");

        while (rs.next()){
            System.in.read();
            //System.in.read();
            rs.refreshRow(); //Refreshes the current row with its most recent value in the database.
            System.out.println(rs.getInt(1)+" " + rs.getString(2) +" "+ rs.getDouble(3));
        }

        con.close();
    }
}
