public abstract class Anabul {
    private String nama;

    public Anabul() {
        this.nama = "";
    }

    public Anabul(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public abstract void bersuara();

    public abstract void bergerak();
}
