/*Nama File  : MKendaraan.java
 * Deskripsi : Mengaplikasikan class Kendaraan
 * Pembuat   : Ranggadya Aditama Ramadhani
 * Tanggal   : 02-03-2025
 */

public class MKendaraan {
    public static void main(String[] args) {
        Kendaraan kendaraan1 = new Kendaraan("AB1234CD", "Motor");
        Kendaraan kendaraan2 = new Kendaraan("B5678EF", "Mobil");

        
        System.out.println("===== Data Kendaraan =====");
        System.out.println("No Plat: " + kendaraan1.getNoPlat() + ", Jenis: " + kendaraan1.getJenis());
        System.out.println("No Plat: " + kendaraan2.getNoPlat() + ", Jenis: " + kendaraan2.getJenis());
    }
}
