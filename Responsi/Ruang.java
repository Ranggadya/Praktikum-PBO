/* Nama File  : Ruang.java
 * Deskripsi : Membuat method dan atribut untuk Ruang
 * Pembuat   : Ranggadya Aditama Ramadhani
 * Tanggal   : 27-03-2025
 */


public class Ruang {
    protected String kode;
    protected double panjang, lebar, tinggi;
    protected int kapasitas;

    public Ruang(){
        this.kode = "";
        this.panjang = 0;
        this.lebar = 0;
        this.kapasitas = 0;
    }
    
    public Ruang(String kode, double panjang, double lebar, double tinggi, int kapasitas) {
        this.kode = kode;
        this.panjang = panjang;
        this.lebar = lebar;
        this.tinggi = tinggi;
        this.kapasitas = kapasitas;
    }
    
    public String getKode() {
        return kode;
    }
    
    public void setKode(String kode) {
        this.kode = kode;
    }
    
    public double getPanjang() {
        return panjang;
    }
    
    public void setPanjang(double panjang) {
        this.panjang = panjang;
    }
    
    public double getLebar() {
        return lebar;
    }
    
    public void setLebar(double lebar) {
        this.lebar = lebar;
    }
    
    public double getTinggi() {
        return tinggi;
    }
    
    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }
    
    public int getKapasitas() {
        return kapasitas;
    }
    
    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }
    
    public double hitungBiayaKebersihan(double tarif) {
        return panjang * lebar * tarif;
    }
    
    public void tampilkanInfo() {
        System.out.println("Kode Ruang: " + kode);
        System.out.println("Dimensi: " + panjang + "x" + lebar + "x" + tinggi);
        System.out.println("Kapasitas: " + kapasitas);
    }
}
