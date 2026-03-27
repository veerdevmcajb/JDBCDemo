package com.employee;

import java.sql.*;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class ProcedureINOUTParamEx2 {

    private static final String url = "jdbc:mysql://localhost:3306/advjdbc";
    private static final String userName = "root";
    private static final String pass ="root12";
    private static final String Procedure ="call getBookNameByPrice(?,?)";

    public static void main(String[] args)  throws Exception{

        Scanner sc =new Scanner(System.in);
        System.out.println("Enter Book price");
        double bprice = sc.nextDouble();

       Connection con = DriverManager.getConnection(url,userName,pass);
       CallableStatement cstmt = con.prepareCall(Procedure);

        cstmt.setDouble(1, bprice);
        cstmt.registerOutParameter(2, Types.VARCHAR);

       ResultSet rs  = cstmt.executeQuery();

       while (rs.next()){
           System.out.println(rs.getString(1));
       }

       con.close();
    }
}
