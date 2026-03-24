package Pack1;

import java.sql.*;

public class InsertBooks {

    private static final String url="jdbc:mysql://localhost:3306/advjdbc";
    private static final String username="root";
    private static final String pass = "root12";
    private static final String InsertQuery ="Insert into books values (102,'Questions Are the Answer',550)";


    public static void main(String[] args)  throws Exception{

        // step 1 load the Driver

        Class.forName("com.mysql.cj.jdbc.Driver");

        // step 2 get database connection

     Connection con = DriverManager.getConnection(url, username,pass);
     System.out.println(con);

     // step 3  create a statement
        Statement stmt = con.createStatement();

        // step 4 Execute query
        int row_Effected = stmt.executeUpdate(InsertQuery);

        // step 5 Process result
        System.out.println("Record Inserted Count " + row_Effected);

        // step 6 close the connection
        con.close();
        disply();
        System.out.println();
        update();
    }

    public static void insert(){

    }

    public static void disply() throws SQLException {

        Connection con = DriverManager.getConnection(url,username,pass);

        Statement stmt = con.createStatement();

        ResultSet res = stmt.executeQuery("Select * from books");

        while (res.next()){
            int id = res.getInt("book_id");
            String name = res.getString("book_name");
            int price = res.getInt("book_price");

            System.out.println("Id "+ id + " BookName " + name + " BookPrice " + price);
        }
    }

    public static void update() throws Exception{

        Connection con =DriverManager.getConnection(url,username,pass);

        Statement stmt = con.createStatement();

        int res = stmt.executeUpdate("delete from books where book_id = 102");

        disply();

    }
}

