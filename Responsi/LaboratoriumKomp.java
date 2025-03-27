public class LaboratoriumKomp extends Laboratorium {
    private int jumlahKomputer;

    public LaboratoriumKomp(){
        this.jumlahKomputer = 0;
    }
    
    public LaboratoriumKomp(String kode, double panjang, double lebar, double tinggi, int kapasitas, String namaLab, double hargaSewa, int jumlahKomputer) {
        super(kode, panjang, lebar, tinggi, kapasitas, namaLab, hargaSewa);
        this.jumlahKomputer = jumlahKomputer;
    }

    public int getJmlKomp(){
        return jumlahKomputer;
    }

    public void setJmlKomp(int jumlahKomputer){
        this.jumlahKomputer = jumlahKomputer;
    }
    
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jumlah Komputer: " + jumlahKomputer);
    }
}
 
