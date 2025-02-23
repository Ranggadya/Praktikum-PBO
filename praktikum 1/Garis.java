class Garis {
    Titik awal, akhir;
    static int counterGaris = 0;

    Garis() {
        this.awal = new Titik(0, 0);
        this.akhir = new Titik(1, 1);
        counterGaris++;
    }

    Garis(Titik awal, Titik akhir) {
        this.awal = awal;
        this.akhir = akhir;
        counterGaris++;
    }

    Titik getAwal() {
        return awal;
    }

    void setAwal(Titik awal) {
        this.awal = awal;
    }

    Titik getAkhir() {
        return akhir;
    }

    void setAkhir(Titik akhir) {
        this.akhir = akhir;
    }

    static int getCounterGaris() {
        return counterGaris;
    }

    double getPanjang() {
        return Math.sqrt(Math.pow(akhir.getAbsis() - awal.getAbsis(), 2) + Math.pow(akhir.getOrdinat() - awal.getOrdinat(), 2));
    }

    double getGradien() {
        if (akhir.getAbsis() == awal.getAbsis()) {
            throw new ArithmeticException("Garis vertikal tidak memiliki gradien.");
        }
        return (akhir.getOrdinat() - awal.getOrdinat()) / (akhir.getAbsis() - awal.getAbsis());
    }

    Titik getTitikTengah() {
        return new Titik((awal.getAbsis() + akhir.getAbsis()) / 2, (awal.getOrdinat() + akhir.getOrdinat()) / 2);
    }

    boolean isSejajar(Garis g) {
        return this.getGradien() == g.getGradien();
    }

    boolean isTegakLurus(Garis g) {
        return this.getGradien() * g.getGradien() == -1;
    }

    void tampilkanGaris() {
        System.out.println("Titik Awal: (" + awal.getAbsis() + ", " + awal.getOrdinat() + ")");
        System.out.println("Titik Akhir: (" + akhir.getAbsis() + ", " + akhir.getOrdinat() + ")");
    }

    String getPersamaanGaris() {
        double m = getGradien();
        double c = awal.getOrdinat() - m * awal.getAbsis();
        return "y = " + m + "x + " + c;
    }
}