/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Persie
 */
public class Database {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Connection con=null;
        Statement st=null;
        String url="jdbc:mysql://localhost:3306/student";
        String user="root";
        String password="1234";
       int rollno=101;
        String name="Mohit";
       float marks=89.9f;
        try
        {
            con=DriverManager.getConnection(url,user,password);
            st=con.createStatement();
         //String sql="create table info(rollno int,name varchar(26),marks float)";
           //String sql="insert into info(rollno,name,marks)"+"values('"+rollno+"','"+name+"','"+marks+"')";
     //   String sql ="delete from info where rollno="+101;
     // st.executeUpdate(sql);
      
   /*  String sql="select * from info";
     ResultSet rs=st.executeQuery(sql);
                 while(rs.next())
                 {
                     rollno=rs.getInt("rollno");    //brackets mei index h bc
                     name=rs.getString("name");
                     marks=rs.getFloat("marks");
                     System.out.println("Rollno :"+rollno+" name :"+name+" marks :"+marks);
                 }
*/
             System.out.println("connected");
             
        }
       
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
       //prepared statements
       int a=10;
       float b=20.6f;
       try
      {
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","1234");
           
           PreparedStatement stmt=con.prepareStatement("insert into result(rollno,marks) values(?,?)");
           stmt.setInt(1,101);         //format is first is index second id data bc ye b hota h
           stmt.setFloat(2,46.6f);
           
           int i=stmt.executeUpdate();
           System.out.println(i+"records inserted");

     /*      PreparedStatement stmt=con.prepareStatement("update result set marks=? where rollno=?");
           stmt.setFloat(1,78.6f);
           stmt.setInt(2,101);         //format is first is index second id data bc ye b hota h
           
           
           int i=stmt.executeUpdate();
           System.out.println(i+"records updated");
*/
    /*  PreparedStatement stmt=con.prepareStatement("delete info result student where rollno=?");
           stmt.setInt(1,101);         //format is first is index second id data bc ye b hota h
           int i=stmt.executeUpdate();
           System.out.println(i+"records updated");
       */}
       catch (Exception e)
       {
           e.printStackTrace();
       }
       
        
     
    }
    
}
