/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class MainDatum {

    public static void main(String[] args) {
        Datum<Kucing> dKucing = new Datum<>();
        dKucing.setIsi(new Kucing("Kitty"));

        Datum<Anjing> dAnjing = new Datum<>();
        dAnjing.setIsi(new Anjing("Daffa"));

        Datum<Burung> dBurung = new Datum<>();
        dBurung.setIsi(new Burung("Steve"));

        System.out.println("Simulasi dengan Datum:");
        dKucing.getIsi().bersuara();
        dKucing.getIsi().bergerak();

        dAnjing.getIsi().bersuara();
        dAnjing.getIsi().bergerak();

        dBurung.getIsi().bersuara();
        dBurung.getIsi().bergerak();
    }
    
}
