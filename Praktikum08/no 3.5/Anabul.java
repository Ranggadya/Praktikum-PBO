/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public abstract class Anabul {
    private String nama;
    
    public Anabul() {
        this.nama = "";
    }

    public Anabul(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }
    public abstract void bersuara();
    public abstract void bergerak();

}
