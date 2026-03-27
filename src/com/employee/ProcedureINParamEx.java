package com.employee;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public class ProcedureINParamEx {

    private static final String url = "jdbc:mysql://localhost:/advjdbc";
    private static final String userName = "root";
    private static final String pass ="root12";
    private static final String Procedure ="call getBookById(?)";

    public static void main(String[] args) throws Exception{

        Scanner sc =new Scanner(System.in);
        System.out.println("Enter Book Id");
        int bookid = sc.nextInt();

        Connection con = DriverManager.getConnection(url,userName,pass);

        CallableStatement cstmt = con.prepareCall(Procedure);
        cstmt.setInt(1, bookid);

        ResultSet rs = cstmt.executeQuery();

        while (rs.next()){
            System.out.println(rs.getInt(1) +" "+ rs.getString(2) + " " + rs.getDouble(3));
        }

        con.close();

    }
}
