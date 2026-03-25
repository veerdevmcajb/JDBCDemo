package Pack1;

import java.sql.*;

/*  - Using ResultSet we can access ResultSetMetadata.
    - Using ResultSetMetaData we can get column count & columns name .
    -
* */
public class ResultSetMetaData_EX {

    private static final String url = "jdbc:mysql://localhost:3306/advjdbc";
    private static final String username ="root";
    private static final String pass ="root12";

    private static final String Query ="select * from books";

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

       Connection con  = DriverManager.getConnection(url,username,pass);
       Statement stmt = con.createStatement();
       ResultSet rs = stmt.executeQuery(Query);

       ResultSetMetaData  metadata = rs.getMetaData();

        System.out.println("Column Count : "+ metadata.getColumnCount());

        for(int i=1;i<=metadata.getColumnCount(); i++){
            String columnName = metadata.getColumnName(i);
            System.out.println(columnName);
        }
        con.close();
    }
}
