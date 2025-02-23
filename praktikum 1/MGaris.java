public class MGaris {
    public static void main(String[] args) {
        Titik t1 = new Titik(-2, 0);
        Titik t2 = new Titik(0, 4);
        Garis g1 = new Garis(t1, t2);

        g1.tampilkanGaris();
        System.out.println("Panjang Garis: " + g1.getPanjang());
        System.out.println("Gradien: " + g1.getGradien());
        System.out.println("Titik Tengah: (" + g1.getTitikTengah().getAbsis() + ", " + g1.getTitikTengah().getOrdinat() + ")");
        System.out.println("Persamaan Garis: " + g1.getPersamaanGaris());
    }
}