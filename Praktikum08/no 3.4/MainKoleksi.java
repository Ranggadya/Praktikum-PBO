/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.praktikum08;

/**
 *
 * @author LENOVO
 */
public class MainKoleksi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Koleksi<Character> koleksiHuruf = new Koleksi<>();
        
        for (char c = 'A'; c <= 'J'; c++){
            koleksiHuruf.add(c);
        }
        
        koleksiHuruf.showAll();
        
        koleksiHuruf.setIsi(0, 'Z');
        System.out.println();
        koleksiHuruf.showAll();
        
        koleksiHuruf.delete('3');
        System.out.println();
        koleksiHuruf.showAll();
        
        
    }
    
}
