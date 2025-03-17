/* 
Nama File   : MDosentetap.java
Deskripsi   : implementasikan class DosenTetap
Pembuat     : 24060123140196 Ranggadya Aditama Ramadhani
Tanggal     : 15 Maret 2024
*/

import java.time.LocalDate;

public class MDosenTetap {
    public static void main(String[] args) {
        // Membuat objek DosenTetap
        DosenTetap dosenTetap = new DosenTetap(
            "9545647548", "78647324", "Andi", "Fakultas Sains dan Matematika",
            LocalDate.of(1990, 5, 5), LocalDate.of(2015, 1, 1),
            5000000
        );
        
        // Menampilkan informasi masing-masing pegawai
        System.out.println("========================================");
        System.out.println("Informasi Dosen Tetap:");
        System.out.println("========================================");
        dosenTetap.printInfo();
        
    }
}