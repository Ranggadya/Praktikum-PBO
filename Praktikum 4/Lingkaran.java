/* 
Nama File   : Lingkaran.java
Deskripsi   : Berisi atribut dan method dalam class Lingkaran
Pembuat     : 24060123140196 Ranggadya Aditama Ramadhani
Tanggal     : 13 Maret 2024
*/

public class Lingkaran extends BangunDatar {
    private double jari;

    public Lingkaran(){   
    }

    public Lingkaran(double diameter, String warna, String border){
        super(0,warna,border);
        this.jari = diameter / 2;
    }
    public double getJari() {
        return jari;
    }

    public void setJari(double jari) {
        this.jari = jari;
    }

    public double getLuas() {
        return Math.PI * jari * jari;
    }

    public double getKeliling() {
        return 2 * Math.PI * jari;
    }
    
}
