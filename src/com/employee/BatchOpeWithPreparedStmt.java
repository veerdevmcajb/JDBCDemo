package com.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class BatchOpeWithPreparedStmt {

    private static final String url = "jdbc:mysql://localhost:3306/advjdbc";
    private static final String userName = "root";
    private static final String pass ="root12";

    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);

        Connection con = DriverManager.getConnection(url,userName,pass);
       PreparedStatement pstmt = con.prepareStatement("insert into books values (?,?,?)");

       con.setAutoCommit(false);

       while (true) {
           System.out.println("Enter book id , name and Price");
           int bookId = sc.nextInt();
           String bookName = sc.next();
           Double bookPrice = sc.nextDouble();


           pstmt.setInt(1, bookId);
           pstmt.setString(2, bookName);
           pstmt.setDouble(3, bookPrice);
           pstmt.addBatch();

           System.out.println("Do you want to add more records? (yes/no)");
           String choice = sc.next();

           if (choice.equalsIgnoreCase("no")) {
               break;
           }
       }

       int [] res = pstmt.executeBatch();
       con.commit();
        System.out.println("Records Effected :: "+ res.length);
        con.close();


    }
}
