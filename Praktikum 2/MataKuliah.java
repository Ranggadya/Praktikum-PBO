/*Nama File  : MataKuliah.java
 * Deskripsi : berisi atribut dan method dalam class MataKuliah
 * Pembuat   : Ranggadya Aditama Ramadhani
 * Tanggal   : 02-03-2025
 */

public class MataKuliah {
    private String idMatkul, nama;
    private int sks;

    public MataKuliah(){
        this.idMatkul = "";
        this.nama = "";
        this.sks = 0;
    }
    
    public MataKuliah(String idMatkul, String nama, int sks){
        this.idMatkul = idMatkul;
        this.nama = nama;
        this.sks = sks;
    }

    public String getidMatkul(){
        return idMatkul;
    }

    public String getNama(){
        return nama;
    }

    public int getSKS(){
        return sks;
    }

    void setidMatkul(String idMatkul){
        this.idMatkul = idMatkul;
    }

    void setNama(String nama){
        this.nama = nama;
    }

    void setSKS(int sks){
        this.sks = sks;
    }


}
