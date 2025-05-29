/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */

public class MySQLUtility {
    private static final String URL = "jdbc:mysql://localhost:3306/pbo";
    private static final String USERNAME = "root"; // atau username MySQL Anda
    private static final String PASSWORD = ""; // atau password MySQL Anda
    
    public static Connection getConnection() throws SQLException {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Buat koneksi
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Koneksi database berhasil!");
            return conn;
            
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver tidak ditemukan!");
            e.printStackTrace();
            throw new SQLException("Driver tidak ditemukan", e);
        } catch (SQLException e) {
            System.err.println("Gagal membuat koneksi: " + e.getMessage());
            throw e;
        }
    }
    
    // Method untuk test koneksi
    public static boolean testConnection() {
        try {
            Connection conn = getConnection();
            conn.close();
            return true;
        } catch (SQLException e) {
            System.err.println("Test koneksi gagal: " + e.getMessage());
            return false;
        }
    }
}