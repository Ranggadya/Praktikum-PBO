public class Main {
    public static void main(String[] args) {
        BangunDatar persegi = new Persegi(10, "Merah", "Hitam");
        BangunDatar lingkaran = new Lingkaran(0, "Biru", "Putih");

        System.out.println("========================================");
        persegi.printInfo();
        System.out.println("Luas Persegi: " + persegi.getLuas());
        System.out.println("Keliling Persegi: " + persegi.getKeliling());

        System.out.println("========================================");
        lingkaran.printInfo();
        System.out.println("Luas Lingkaran: " + lingkaran.getLuas());
        System.out.println("Keliling Lingkaran: " + lingkaran.getKeliling());

        System.out.println("========================================");

        System.out.println("Apakah luasnya sama? " + persegi.isEqualLuas(lingkaran));
        System.out.println("Apakah kelilingnya sama? " + persegi.isEqualKeliling(lingkaran));
    }
}
