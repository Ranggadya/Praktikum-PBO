public class MTitik {
    public static void main(String[] args) {
        Titik T1 = new Titik();
        T1.setAbsis(3);
        T1.setOrdinat(4);
        T1.printTitik();
        T1.geser(3, 4);
        T1.printTitik();

        Titik T2 = T1;
        T2.printTitik();
        T1.setAbsis(10);
        T1.setOrdinat(10);
        T2.printTitik();

        Titik T3 = new Titik();
        T3.setAbsis(5);
        T3.setOrdinat(5);
        T3.printTitik();
        System.out.println("Kuadran : " + T3.getKuadran());
        System.out.println("Jarak Pusat : " + T3.jarakTitikPusat());
        System.out.println("Jarak Titik : " + T3.jarakTitik(T1));
        T3.getCounterTitik();
        System.out.println("Titik terbaru : " + "(" + T3.getRefleksiX().getAbsis() + " , " + T3.getRefleksiX().getOrdinat() + ")");
        System.out.println("Titik terbaru : " + "(" + T3.getRefleksiY().getAbsis() + " , " + T3.getRefleksiY().getOrdinat() + ")");
    }
}