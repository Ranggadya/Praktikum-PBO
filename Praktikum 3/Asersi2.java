/*Nama File  : Asersi2.java
 * Deskripsi : 
 * Pembuat   : Ranggadya Aditama Ramadhani
 * Tanggal   : 09-03-2025
 */

class Lingkaran {
    private double jariJari;
    public Lingkaran(double jariJari){
        this.jariJari = jariJari;
    } 
    public double hitungKeliling(){
        double keliling = 2 * Math.PI*jariJari;
        return keliling;
    }   
}

public class Asersi2{
    public static void main(String[] args){
        double jariJari = 0;
        assert(jariJari > 0): "jari jari tidak boleh nol";
        Lingkaran l = new Lingkaran(jariJari);
        double kelilingLingkaran = l.hitungKeliling();
        System.out.println("keliling Lingkaran = " + kelilingLingkaran);
    }
}

/*Kemungkinan besar kesalahan konsep pada program ini adalah terkait dengan cara penggunaan asersi. Asersi digunakan untuk memastikan kondisi tertentu benar selama runtime, tetapi jika digunakan untuk validasi input dari pengguna, itu tidak tepat. Sebab, asersi dapat dinonaktifkan saat program dijalankan tanpa flag -enableassertions. Validasi input seharusnya menggunakan mekanisme pengecekan kondisi seperti if-else atau eksepsi (try-catch). */
