/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
import java.util.Random;

public class MainKoleksiAnabul {
    public static void main(String[] args) {
        KoleksiAnabul koleksi = new KoleksiAnabul();
        String[] namaList = {"Milo", "Bruno", "Coco", "Neko", "Luna", "Rocky", "Tweetie", "Sky", "Max", "Chirp"};
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            int jenis = rand.nextInt(3);
            String nama = namaList[i];
            if (jenis == 0) {
                koleksi.add(new Kucing(nama));
            } else if (jenis == 1) {
                koleksi.add(new Anjing(nama));
            } else {
                koleksi.add(new Burung(nama));
            }
        }

        koleksi.showAll();
    }
}
