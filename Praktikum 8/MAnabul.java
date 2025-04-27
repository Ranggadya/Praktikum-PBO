public class MAnabul {
    public static void main(String[] args) {
        Anabul[] hewanPeliharaan = {
                new Kucing("Kitty"),
                new Anjing("Doggy"),
                new Burung("Twitty")
        };

        for (Anabul hewan : hewanPeliharaan) {
            hewan.bersuara();
            hewan.bergerak();
            System.out.println();
        }
    }

}
