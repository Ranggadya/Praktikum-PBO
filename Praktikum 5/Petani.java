import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Petani extends Manusia {
    private String asal_kota;
    private static int counterPetani;

    public Petani(){
        super();
        this.asal_kota = "";
    }

    public Petani (String nama, String alamat, LocalDate tgl_mulai_kerja, double pendapatan, String asal_kota){
        super(nama, alamat, tgl_mulai_kerja, pendapatan);
        this.asal_kota = asal_kota;
        counterPetani++;
    }

    public String getAsal_Kota(){
        return asal_kota;
    }

    public void setAsal_Kota(String asal_kota){
        this.asal_kota = asal_kota;
    }

    public static int getCounterPetani(){
        return counterPetani;
    }

    @Override
    public double hitungPajak() { return 0; }
    @Override
    public int hitungMasaKerja() { 
        return (int) ChronoUnit.YEARS.between(tgl_mulai_kerja, LocalDate.now()) + 0; 
    }

    @Override
    public void cetakInfo() {
        super.cetakInfo();
        System.out.println("Daerah: " + asal_kota);
    }
    
}
