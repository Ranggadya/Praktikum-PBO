/* 
Nama File   : Pegawai.java
Deskripsi   : Berisi atribut dan method dalam class Pegawi
Pembuat     : 24060123140196 Ranggadya Aditama Ramadhani
Tanggal     : 15 Maret 2024
*/

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pegawai {
    protected String NIP, nama, jabatan;
    protected LocalDate tanggalLahir, TMT;
    protected double gajiPokok;

    public Pegawai() {
        this.NIP = "";
        this.nama = "";
        this.jabatan = "";
        this.tanggalLahir = LocalDate.now();
        this.TMT = LocalDate.now();
        this.gajiPokok = 0;
    }


    public Pegawai(String NIP, String nama, LocalDate tanggalLahir, LocalDate TMT, double gajiPokok, String jabatan) {
        this.NIP = NIP;
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.TMT = TMT;
        this.gajiPokok = gajiPokok;
        this.jabatan = jabatan;
    }

    public String getNama(){
        return nama;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getNIP(){
        return NIP;
    }

    public void setNIP(String NIP){
        this.NIP = NIP;
    }

    public String getJabatan(){
        return jabatan;
    }

    public void setJabatan(String jabatan){
        this.jabatan = jabatan;
    }

    public LocalDate getTanggalLahir(){
        return tanggalLahir;
    }

    public void setTanggalLahir(LocalDate tanggalLahir){
        this.tanggalLahir = tanggalLahir;
    }

    public LocalDate getTMT(){
        return TMT;
    }

    public void setTMT(LocalDate TMT){
        this.TMT = TMT;
    }

    public double getGajiPokok(){
        return gajiPokok;
    }

    public void setGajiPokok(double gajiPokok){
        this.gajiPokok = gajiPokok;
    }

    public int masaKerja(){
        return LocalDate.now().getYear() - TMT.getYear();
    }

    public String formatTanggal(LocalDate tanggal) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        return tanggal.format(formatter);
    }

    

    public void printInfo() {
        System.out.println("NIP                     : " + getNIP());
        System.out.println("Nama                    : " + getNama());
        System.out.println("Jabatan                 : " + getJabatan());
        System.out.println("Tanggal Lahir           : " + formatTanggal(getTanggalLahir()));
        System.out.println("TMT                     : " + formatTanggal(getTMT()));
        System.out.printf("Gaji Pokok              : Rp %.0f\n", getGajiPokok());
    }


}