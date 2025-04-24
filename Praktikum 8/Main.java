import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Nama : Ranggadya Aditama Ramadhani\n ");

        Pegawai pegawai1 = new Programmer("Mira");
        Pegawai pegawai2 = new Manager("Joko");
        Manager pegawai3 = new Manager("Argo");

        ArrayList<Pegawai> emps = new ArrayList<>();
        emps.add(pegawai1);
        emps.add(pegawai2);
        emps.add(pegawai3);

        for (Pegawai emp : emps) {
            emp.printInfo();
        }
    }
}
// Manfaat Polimorfisme
/*
1.Dengan menggunakan superclass Pegawai sebagai tipe referensi, kita dapat menyimpan objek 
dari subclass yang berbeda seperti Programmer dan Manajer dalam satu struktur data seperti ArrayList<Pegawai>.
2. Meskipun referensi bertipe Pegawai, method printInfo() yang dipanggil akan sesuai dengan tipe objek sebenarnya (Programmer atau Manajer). 
yang memungkinkan eksekusi method yang tepat saat runtime tanpa perlu pengecekan tipe manual.*/

//Apa permasalahan jika tanpa polimorfisme (inclusion)?
/*Tanpa polimorfisme inclusion, penambahan pegawai4 dan pegawai5 akan menimbulkan permasalahan seperti duplikasi kode, karena setiap tipe pegawai 
harus ditangani secara terpisah, misalnya dengan menulis kode yang berbeda untuk masing-masing tipe seperti Programmer dan Manajer. Selain itu, kita 
tidak dapat menyimpan objek-objek dari berbagai subclass dalam satu struktur data umum seperti ArrayList<Pegawai>, sehingga membutuhkan daftar terpisah 
untuk tiap tipe pegawai.*/