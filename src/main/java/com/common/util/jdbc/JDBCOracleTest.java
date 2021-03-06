package com.common.util.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCOracleTest
{
    private static final String USER_ORACLE = "byd_portal_bpm";
    private static final String PASS_ORACLE = "byd_portal_bpm";
    
    private static final String DB_URL_ORACLE = "jdbc:oracle:thin:@10.9.37.113:1521/orcl";
    
    public static Connection getConnOracle(){
        Connection conn = null;
        
        try
        {
            // STEP 2: Register JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            // Open a connection
            conn = DriverManager.getConnection(DB_URL_ORACLE, USER_ORACLE, PASS_ORACLE);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        
        return conn;
    }
    
    
    public static void main(String[] args) throws Exception
    {
        
        Connection conn = null;
        Statement stmt = null;
        try{
           //STEP 3: Open a connection
           System.out.println("Connecting to database...");
           conn = getConnOracle();

           //STEP 4: Execute a query
           System.out.println("Creating statement...");
           stmt = conn.createStatement();
           String sql;
           sql = "SELECT id, name, age FROM testt";
           ResultSet rs = stmt.executeQuery(sql);

           //STEP 5: Extract data from result set
           while(rs.next()){
              //Retrieve by column name
              int id  = rs.getInt("id");
              int age = rs.getInt("age");
              String name = rs.getString("name");

              //Display values
              System.out.print("ID: " + id);
              System.out.print(", Age: " + age);
              System.out.print(", name: " + name);
           }
           //STEP 6: Clean-up environment
           rs.close();
           stmt.close();
           conn.close();
        }catch(SQLException se){
           //Handle errors for JDBC
           se.printStackTrace();
        }catch(Exception e){
           //Handle errors for Class.forName
           e.printStackTrace();
        }finally{
           //finally block used to close resources
           try{
              if(stmt!=null)
                 stmt.close();
           }catch(SQLException se2){
           }// nothing we can do
           try{
              if(conn!=null)
                 conn.close();
           }catch(SQLException se){
              se.printStackTrace();
           }//end finally try
        }//end try
        System.out.println("Goodbye!");
     }//end main
}
