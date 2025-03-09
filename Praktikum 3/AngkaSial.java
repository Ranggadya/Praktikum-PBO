/*Nama File  : AngkaSial.java
 * Deskripsi : 
 * Pembuat   : Ranggadya Aditama Ramadhani
 * Tanggal   : 09-03-2025
 */

public class AngkaSial {
    public void cobaAngka(int angka) throws AngkaSialException{
        if ( angka == 13){
            throw new AngkaSialException();
        }
        System.out.println(angka + " bukan angka sisi");
    }
    public static void main(String[] args){
        AngkaSial as = new AngkaSial();
        try{
            as.cobaAngka(10);
            as.cobaAngka(13);
            as.cobaAngka(12);

        }catch(AngkaSialException ase){
            System.out.println(ase.getMessage());
            System.out.println("hati hati memasukan angka");
        }
    }
}

/*Jika eksepsi dilempar sebelum baris 12 dieksekusi, maka baris tersebut tidak akan dijalankan karena alur eksekusi 
akan langsung berpindah ke blok catch atau akan dihentikan jika tidak ditangani.
 */

/*Jika eksepsi dilemparkan di dalam blok try sebelum mencapai baris 21, 
maka eksekusi langsung berpindah ke blok catch, sehingga baris 21 tidak akan dieksekusi. 
Jika tidak ada eksepsi, maka baris ini akan tetap dieksekusi. */