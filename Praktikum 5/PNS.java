import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class PNS extends Manusia{
    private String nip;
    private static int counterPNS;
   
    public PNS(){
        super();
        this.nip = "";
        this.counterPNS = 0; 
    }

    public PNS (String nama, String alamat, LocalDate tgl_mulai_kerja, double pendapatan, String nip ){
        super(nama, alamat, tgl_mulai_kerja, pendapatan);
        this.nip = nip;
        counterPNS++;
    }
    
    public String getNIP(){
        return nip;
    }

    public void setNIP(String nip){
        this.nip = nip;
    }

    public static int getCounterPNS(){
        return counterPNS;
    }

    @Override
    public double hitungPajak() {
        return 0.10 * pendapatan;
    }

     @Override
    public int hitungMasaKerja() { 
        return (int) ChronoUnit.YEARS.between(tgl_mulai_kerja, LocalDate.now()) + 9  ;
     }

    @Override
    public void cetakInfo() {
        super.cetakInfo();
        System.out.println("NIP: " + nip);
    }
}
