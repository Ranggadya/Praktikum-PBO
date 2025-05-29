/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jdbc.program;

import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import jdbc.utilities.MySQLUtility;



public class JFrameUtama extends javax.swing.JFrame {

    private DefaultListModel<String> dlmId;
    private DefaultListModel<String> dlmNama;
    private int selectedIndex = -1;
    
    public JFrameUtama() {
        initComponents();
        setupListModels();
        setupEventHandlers();
        loadAllData(); // Load data saat aplikasi dimulai
    }
    
    private void setupListModels() {
        dlmId = new DefaultListModel<>();
        dlmNama = new DefaultListModel<>();
        
        listID.setModel(dlmId);
        listNama.setModel(dlmNama);
    }
    private void setupEventHandlers() {
        // List Selection Event - sinkronisasi antara listID dan listNama
        listID.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int index = listID.getSelectedIndex();
                if (index >= 0 && index < dlmId.getSize()) {
                    listNama.setSelectedIndex(index);
                    selectedIndex = index;
                    
                    // Isi form untuk edit dan hapus
                    String selectedId = dlmId.getElementAt(index);
                    String selectedName = dlmNama.getElementAt(index);
                    
                    jTextField3.setText(selectedId);
                    inputuntukEdit.setText(selectedName);
                    jTextField4.setText(selectedId);
                    inputuntukHapus.setText(selectedName);
                }
            }
        });
        
        listNama.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int index = listNama.getSelectedIndex();
                if (index >= 0 && index < dlmNama.getSize()) {
                    listID.setSelectedIndex(index);
                    selectedIndex = index;
                    
                    // Isi form untuk edit dan hapus
                    String selectedId = dlmId.getElementAt(index);
                    String selectedName = dlmNama.getElementAt(index);
                    
                    jTextField3.setText(selectedId);
                    inputuntukEdit.setText(selectedName);
                    jTextField4.setText(selectedId);
                    inputuntukHapus.setText(selectedName);
                }
            }
        });
        
        // Reset Index Button Event
        ButtonResetIndex.addActionListener(e -> resetForm());
        
        // Enter key events untuk text fields
        inputNama.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    tambahMahasiswa();
                }
            }
        });
        
        inputuntukEdit.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    editMahasiswa();
                }
            }
        });
        inputuntukHapus.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    deleteMahasiswa();
                }
            }
        });
    }
    
    private void loadAllData() {
        try {
            // Clear existing data
            dlmId.clear();
            dlmNama.clear();
            
            Connection conn = MySQLUtility.getConnection(); 
            String sql = "SELECT id, nama FROM mahasiswa ORDER BY id";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            // Tambahkan data ke list model
            while (rs.next()) {
                dlmId.addElement(String.valueOf(rs.getInt("id")));
                dlmNama.addElement(rs.getString("nama"));
            }
            
            rs.close();
            pst.close();
            conn.close();
            
            JOptionPane.showMessageDialog(this, "Data berhasil dimuat!", "Info", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error memuat data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error koneksi database. Pastikan MySQLUtility.getConnection() tersedia.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
        private void tambahMahasiswa() {
        String nama = inputNama.getText().trim();
        
        if (nama.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong!", "Warning", JOptionPane.WARNING_MESSAGE);
            inputNama.requestFocus();
            return;
        }
        
        try {
            Connection conn = MySQLUtility.getConnection();
            String sql = "INSERT INTO mahasiswa (nama) VALUES (?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nama);
            
            int result = pst.executeUpdate();
            
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan!", "Success", JOptionPane.INFORMATION_MESSAGE);
                inputNama.setText("");
                loadAllData(); // Refresh data
            }
            
            pst.close();
            conn.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error menambah data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error koneksi database.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    
    private void editMahasiswa() {
        String idText = jTextField3.getText().trim();
        String nama = inputuntukEdit.getText().trim();
        
        if (idText.isEmpty() || nama.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID dan Nama tidak boleh kosong!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            int id = Integer.parseInt(idText);
            
            Connection conn = MySQLUtility.getConnection();
            String sql = "UPDATE mahasiswa SET nama = ? WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nama);
            pst.setInt(2, id);
            
            int result = pst.executeUpdate();
            
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil diupdate!", "Success", JOptionPane.INFORMATION_MESSAGE);
                resetForm();
                loadAllData(); // Refresh data
            } else {
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            
            pst.close();
            conn.close();
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error mengupdate data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error koneksi database.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    private void deleteMahasiswa() {
        String idText = jTextField4.getText().trim();
        String nama = inputuntukHapus.getText().trim();
        
        if (idText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Konfirmasi hapus
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Apakah Anda yakin ingin menghapus data:\nID: " + idText + "\nNama: " + nama + "?", 
            "Konfirmasi Hapus", 
            JOptionPane.YES_NO_OPTION);
            
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                int id = Integer.parseInt(idText);
                
                Connection conn = MySQLUtility.getConnection();
                String sql = "DELETE FROM mahasiswa WHERE id = ?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setInt(1, id);
                
                int result = pst.executeUpdate();
                
                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Data berhasil dihapus!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    resetForm();
                    loadAllData(); // Refresh data
                } else {
                    JOptionPane.showMessageDialog(this, "Data tidak ditemukan!", "Warning", JOptionPane.WARNING_MESSAGE);
                }
                
                pst.close();
                conn.close();
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "ID harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error menghapus data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error koneksi database.", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }
    
    private void resetForm() {
        SwingUtilities.invokeLater(() -> {
            inputNama.setText("");
            jTextField3.setText("");
            inputuntukEdit.setText("");
            jTextField4.setText("");
            inputuntukHapus.setText("");
            
            listID.clearSelection();
            listNama.clearSelection();
            selectedIndex = -1;
            
            inputNama.requestFocus();
        });
    }
    private boolean isValidName(String nama) {
        return nama != null && !nama.trim().isEmpty() && nama.length() <= 100;
    }
    
    private void searchMahasiswa(String keyword) {
        try {
            dlmId.clear();
            dlmNama.clear();
            
            Connection conn = MySQLUtility.getConnection();
            String sql = "SELECT id, nama FROM mahasiswa WHERE nama LIKE ? ORDER BY id";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + keyword + "%");
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                dlmId.addElement(String.valueOf(rs.getInt("id")));
                dlmNama.addElement(rs.getString("nama"));
            }
            
            rs.close();
            pst.close();
            conn.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error mencari data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error koneksi database.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    
    
   

    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listID = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listNama = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        inputNama = new javax.swing.JTextField();
        buttonTambahkan = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        inputuntukEdit = new javax.swing.JTextField();
        inputuntukHapus = new javax.swing.JTextField();
        buttonEdit = new javax.swing.JButton();
        buttonDelette = new javax.swing.JButton();
        ButtonResetIndex = new javax.swing.JToggleButton();
        buttonAmbilSemuaData = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listID.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listID);

        listNama.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listNama);

        jLabel1.setText("id");

        jLabel2.setText("nam");

        jLabel3.setText("Kelola Data Mahasiswa");

        jLabel4.setText("nama");

        inputNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNamaActionPerformed(evt);
            }
        });

        buttonTambahkan.setText("Tambahkan");
        buttonTambahkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahkanActionPerformed(evt);
            }
        });

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        inputuntukEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputuntukEditActionPerformed(evt);
            }
        });

        buttonEdit.setText("edit");
        buttonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditActionPerformed(evt);
            }
        });

        buttonDelette.setText("hapus");
        buttonDelette.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeletteActionPerformed(evt);
            }
        });

        ButtonResetIndex.setText("Reset Indeks");

        buttonAmbilSemuaData.setText("Ambil Semua Data");
        buttonAmbilSemuaData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAmbilSemuaDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(51, 51, 51)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(inputNama, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonTambahkan)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputuntukHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonDelette, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputuntukEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(buttonAmbilSemuaData))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ButtonResetIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonAmbilSemuaData, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonTambahkan)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputuntukEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(inputuntukHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonDelette, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(ButtonResetIndex))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonDeletteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeletteActionPerformed
        deleteMahasiswa();        
    }//GEN-LAST:event_buttonDeletteActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        inputuntukEdit.requestFocus();
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
        inputuntukHapus.requestFocus();
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void inputuntukEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputuntukEditActionPerformed
        // TODO add your handling code here:
        editMahasiswa();
    }//GEN-LAST:event_inputuntukEditActionPerformed

    private void inputNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNamaActionPerformed
        // TODO add your handling code here:
        tambahMahasiswa();
    }//GEN-LAST:event_inputNamaActionPerformed

    private void buttonTambahkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahkanActionPerformed
        tambahMahasiswa();
    }//GEN-LAST:event_buttonTambahkanActionPerformed

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed
       editMahasiswa();
        
    }//GEN-LAST:event_buttonEditActionPerformed

    private void buttonAmbilSemuaDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAmbilSemuaDataActionPerformed
        // TODO add your handling code here:
        loadAllData();
    }//GEN-LAST:event_buttonAmbilSemuaDataActionPerformed
    private void ButtonResetIndexActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        resetForm();
    }
     public static void main(String args[]) {
        // Set Look and Feel
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton ButtonResetIndex;
    private javax.swing.JToggleButton buttonAmbilSemuaData;
    private javax.swing.JButton buttonDelette;
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonTambahkan;
    private javax.swing.JTextField inputNama;
    private javax.swing.JTextField inputuntukEdit;
    private javax.swing.JTextField inputuntukHapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JList<String> listID;
    private javax.swing.JList<String> listNama;
    // End of variables declaration//GEN-END:variables
}
