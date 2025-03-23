import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class MManusia {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        
        PNS p1 = new PNS("Satriyo", "Jl. Seroja", LocalDate.parse("01-04-2006", formatter), 15000000, "198302032006041002");
        Pengusaha pe1 = new Pengusaha("Adhy","Jl.Air", LocalDate.parse("01-01-2000", formatter),  55000000, "000-556-773-212-000-5");
        Petani pt1 = new Petani("Nugraha", "Jl. Bunga 9 Tembalang",LocalDate.parse("09-01-1977", formatter),  5000000, "Wonogiri");
        PNS p2 = new PNS("Panji", "Jl. Panorama 111 Tembalang", LocalDate.parse("01-04-2010", formatter),  10000000, "198004212010041002");

        System.out.println("Jumlah Manusia = " + Manusia.getCounterMns());
        System.out.println("Jumlah PNS = " + PNS.getCounterPNS());
        System.out.println("Jumlah Pengusaha = " + Pengusaha.getCounterPengusaha());
        System.out.println("Jumlah Petani = " + Petani.getCounterPetani());

        System.out.println("==================Pajak======================");
        System.out.println("Pajak PNS p1 = " + p1.hitungPajak());
        System.out.println("Pajak Pengusaha pe1 = " + pe1.hitungPajak());
        System.out.println("Pajak Petani pt1 = " + pt1.hitungPajak());

        System.out.println("================== Masa kerja ======================");
        System.out.println("Masa Kerja p1 = " + p1.hitungMasaKerja());
        System.out.println("Masa Kerja pe1 = " + pe1.hitungMasaKerja());
        System.out.println("Masa Kerja pt1 = " + pt1.hitungMasaKerja());

        System.out.println("========================================");
        p1.cetakInfo();
        System.out.println("========================================");
        pe1.cetakInfo();
        System.out.println("========================================");
        pt1.cetakInfo();
    }
}
