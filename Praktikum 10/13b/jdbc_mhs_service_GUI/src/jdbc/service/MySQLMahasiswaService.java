/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc.service;

import jdbc.utilities.MySQLUtility;
import jdbc.model.Mahasiswa;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLMahasiswaService {
    
    // Membuat objek Mahasiswa dari ResultSet
    private Mahasiswa makeMhsObject(ResultSet rs) throws SQLException {
        Mahasiswa mhs = new Mahasiswa();
        mhs.setId(rs.getInt("id"));
        mhs.setNama(rs.getString("nama"));
        return mhs;
    }
    
    // Menambahkan data mahasiswa (untuk AUTO_INCREMENT ID)
    public boolean add(Mahasiswa mhs) {
        String sql = "INSERT INTO mahasiswa (nama) VALUES (?)";
        try (Connection conn = MySQLUtility.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            ps.setString(1, mhs.getNama());
            int rowsAffected = ps.executeUpdate();
            
            if (rowsAffected > 0) {
                // Ambil ID yang di-generate
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        mhs.setId(generatedKeys.getInt(1));
                    }
                }
                return true;
            }
            return false;
            
        } catch (SQLException e) {
            System.err.println("Error tambah data: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    // Menambahkan data mahasiswa dengan ID manual (jika diperlukan)
    public boolean addWithId(Mahasiswa mhs) {
        String sql = "INSERT INTO mahasiswa (id, nama) VALUES (?, ?)";
        try (Connection conn = MySQLUtility.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, mhs.getId());
            ps.setString(2, mhs.getNama());
            int rowsAffected = ps.executeUpdate();
            
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Error tambah data dengan ID: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    // Mengupdate data mahasiswa
    public boolean update(Mahasiswa mhs) {
        String sql = "UPDATE mahasiswa SET nama = ? WHERE id = ?";
        try (Connection conn = MySQLUtility.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, mhs.getNama());
            ps.setInt(2, mhs.getId());
            int rowsAffected = ps.executeUpdate();
            
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Error update data: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    // Menghapus data mahasiswa berdasarkan ID
    public boolean delete(int id) {
        String sql = "DELETE FROM mahasiswa WHERE id = ?";
        try (Connection conn = MySQLUtility.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Error delete data: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    // Mengambil mahasiswa berdasarkan ID
    public Mahasiswa getById(int id) {
        Mahasiswa mhs = null;
        String sql = "SELECT * FROM mahasiswa WHERE id = ?";
        
        try (Connection conn = MySQLUtility.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    mhs = makeMhsObject(rs);
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Error getById: " + e.getMessage());
            e.printStackTrace();
        }
        
        return mhs;
    }
    
    // Mengambil semua data mahasiswa
    public List<Mahasiswa> getAll() {
        List<Mahasiswa> list = new ArrayList<>();
        String sql = "SELECT * FROM mahasiswa ORDER BY id";
        
        try (Connection conn = MySQLUtility.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Mahasiswa mhs = makeMhsObject(rs);
                list.add(mhs);
            }
            
        } catch (SQLException e) {
            System.err.println("Error getAll: " + e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }
    
    // Mencari mahasiswa berdasarkan nama (LIKE search)
    public List<Mahasiswa> searchByNama(String keyword) {
        List<Mahasiswa> list = new ArrayList<>();
        String sql = "SELECT * FROM mahasiswa WHERE nama LIKE ? ORDER BY id";
        
        try (Connection conn = MySQLUtility.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, "%" + keyword + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Mahasiswa mhs = makeMhsObject(rs);
                    list.add(mhs);
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Error searchByNama: " + e.getMessage());
            e.printStackTrace();
        }
        
        return list;
    }
    
    // Mengecek apakah mahasiswa dengan ID tertentu ada
    public boolean exists(int id) {
        String sql = "SELECT COUNT(*) FROM mahasiswa WHERE id = ?";
        
        try (Connection conn = MySQLUtility.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Error exists: " + e.getMessage());
            e.printStackTrace();
        }
        
        return false;
    }
    
    // Mendapatkan jumlah total mahasiswa
    public int getCount() {
        String sql = "SELECT COUNT(*) FROM mahasiswa";
        
        try (Connection conn = MySQLUtility.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                return rs.getInt(1);
            }
            
        } catch (SQLException e) {
            System.err.println("Error getCount: " + e.getMessage());
            e.printStackTrace();
        }
        
        return 0;
    }
    
    // Method untuk test koneksi
    public boolean testConnection() {
        try (Connection conn = MySQLUtility.getConnection()) {
            return conn != null && !conn.isClosed();
        } catch (SQLException e) {
            System.err.println("Error test connection: " + e.getMessage());
            return false;
        }
    }
}