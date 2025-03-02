/*Nama File  : MDosen.java
 * Deskripsi : Mengaplikasikan class Dosen
 * Pembuat   : Ranggadya Aditama Ramadhani
 * Tanggal   : 02-03-2025
 */
public class MDosen {
    public static void main(String[] args) {
        Dosen dosen1 = new Dosen("D001", "Dr. Budi Santoso", "Teknik Informatika");
        Dosen dosen2 = new Dosen("D002", "Prof. Ani Rahmawati", "Sistem Informasi");

        
        System.out.println("===== Data Dosen =====");
        System.out.println("NIP: " + dosen1.getNip() + ", Nama: " + dosen1.getNama() + ", Prodi: " + dosen1.getProdi());
        System.out.println("NIP: " + dosen2.getNip() + ", Nama: " + dosen2.getNama() + ", Prodi: " + dosen2.getProdi());
    }
}
