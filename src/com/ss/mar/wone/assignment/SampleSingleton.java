package com.ss.mar.wone.assignment;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;


// Class can't be static unless nested
public class SampleSingleton {

    // Volatile variables, since we're making sure they're thread-safe
    volatile private static Connection conn = null;
    volatile private static SampleSingleton instance = null;

    // Added private constructor
    private SampleSingleton() {}

    // public static SampleSingleton getInstance() {return instance;}
    public static SampleSingleton getInstance() {
        if (instance == null) {
            synchronized (instance) {
                if (instance == null) {
                    instance = new SampleSingleton();
                }
            }
        }

        return instance;
    }

    // error handling, correct type manipulation
    public static void databaseQuery(BigDecimal input) {
        if (conn == null) {
            synchronized (conn) {
                if (conn == null) {
                    try {
                        conn = DriverManager.getConnection("url of database");
                    } catch (SQLException e) {
                        System.err.println("Couldn't connect to DB");
                        //e.printStackTrace();
                    }
                }
            }
        }

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select id from table");
            BigDecimal x = new BigDecimal(0);
            while(rs.next()) {
                x = input.multiply(new BigDecimal(rs.getInt(1)));
            }
        } catch (SQLException e) {
            System.err.println("Error with query");
            //e.printStackTrace();
        }
    }

//    public static void databaseQuery(BigDecimal input) {
//        conn = DriverManager.getConnection("url of database");
//        Statement st = conn.createStatement();
//        ResultSet rs = st.executeQuery("select id from table");
//        int x = 0;
//        while(rs.next()) {
//            x = rs.getInt(1) * input;
//        }
//    }

}