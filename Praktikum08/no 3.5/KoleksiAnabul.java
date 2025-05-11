/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author LENOVO
 */
public class KoleksiAnabul extends Koleksi<Anabul> {
    public void showAll() {
        for (int i = 0; i < getSize(); i++) {
            Anabul a = getIsi(i);
            System.out.print((i + 1) + ". ");
            a.bersuara();
            a.bergerak();
            System.out.println();
        }
    }
}

