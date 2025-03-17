/* 
Nama File   : MTendik.java
Deskripsi   : implementasikan class tendik
Pembuat     : 24060123140196 Ranggadya Aditama Ramadhani
Tanggal     : 15 Maret 2024
*/


import java.time.LocalDate;

public class MTendik {
    public static void main(String [] args){
        
        // Membuat objek Tendik
        Tendik tendik = new Tendik(
            "1234567890", "Citra",
            LocalDate.of(1980, 3, 15), LocalDate.of(2005, 6, 1),
            3500000, "Administrasi Akademik"
        );

        System.out.println("\n========================================");
        System.out.println("Informasi Tendik:");
        System.out.println("========================================");
        tendik.printInfo();
    }
    
}
