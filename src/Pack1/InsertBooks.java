package Pack1;

import java.sql.*;

public class InsertBooks {

    private static final String url="jdbc:mysql://localhost:3306/advjdbc";
    private static final String username="root";
    private static final String pass = "root12";
    private static final String InsertQuery ="Insert into books values (105,'Reach dad',650)";


    public static void main(String[] args)  throws Exception{

        // step 1 load the Driver

        Class.forName("com.mysql.cj.jdbc.Driver");

        insert();
        display();
        System.out.println();
        update();
    }

    public static void insert() throws Exception{

       Connection con = DriverManager.getConnection(url,username,pass);
       Statement stmt = con.createStatement();
       int rowAffected = stmt.executeUpdate(InsertQuery);
        System.out.println("Record Inserted "+  rowAffected);
        con.close();
    }

    public static void display() throws SQLException {

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
        System.out.println("Row Deleted..."+ res);

        display();

    }
}

