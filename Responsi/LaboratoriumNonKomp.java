public class LaboratoriumNonKomp extends Laboratorium {
    private String mataKuliahTerkait;

    public LaboratoriumNonKomp(){
        this.mataKuliahTerkait = "";
    }
    
    public LaboratoriumNonKomp(String kode, double panjang, double lebar, double tinggi, int kapasitas, String namaLab, double hargaSewa, String mataKuliahTerkait) {
        super(kode, panjang, lebar, tinggi, kapasitas, namaLab, hargaSewa);
        this.mataKuliahTerkait = mataKuliahTerkait;
    }

    public String getMatkulTerkait(){
        return mataKuliahTerkait;

    }

    public void setMatkulTerkait(String mataKuliahTerkait){
        this.mataKuliahTerkait = mataKuliahTerkait;
    }
    
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Mata Kuliah Terkait: " + mataKuliahTerkait);
    }
} 
