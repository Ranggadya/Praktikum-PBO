/* Nama File  : RuangDosen.java
 * Deskripsi : Membuat method dan atribut untuk RuangDosen
 * Pembuat   : Ranggadya Aditama Ramadhani
 * Tanggal   : 27-03-2025
 */


public class RuangDosen extends Ruang {
    private String namaDosen;
    private int jumlahKursi;
    private int jumlahMeja;
    

    public RuangDosen(){
        this.namaDosen = "";
        this.jumlahKursi = 0;
        this.jumlahMeja = 0;
    }
    
    public RuangDosen(String kode, double panjang, double lebar, double tinggi, int kapasitas, String namaDosen, int jumlahKursi, int jumlahMeja) {
        super(kode, panjang, lebar, tinggi, kapasitas);
        this.namaDosen = namaDosen;
        this.jumlahKursi = jumlahKursi;
        this.jumlahMeja = jumlahMeja;
        
    }
    
    public String getNamaDosen() {
        return namaDosen;
    }
    
    public void setNamaDosen(String namaDosen) {
        this.namaDosen = namaDosen;
    }
    
    public int getJumlahKursi() {
        return jumlahKursi;
    }
    
    public void setJumlahKursi(int jumlahKursi) {
        this.jumlahKursi = jumlahKursi;
    }
    
    public int getJumlahMeja() {
        return jumlahMeja;
    }
    
    public void setJumlahMeja(int jumlahMeja) {
        this.jumlahMeja = jumlahMeja;
    }
   
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Nama Dosen: " + namaDosen);
        System.out.println("Jumlah Kursi: " + jumlahKursi);
        System.out.println("Jumlah Meja: " + jumlahMeja);
        
    }
}
