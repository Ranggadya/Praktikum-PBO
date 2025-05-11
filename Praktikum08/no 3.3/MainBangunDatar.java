/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.praktikum08;

/**
 *
 * @author LENOVO
 */
public class MainBangunDatar {
    public static void main(String[] args) {
        BangunDatarGenerik<Persegi> persegi = new BangunDatarGenerik<>();
        persegi.setBangun(new Persegi(5));
        System.out.println("Luas Persegi: " + persegi.luas());
        System.out.println("Keliling Persegi: " + persegi.keliling());

        System.out.println("========================================");
        BangunDatarGenerik<PersegiPanjang> pp = new BangunDatarGenerik<>();
        pp.setBangun(new PersegiPanjang(4, 6));
        System.out.println("Luas Persegi Panjang: " + pp.luas());
        System.out.println("Keliling Persegi Panjang: " + pp.keliling());

         System.out.println("========================================");
        BangunDatarGenerik<Segitiga> segitiga = new BangunDatarGenerik<>();
        segitiga.setBangun(new Segitiga(3, 4, 3, 4, 5));
        System.out.println("Luas Segitiga: " + segitiga.luas());
        System.out.println("Keliling Segitiga: " + segitiga.keliling());
    }
}
