package Pack1;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Books {

    private static final String url = "jdbc:mysql://localhost:3306/advjdbc" ;
    private static final String username = "root";
    private static final String password = "root12";


    public static void main(String[] args) throws Exception {
       // insert();

        display();
        System.out.println("=====After update=====");
        update();
        System.out.println();
        delete();
    }

    public static void insert() throws Exception {

        String Query = "Insert into books values (104,'SQL',550),(105,'JavaScript',800)";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(url,username,password);

        Statement stmt = con.createStatement();
        int rowAffected = stmt.executeUpdate(Query);
        System.out.println("RowAffected "+ rowAffected);
        System.out.println("Data Inserted...");
        con.close();

        display();

    }

    public static void display() throws Exception{

        String Query = "select * from books";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(url,username,password);

        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery(Query);

        while(rs.next()){
            System.out.println(rs.getInt(1) + "--> "+ rs.getString(2) +"--> "+ rs.getDouble(3));

        }


    }

    public static void update() throws Exception{

        String Query ="select * from books" ;

        Class.forName("com.mysql.cj.jdbc.Driver");

       Connection con = DriverManager.getConnection(url,username,password);

        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

        ResultSet rs =stmt.executeQuery(Query);
        rs.absolute(4);

        rs.updateDouble(3,899.00);
        rs.updateRow();

        display();


    }

    public static void delete() throws Exception{

        String Query ="delete from books where book_id = 105";
        Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con = DriverManager.getConnection(url,username,password);
       Statement stmt = con.createStatement();
       int rowDeleted = stmt.executeUpdate(Query);
        System.out.println("Row Deleted "+ rowDeleted);

        System.out.println("After deleting the Record...");
        display();

    }

}
