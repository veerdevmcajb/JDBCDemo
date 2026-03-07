package connection;

import java.sql.*;
import java.util.Scanner;

public class Demo {

   private static final String url="jdbc:mysql://localhost:3306/jdbc";
   private static final String username="root";
   private static final String password="root12";


    public static void main(String[] args) throws Exception{

     //   Class.forName("com.mysql.cj.jdbc.Driver");
      //  Class.forName("com.mysql.cj.jdbc.Driver");

        // connection
        Connection connection = DriverManager.getConnection(url, username, password);

        Statement stmt = connection.createStatement();
        //String query="select * from students";
        ResultSet rs= stmt.executeQuery("select * from students");

        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            int marks=rs.getInt("marks");

            System.out.println(id + " " + name + " " + age + " "+marks);
        }

        connection.close();

        //insert();
       // update();
       // delete();
       // nsertUsingPreStmt();
        retrive();
    }

    public static void insert() throws Exception {

        Connection connection = DriverManager.getConnection(url,username,password);

        Statement statement= connection.createStatement();
        int rs=statement.executeUpdate("Insert into students values (3,'Veer',24,55),(4,'Shiv',26,80)");

        System.out.println(rs);
        connection.close();
    }


    public static void insertUsingPreStmt() throws Exception{

        Connection connection=DriverManager.getConnection(url,username,password);
        String query="insert into students values (?,?,?,?)";

        PreparedStatement preStmt = connection.prepareStatement(query);
        preStmt.setInt(1,4);
        preStmt.setString(2,"Shiv");
        preStmt.setInt(3,25);
        preStmt.setDouble(4,88);

        int res=preStmt.executeUpdate();

        System.out.println("New record Inserted..");

    }


    public static void update() throws Exception{
        Connection connection = DriverManager.getConnection(url,username,password);

        Statement stmt=connection.createStatement();
        int  res=stmt.executeUpdate("update students set marks=75 where id=3");

        System.out.println(res);
        connection.close();
    }

    public static void delete() throws Exception{
        Connection connection = DriverManager.getConnection(url,username,password);

        Statement stmt = connection.createStatement();
        int res=stmt.executeUpdate("delete from students where id=4");
        System.out.println("Record Deleted...");
        connection.close();
    }

    public static void retrive() throws Exception{

        Connection connection=DriverManager.getConnection(url,username,password);
        String query ="select marks from students where id= ? " ;
        PreparedStatement prestmt=connection.prepareStatement(query);
        prestmt.setInt(1,2);
        ResultSet res=prestmt.executeQuery();
        System.out.println("Query executed..");
        if(res.next()){
            double marks=res.getDouble("marks");
            System.out.println("Marks is "+ marks);
        }else {
            System.out.println("Marks Not Found...");
        }
        connection.close();
    }

    public static void insertrec() throws Exception{

        Connection connection=DriverManager.getConnection(url,username,password);

        Statement stmt = connection.createStatement();
        Scanner sc=new Scanner(System.in);
        while (true){
        System.out.println("Enter name ");
        }
    }

}

