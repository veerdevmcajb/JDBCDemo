package Pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/*  => PreparedStatement is used to execute both SELECT & NON-SELECT Queries
    => PreparedStatement will support for Positional Parameters ( ? ) in the Query
    => Postional Parameters are used to supply dynamic values to Query in the Run time.
    => When we want to execute same query multiple times with different values then it is highly recommended to use PreparedStatement.
    Query Without Positional Parameters :   INSERT INTO BOOKS VALUES (101, "JAVA", 5000);

    Query With Positional Parameters :   	INSERT INTO BOOKS VALUES (?, ?, ?) ;

    - if we don't set the values for positional parameters then our Query execution will be fail.
*
* */

public class PreparedStmtEx {

    private static final String url ="jdbc:mysql://localhost:3306/advjdbc";
    private static final String username = "root";
    private static final String pass = "root12";
    private static final String query="insert into books values (?,?,?)";

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con = DriverManager.getConnection(url,username,pass);
       PreparedStatement prestmt  = con.prepareStatement(query);
        prestmt.setInt(1,105);
        prestmt.setString(2,"AWS");
        prestmt.setDouble(3,1099);

      int count = prestmt.executeUpdate();
        System.out.println("ROW Created..." + count);

        con.close();

    }
}
