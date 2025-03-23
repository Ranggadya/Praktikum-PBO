
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public abstract class Manusia {
    protected String nama;
    protected String alamat;
    protected LocalDate tgl_mulai_kerja;
    protected double pendapatan;
    protected static int counterMns;

    public Manusia(){
        this.nama = "";
        this.alamat = "";
        this.tgl_mulai_kerja = LocalDate.now();
        this.pendapatan = 0;
    
    }

    public Manusia(String nama, String alamat, LocalDate tgl_mulai_kerja, double pendapatan){
        this.nama = nama;
        this.alamat = alamat;
        this.tgl_mulai_kerja = tgl_mulai_kerja;
        this.pendapatan = pendapatan;
        counterMns++;
    }

    public String getNama(){
        return nama;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getAlamat(){
        return alamat;
    }

    public void setAlamat(String nama){
        this.alamat = alamat;
    }

    public LocalDate getTglMulaiKerja(){
        return tgl_mulai_kerja;
    }

    public void setTglMulaiKerja(LocalDate tgl_mulai_kerja){
        this.tgl_mulai_kerja = tgl_mulai_kerja;
    }

    public void cetakInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Alamat: " + alamat);
        System.out.println("Tanggal Mulai Kerja: " + tgl_mulai_kerja);
        System.out.println("Pendapatan: " + pendapatan);
        System.out.println("Pajak: " + hitungPajak());
        System.out.println("Masa Kerja: " + hitungMasaKerja() + " tahun");
    }

    public static int getCounterMns(){
        return counterMns;
    }

    public abstract double hitungPajak();
    public int hitungMasaKerja(){
        return (int) ChronoUnit.YEARS.between(tgl_mulai_kerja, LocalDate.now());
    }


}
