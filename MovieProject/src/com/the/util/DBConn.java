package com.the.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConn {
    private static Connection con = null;
    private static Statement st = null;
    private static String user = "c##movie";
    private static String pw = "movie";
    private static String url = "jdbc:oracle:thin:@localhost:1521:xe";

    public static void connect() {
        try {
            if (con == null || con.isClosed()) {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                con = DriverManager.getConnection(url, user, pw);
                st = con.createStatement();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ResultSet statementQuery(String query) {
        connect();
        try {
            return st.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int statementUpdate(String sql) {
        connect();
        try {
            return st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void close() {
        try {
            if (st != null) st.close();
            if (con != null) con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

