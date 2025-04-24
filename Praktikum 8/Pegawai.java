import java.util.ArrayList;
public class Pegawai {
        protected String nama;
        protected int gajiPokok = 5000000;

        public Pegawai(){
            this.nama = "";
        }
    
        public Pegawai(String nama) {
            this.nama = nama;
        }
    
        public double getGaji() {
            return 0;
        }

    
        public void printInfo() {
            System.out.println("Nama : " + nama + ", Gaji pokok : " + gajiPokok);
        }
    
    
}
