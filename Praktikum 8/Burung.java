public class Burung extends Anabul {
    public Burung(String nama) {
        super(nama);
    }

    @Override
    public void bersuara() {
        System.out.println(getNama() + " bersuara: Cuit cuit!");
    }

    @Override
    public void bergerak() {
        System.out.println(getNama() + " bergerak dengan terbang");
    }

}
