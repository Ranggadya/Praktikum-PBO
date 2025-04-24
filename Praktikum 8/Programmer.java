

public class Programmer extends Pegawai{

    private int bonus = 450000;

    public Programmer(String nama) {
        super(nama);
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Bonus : " + bonus);
    }
    
}
