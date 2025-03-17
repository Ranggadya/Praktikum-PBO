/* 
Nama File   : MDosenTamu.java
Deskripsi   : implementasikan class DosenTamu
Pembuat     : 24060123140196 Ranggadya Aditama Ramadhani
Tanggal     : 15 Maret 2024
*/

import java.time.LocalDate;

public class MDosenTamu {
    public static void main(String[] args){
     // Membuat objek DosenTamu
        DosenTamu dosenTamu = new DosenTamu(
            "9876543210", "12345678", "Budi",
            LocalDate.of(1985, 10, 20), LocalDate.of(2020, 7, 15),
            4000000, "Fakultas Teknik", 24
        );
    
        System.out.println("\n========================================");
        System.out.println("Informasi Dosen Tamu:");
        System.out.println("========================================");
        dosenTamu.printInfo();
        
    }
}
