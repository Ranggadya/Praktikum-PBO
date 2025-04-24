public class Manager extends Pegawai {
    private int tunjangan = 700000;

    public Manager(String nama){
        super(nama);
    }
    
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Tunjangan : " + tunjangan);
    }
    
}
