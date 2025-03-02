/*Nama File  : Mahasiswa.java
 * Deskripsi : berisi atribut dan method dalam class Mahasiswa
 * Pembuat   : Ranggadya Aditama Ramadhani
 * Tanggal   : 02-03-2025
 */

import java.util.ArrayList;


public class Mahasiswa {
    private String nim, nama, prodi;
    private ArrayList<MataKuliah> listMatkul;
    private Dosen dosenWali;
    private Kendaraan kendaraan;

    public Mahasiswa(){
        this.nim = "";
        this.nama = "";
        this.prodi = "";
        this.listMatkul = new ArrayList<>(50);
        this.dosenWali = new Dosen();
        this.kendaraan = new Kendaraan();
    }

    public Mahasiswa(String nim, String nama, String prodi) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
        this.listMatkul = new ArrayList<>();
    }

    public Mahasiswa(String nim, String nama, String prodi, Dosen dosenWali, Kendaraan kendaraan, ArrayList<MataKuliah> listMatkul){
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
        this.listMatkul = new ArrayList<>();
        this.dosenWali = dosenWali;
        this.kendaraan = kendaraan;
    }

    String getNim(){
        return nim;
    }

    String getNama(){
        return nama;
    }

    public String getProdi(){
        return prodi;
    }

    public Dosen getDosen(){
        return dosenWali;
    }
    
    public Kendaraan getKendaraan(){
        return kendaraan;
    }

    public void setNim(String nim){
        this.nim = nim;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }

    public void setProdi(String prodi){
        this.prodi = prodi;
    }

    public void setDosenWali(Dosen dosenWali){
        this.dosenWali = dosenWali;
    }

    public void setKendaraan(Kendaraan kendaraan){
        this.kendaraan = kendaraan;
    }

    public void addMatkul(MataKuliah x){
        listMatkul.add(x);
    }

    public int getJumlahSKS(){
        int totalSKS = 0;
        for (MataKuliah mataKuliah : listMatkul){
            totalSKS += mataKuliah.getSKS();
        }
        return totalSKS;
    }

    public int getJumlahMatkul(){
        return listMatkul.size();
    }

    public void printDetailMhs(){
        System.out.println("Nim " + nim);
        System.out.println("Nama " + nama);
        System.out.println("Prodi " + prodi);
        int i;
        for(i = 0; i < listMatkul.size();i++){
            System.out.println(listMatkul.get(i).getNama());
        }
    }
}
