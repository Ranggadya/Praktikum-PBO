public class Anjing extends Anabul {
    public Anjing(String nama) {
        super(nama);
    }

    @Override
    public void bersuara() {
        System.out.println(getNama() + " bersuara: Meong!");
    }

    @Override
    public void bergerak() {
        System.out.println(getNama() + " bergerak dengan melata");
    }

}
