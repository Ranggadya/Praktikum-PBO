/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class MainGenerik {
    public static void main(String[] args) {
        Datum<Kucing> dKucing = new Datum<>();
        dKucing.setIsi(new Kucing("Kitty"));

        Datum<Anjing> dAnjing = new Datum<>();
        dAnjing.setIsi(new Anjing("Daffa"));

        Datum<Burung> dBurung = new Datum<>();
        dBurung.setIsi(new Burung("Steven"));

        ContohMetodeGenerik mg = new ContohMetodeGenerik();

        System.out.println("Simulasi dengan ContohMetodeGenerik:");
        mg.tampilkanSuaraGerak(dKucing);
        mg.tampilkanSuaraGerak(dAnjing);
        mg.tampilkanSuaraGerak(dBurung);
    }
    
}
