/*Nama File  :Dosen.java
 * Deskripsi : berisi atribut dan method dalam class Dosen
 * Pembuat   : Ranggadya Aditama Ramadhani
 * Tanggal   : 02-03-2025
 */
public class Dosen {
    private String nip;
    private String nama;
    private String prodi;

    public Dosen(){
        this.nip = "";
        this.nama = "";
        this.prodi = "";
    }

    public Dosen(String nip, String nama, String prodi){
        this.nip = nip;
        this.nama = nama;
        this.prodi = prodi;
    }

    String getNip(){
        return nip;
    }

    String getNama(){
        return nama;
    }

    String getProdi(){
        return prodi;
    }

    void setNip(String nip){
        this.nip = nip;
    }

    void setNama(String nama){
        this.nama = nama;
    }

    void setProdi(String prodi){
        this.prodi = prodi;
    }
}
