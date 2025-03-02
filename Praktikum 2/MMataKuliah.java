/*Nama File  : MMataKuliah.java
 * Deskripsi : Mengaplikasikan class MataKuliah
 * Pembuat   : Ranggadya Aditama Ramadhani
 * Tanggal   : 02-03-2025
 */
public class MMataKuliah {
    public static void main(String[] args) {
        
        MataKuliah mk1 = new MataKuliah("MK001", "Pemrograman Java", 3);
        MataKuliah mk2 = new MataKuliah("MK002", "Struktur Data", 4);
        MataKuliah mk3 = new MataKuliah("MK003", "Basis Data", 3);

        
        System.out.println("===== Daftar Mata Kuliah =====");
        System.out.println(mk1.getidMatkul() + " - " + mk1.getNama() + " (" + mk1.getSKS() + " SKS)");
        System.out.println(mk2.getidMatkul() + " - " + mk2.getNama() + " (" + mk2.getSKS() + " SKS)");
        System.out.println(mk3.getidMatkul() + " - " + mk3.getNama() + " (" + mk3.getSKS() + " SKS)");
    }
}
