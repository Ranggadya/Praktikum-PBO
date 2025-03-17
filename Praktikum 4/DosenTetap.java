/* 
Nama File   : DosenTetap.java
Deskripsi   : Berisi atribut dan method dalam class DosenTetap
Pembuat     : 24060123140196 Ranggadya Aditama Ramadhani
Tanggal     : 15 Maret 2024
*/


import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DosenTetap extends Dosen{
    private String NIDN;

    public DosenTetap(){
        super();
        this.NIDN = "";

    }
    
    public DosenTetap(String NIP,String NIDN, String nama, String Fakultas, LocalDate tanggalLahir, LocalDate TMT, double gajiPokok){
        super(NIP, nama, Fakultas,  tanggalLahir, TMT, gajiPokok, "Dosen Tetap");
        this.NIDN = NIDN;
    }

    public String getNIDN(){
        return NIDN;
    }
    
    public void setNIDN (String NIDN){
        this.NIDN = NIDN;
    }

    public LocalDate getBUP(){
        LocalDate BUP = tanggalLahir.plusYears(65);
        return LocalDate.of(BUP.getYear(),BUP.getMonth().plus(1), 1);
    }

    public String getMasaKerja(){
        LocalDate sekarang = LocalDate.now();
        Period period = Period.between(TMT, sekarang);
        int Tahun = period.getYears();
        int Bulan = period.getMonths();
        return Tahun + "Tahun" + Bulan + "Bulan";
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("NIDN                    : " + getNIDN());
        System.out.println("BUP (Batas Usia Pensiun): " + formatTanggal(getBUP()));
        System.out.println("Masa Kerja              : " + getMasaKerja());
        long tahunKerja = Period.between(TMT, LocalDate.now()).getYears();
        double tunjangan = 0.02 * tahunKerja * gajiPokok;
        System.out.printf("Tunjangan               : 2%% x %d x Rp %d = Rp %d\n", tahunKerja, (int) gajiPokok, (int) tunjangan);
    }

}
