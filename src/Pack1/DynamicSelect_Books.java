package Pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DynamicSelect_Books {

    private static final String url = "jdbc:mysql://localhost:3306/advjdbc";
    private static final String username = "root";
    private static final String pass ="root12";


    public static void main(String[] args) throws Exception {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a price");
        double price = sc.nextDouble();

        Connection con = DriverManager.getConnection(url,username,pass);

        StringBuilder  sql = new StringBuilder("select * from books");

        if(price > 0){
            sql.append(" where book_price <= ? ");
        }

       PreparedStatement pstmt = con.prepareStatement(sql.toString());
        if(price > 0){
            pstmt.setDouble(1,price);
        }

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()){
            System.out.println(rs.getInt(1) + " " + rs.getString(2) +" "+ rs.getDouble(3));
        }

        con.close();

    }
}

/*
 in the above task we have conditional base search operation to acheive this requirement we need to
 prepare the query dynamically.
 if user don't give the price we need to execute query like below .
 ex. select * from books;

 - if user give the price then we neew to execute the Query like below.
    select 8 from books where price > ? ;

 */
