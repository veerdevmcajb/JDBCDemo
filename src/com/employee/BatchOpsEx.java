package com.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchOpsEx {
    private static final String url = "jdbc:mysql://localhost:3306/advjdbc";
    private static final String userName = "root";
    private static final String pass ="root12";

    public static void main(String[] args) throws Exception{

       Connection con = DriverManager.getConnection(url,userName,pass);
      Statement stmt = con.createStatement();
        stmt.addBatch("insert into books values (108,'Devops',2800)");
        stmt.addBatch("insert into books values (109,'DataSci',3800)");
        stmt.addBatch("insert into books values (110,'Linux',4800)");

        int[] count = stmt.executeBatch();
        System.out.println("Records Effected :: "+ count.length);
        con.close();

        System.out.println("Execution Completed...");
    }
}
