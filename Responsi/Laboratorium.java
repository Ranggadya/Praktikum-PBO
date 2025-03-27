/* Nama File  : Laboratorium.java
 * Deskripsi : Membuat method dan atribut untuk Laboratorium
 * Pembuat   : Ranggadya Aditama Ramadhani
 * Tanggal   : 27-03-2025
 */

public class Laboratorium extends Ruang {
    private String namaLab;
    private double hargaSewa;
    private double tarifKebersihan;

    public Laboratorium(){
        this.namaLab = "";
        this.hargaSewa = 0;
        this.tarifKebersihan = 0;
    }
    
    public Laboratorium(String kode, double panjang, double lebar, double tinggi, int kapasitas, String namaLab, double hargaSewa) {
        super(kode, panjang, lebar, tinggi, kapasitas);
        this.namaLab = namaLab;
        this.hargaSewa = hargaSewa;
    }
    
    public String getNamaLab() {
        return namaLab;
    }
    
    public void setNamaLab(String namaLab) {
        this.namaLab = namaLab;
    }
    
    public double getHargaSewa() {
        return hargaSewa;
    }
    
    public void setHargaSewa(double hargaSewa) {
        this.hargaSewa = hargaSewa;
    }

    public double getTarifKebersihan(){
        return tarifKebersihan;
    }

    public void setTarifKebersihan(double tarifKebersihan){
        this.tarifKebersihan = tarifKebersihan;
    }
    
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Nama Laboratorium: " + namaLab);
        System.out.println("Harga Sewa: " + hargaSewa);
        System.out.println("Biaya Kebersihan: " + hitungBiayaKebersihan(tarifKebersihan ));
    }
}