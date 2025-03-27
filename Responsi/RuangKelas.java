/* Nama File  : RuangDosen.java
 * Deskripsi : Membuat method dan atribut untuk RuangDosen
 * Pembuat   : Ranggadya Aditama Ramadhani
 * Tanggal   : 27-03-2025
 */


public class RuangKelas extends Ruang {
    private int kursiTersedia, kursiRusak;
   

    public RuangKelas(){
        this.kursiTersedia =0;
        this.kursiRusak =0;
    }
    
    public RuangKelas(String kode, double panjang, double lebar, double tinggi, int kapasitas, int kursiTersedia, int kursiRusak) {
        super(kode, panjang, lebar, tinggi, kapasitas);
        this.kursiTersedia = kursiTersedia;
        this.kursiRusak = kursiRusak;
    }
    
    public int getKursiTersedia() {
        return kursiTersedia;
    }
    
    public void setKursiTersedia(int kursiTersedia) {
        this.kursiTersedia = kursiTersedia;
    }
    
    public int getKursiRusak() {
        return kursiRusak;
    }
    
    public void setKursiRusak(int kursiRusak) {
        this.kursiRusak = kursiRusak;
    }

    @Override
    public double hitungBiayaKebersihan(double tarif) {
        return super.hitungBiayaKebersihan(tarif);
    }
    
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Kursi Tersedia: " + kursiTersedia);
        System.out.println("Kursi Rusak: " + kursiRusak);
    }
}
