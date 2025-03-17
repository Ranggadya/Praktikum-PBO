/* 
Nama File   : DosenTamu.java
Deskripsi   : Berisi atribut dan method dalam class DosenTamu
Pembuat     : 24060123140196 Ranggadya Aditama Ramadhani
Tanggal     : 15 Maret 2024
*/

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;


public class DosenTamu extends Dosen{
    private String NIDK;
    private int masaKontrak;
    private LocalDate tanggalAkhirKontrak;

    public DosenTamu() {
        super();
        this.NIDK = "";
        this.masaKontrak = 0;
        this.tanggalAkhirKontrak = LocalDate.now();
    }

    public DosenTamu(String NIP, String NIDK, String nama, LocalDate tanggalLahir, LocalDate TMT, double gajiPokok, String Fakultas, int masaKontrak) {
        super(NIP, nama, Fakultas, tanggalLahir, TMT, gajiPokok, "Dosen Tamu");
        this.masaKontrak = masaKontrak;
        this.NIDK = NIDK;
        this.tanggalAkhirKontrak = LocalDate.now().plusMonths(masaKontrak);
    }

    public String getNIDK() { 
        return NIDK; 
    }

    public void setNIDK(String NIDK) { 
        this.NIDK = NIDK; 
    }

    public int getMasaKontrak() { 
        return masaKontrak; 
    }

    public void setMasaKontrak(int masaKontrak) { 
        this.masaKontrak = masaKontrak; 
    }

    public LocalDate getTanggalAkhirKontrak() { 
        return tanggalAkhirKontrak; 
    }

    public String getSisaKontrak() {
        LocalDate sekarang = LocalDate.now();
        
        if (sekarang.isAfter(tanggalAkhirKontrak)) {
            return "Masa kontrak sudah berakhir :)";
        }

        Period period = Period.between(sekarang, tanggalAkhirKontrak);
        int Tahun = period.getYears();
        int Bulan = period.getMonths();

        long sisaBulan = ChronoUnit.MONTHS.between(sekarang, tanggalAkhirKontrak);
        return sisaBulan + " bulan";
    }

    public String getMasaKerja() {
        LocalDate sekarang = LocalDate.now();
        Period period = Period.between(TMT, sekarang);
        int Tahun = period.getYears();
        int Bulan = period.getMonths();
        return Tahun + " tahun " + Bulan + " bulan";
    }
    
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("NIDK                    : " + NIDK);
        System.out.println("Tanggal Akhir Kontrak   : " + formatTanggal(tanggalAkhirKontrak));
        System.out.println("Masa Kerja              : " + getMasaKerja());
        System.out.println("Sisa Kontrak            : " + getSisaKontrak());
        double tunjangan = 0.025 * gajiPokok;
        System.out.printf("Tunjangan               : 2,5%% x Rp %d = Rp %d\n", (int) gajiPokok, (int) tunjangan);
    }
    
}
