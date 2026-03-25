package Pack1;

import java.sql.*;
import java.util.Scanner;

public class Scanner_Ex {
    private static final String url ="jdbc:mysql://localhost:3306/advjdbc";
    private static final String username = "root";
    private static final String pass = "root12";
    private static final String InsertQuery = "insert into books values (?,?,?)";

    public static void main(String[] args) throws Exception{

        //insertData();
        display();
    }

    public static void insertData() throws Exception{
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Book_id");
        int id= sc.nextInt();

        System.out.println("Enter Book_name ");
        String name =sc.next();

        System.out.println("Enter book_price");
        double price = sc.nextDouble();

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(url,username,pass);
        System.out.println(con);

       PreparedStatement pstmt = con.prepareStatement(InsertQuery);
        pstmt.setInt(1,id);
        pstmt.setString(2,name);
        pstmt.setDouble(3,price);

      int count = pstmt.executeUpdate();
      System.out.println("Row Effected.." + count);
        con.close();

        display();
    }

    public static void display() throws Exception{

      Connection con = DriverManager.getConnection(url,username,pass);
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from books");
      while (rs.next()){
          System.out.println(rs.getInt(1)+"\t "+ rs.getString(2) + "\t\t" + rs.getDouble(3));

      }

      con.close();
    }
}
