/*Nama File  : Asersi.java
 * Deskripsi : 
 * Pembuat   : Ranggadya Aditama Ramadhani
 * Tanggal   : 09-03-2025
 */

public class Asersi {
    public static void main(String[] args){
        int x = 0;
        if(x > 0){
            System.out.println("x Bilangan postif");
        }else{
            assert( x < 0): "ada kesalahan kode";
            System.out.println("x bilangan negatif");
        }
    }
}
