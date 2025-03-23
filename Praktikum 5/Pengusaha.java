import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Pengusaha extends Manusia{
    private String npwp;
    private static int counterPengusaha; 
    
    public Pengusaha(){
        super();
        this.npwp = "";
    }

    public Pengusaha(String nama, String alamat, LocalDate tgl_mulai_kerja, double pendapatan, String npwp){
        super(nama, alamat, tgl_mulai_kerja, pendapatan);
        this.npwp = npwp;
        counterPengusaha++;
    }

    public String getNPWP(){
        return npwp;
    }

    public void setNPWP(String npwp){
        this.npwp = npwp;
    }

    public static int getCounterPengusaha(){
        return counterPengusaha;
    }

    @Override
    public double hitungPajak(){
        return 0.15 * pendapatan;
    }

    @Override
    public int hitungMasaKerja(){
        return (int) ChronoUnit.YEARS.between(tgl_mulai_kerja, LocalDate.now()) + 1;
    }

    @Override
    public void cetakInfo() {
        super.cetakInfo();
        System.out.println("NPWP: " + npwp);
    }
    
}
