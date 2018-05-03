package com.common.util.jdbc;

import java.sql.*;


public class JDBCMysqlTest2 {
    private static final String USER_MYSQL = "raine";
    private static final String PASS_MYSQL = "123456";

    private static final String DB_URL_MYSQL = "jdbc:mysql://localhost:3306/test";

    public static Connection getConnMysql() {
        Connection conn = null;

        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Open a connection
            conn = DriverManager.getConnection(DB_URL_MYSQL, USER_MYSQL, PASS_MYSQL);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void main(String[] args) throws Exception {
        String nameParam = "'or '1'='1";
        String passwordParam = "'or '1'='1";

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT * FROM user where name='" + nameParam +
                    "' and password='" + passwordParam + "'";
            // STEP 1: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL_MYSQL, USER_MYSQL, PASS_MYSQL);
            // STEP 3: Get a PreparedStatement
            stmt = conn.prepareStatement(sql);
//            stmt.setString(1,nameParam);
//            stmt.setString(2,passwordParam);
            System.out.println(sql);
            // STEP 4: Execute a query
            ResultSet rs = stmt.executeQuery();
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
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
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main
}
