public class Titik {
    double absis, ordinat;
    static int counterTitik = 0;

    Titik() {
        this(0, 0);
    }

    Titik(double absis, double ordinat) {
        this.absis = absis;
        this.ordinat = ordinat;
        counterTitik++;
    }

    double getAbsis() {
        return absis;
    }

    void setAbsis(double absis) {
        this.absis = absis;
    }

    double getOrdinat() {
        return ordinat;
    }

    void setOrdinat(double ordinat) {
        this.ordinat = ordinat;
    }

    void geser(double x, double y) {
        absis = absis + x;
        ordinat = ordinat + y;
    }

    public int getKuadran() {
        if (this.absis > 0 && this.ordinat > 0) {
            return 1;
        } else if (this.absis < 0 && this.ordinat > 0) {
            return 2;
        } else if (this.absis < 0 && this.ordinat < 0) {
            return 3;
        } else if(this.absis > 0 && this.ordinat < 0 ) {
            return 4;
        }
        else{
            return 0;
        }
    }

    double jarakTitikPusat() {
        return Math.sqrt(this.absis * this.absis + this.ordinat * this.ordinat);
    }

    double jarakTitik(Titik t) {
        return Math.sqrt(Math.pow(this.absis - t.getAbsis(), 2) + Math.pow(this.ordinat - t.getOrdinat(), 2));
    }

    void refleksiX() {
        this.ordinat = -this.ordinat;
    }

    void refleksiY() {
        this.absis = -this.absis;
    }

    Titik getRefleksiX() {
        return new Titik(this.absis, -this.ordinat);
    }

    Titik getRefleksiY() {
        return new Titik(-this.absis, this.ordinat);
    }

    // Tambahkan method printTitik
    void printTitik() {
        System.out.println("(" + absis + ", " + ordinat + ")");
    }

    void getCounterTitik(){
        System.out.println("Jumlah Titik : " + counterTitik);
    }
}
