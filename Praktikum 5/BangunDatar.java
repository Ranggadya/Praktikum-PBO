/* Nama File  : BangunDatar.java
 * Deskripsi : Membuat method dan atribut untuk BangunDatar
 * Pembuat   : Ranggadya Aditama Ramadhani
 * Tanggal   : 13-03-2025
 */


public abstract class BangunDatar {
    private int jmlSisi;
    private String warna;
    private String border;
    private static int counterBangunDatar = 0;

    public BangunDatar(){
        counterBangunDatar++;
    }

    public BangunDatar(int jmlSisi, String warna, String border){
        this.jmlSisi = jmlSisi;
        this.warna = warna;
        this.border = border;
        counterBangunDatar++;

    }

    public int getJmlSisi(){
        return jmlSisi;
    }

    public void setJmlSisi( int jmlSisi){
        this.jmlSisi = jmlSisi;
    }

    public String getwarna(){
        return warna;
    }

    public void setWarna(String Warna){
        this.warna = warna;
    }

    public String getBorder(){
        return border;
    }

    public void setBorder(String border){
        this.border = border;
    }

    public void printInfo(){
        System.out.println("Jumlah Sisi = " + jmlSisi);
        System.out.println("Warna = " + warna);
        System.out.println("Border = " + border);
    }

    public static void printCounterBangunDatar(){
        System.out.println("");
    }

    public abstract double getLuas();
    public abstract double getKeliling();

    public boolean isEqualLuas(BangunDatar X){
        return this.getLuas() == X.getLuas();
    }

    public boolean isEqualKeliling(BangunDatar X){
        return this.getKeliling() == X.getKeliling();
    }
    
}
