/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class ContohMetodeGenerik {
    public <T extends Anabul> void tampilkanSuaraGerak(Datum<T> data) {
        data.getIsi().bersuara();
        data.getIsi().bergerak();
    }
}
