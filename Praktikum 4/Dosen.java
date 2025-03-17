/* 
Nama File   : Dosen.java
Deskripsi   : Berisi atribut dan method dalam class Dosen
Pembuat     : 24060123140196 Ranggadya Aditama Ramadhani
Tanggal     : 15 Maret 2024
*/


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Dosen extends  Pegawai{
    protected String Fakultas;

    public Dosen() {
        super();
        this.Fakultas = "";
    }

    public Dosen(String NIP, String nama, String Fakultas, LocalDate tanggalLahir, LocalDate TMT, double gajiPokok, String Jabatan){
        super(NIP, nama, tanggalLahir, TMT, gajiPokok, Jabatan);
        this.Fakultas = Fakultas;
    }

    public String getFakultas(){
        return Fakultas;
    }

    public void setFakultas(String Fakultas){
        this.Fakultas = Fakultas;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Fakultas                : " + Fakultas);
    }

}
    

