/* Nama File  : RuangDepartmen.java
 * Deskripsi : Membuat method dan atribut untuk RuangDepart
 * Pembuat   : Ranggadya Aditama Ramadhani
 * Tanggal   : 27-03-2025
 */


public class RuangDepartemen extends Ruang {
    private int jumlahMeja;
    private int jumlahKursi;
    private int jumlahLemari;
    private String namaDepartemen;
    private String ketuaDepartemen;
  

    public RuangDepartemen(){
        this.jumlahKursi = 0;
        this.jumlahLemari=0;
        this.jumlahMeja=0;
        this.namaDepartemen = "";
        this.ketuaDepartemen ="";
        
    }

    public RuangDepartemen(String kode, double panjang, double lebar, double tinggi, int kapasitas, int jumlahMeja, int jumlahKursi, int jumlahLemari, String namaDepartemen, String ketuaDepartemen) {
        super(kode, panjang, lebar, tinggi, kapasitas);
        this.jumlahMeja = jumlahMeja;
        this.jumlahKursi = jumlahKursi;
        this.jumlahLemari = jumlahLemari;
        this.namaDepartemen = namaDepartemen;
        this.ketuaDepartemen = ketuaDepartemen;
     
    }

    public int getJumlahMeja() {
        return jumlahMeja;
    }

    public void setJumlahMeja(int jumlahMeja) {
        this.jumlahMeja = jumlahMeja;
    }

    public int getJumlahKursi() {
        return jumlahKursi;
    }

    public void setJumlahKursi(int jumlahKursi) {
        this.jumlahKursi = jumlahKursi;
    }

    public int getJumlahLemari() {
        return jumlahLemari;
    }

    public void setJumlahLemari(int jumlahLemari) {
        this.jumlahLemari = jumlahLemari;
    }

    public String getNamaDepartemen() {
        return namaDepartemen;
    }

    public void setNamaDepartemen(String namaDepartemen) {
        this.namaDepartemen = namaDepartemen;
    }

    public String getKetuaDepartemen() {
        return ketuaDepartemen;
    }

    public void setKetuaDepartemen(String ketuaDepartemen) {
        this.ketuaDepartemen = ketuaDepartemen;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Nama Departemen: " + namaDepartemen);
        System.out.println("Ketua Departemen: " + ketuaDepartemen);
        System.out.println("Jumlah Meja: " + jumlahMeja);
        System.out.println("Jumlah Kursi: " + jumlahKursi);
        System.out.println("Jumlah Lemari: " + jumlahLemari);
    
    }
}
