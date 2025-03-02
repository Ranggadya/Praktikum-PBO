/*Nama File  : MMahasiswa.java
 * Deskripsi : Mengaplikasikan class Mahasiswa
 * Pembuat   : Ranggadya Aditama Ramadhani
 * Tanggal   : 02-03-2025
 */
public class MMahasiswa {
    public static void main(String[] args) {
        MataKuliah PBO = new MataKuliah("PBO", "Pemrograman Berorientasi Objek", 3);
        MataKuliah MBD = new MataKuliah("MBD", "Manajemen Basis Data", 3);
        Mahasiswa M1 = new Mahasiswa("234", "Citra", "Informatika");
        Mahasiswa M2 = new Mahasiswa("M002", "Siti Aminah", "Sistem Informasi");
        Dosen D1 = new Dosen("123", "Andi", "Informatika");
        Kendaraan K1 = new Kendaraan("H1234AB", "Motor");
        Kendaraan K2 = new Kendaraan("B5678EF", "Mobil");
        M1.setDosenWali(D1);
        M1.setKendaraan(K1);
        M1.addMatkul(PBO);
        M1.addMatkul(MBD);

        M2.setKendaraan(K2);
        M2.setDosenWali(D1);
        M2.addMatkul(MBD);
        M2.printDetailMhs();

        System.out.println("===== Data Mahasiswa 1 =====");
        M1.printDetailMhs();
        System.out.println("Total SKS: " + M1.getJumlahSKS());
        System.out.println("Total Mata Kuliah: " + M1.getJumlahMatkul());

        System.out.println("===== Data Mahasiswa 2 =====");
        M2.printDetailMhs();
        System.out.println("Total SKS: " + M2.getJumlahSKS());
        System.out.println("Total Mata Kuliah: " + M2.getJumlahMatkul());
    }

}
