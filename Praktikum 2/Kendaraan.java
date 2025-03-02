/*Nama File  : kendaraan.java
 * Deskripsi : berisi atribut dan method dalam class Kendaraan
 * Pembuat   : Ranggadya Aditama Ramadhani
 * Tanggal   : 02-03-2025
 */
public class Kendaraan {
    private String noPlat, jenis;

    public Kendaraan(){
        this.noPlat = "";
        this.jenis = "";
    }

    public Kendaraan(String noPlat, String jenis){
        this.noPlat = noPlat;
        this.jenis = jenis;
    }

    String getNoPlat(){
        return noPlat;
    }

    String getJenis(){
        return jenis;
    }

    void setNoPlat(String noPlat){
        this.noPlat = noPlat;
    }

    void setJenis(String jenis){
        this.jenis = jenis;
    }

}
