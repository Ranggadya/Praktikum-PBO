/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum08;

/**
 *
 * @author LENOVO
 */
public class BangunDatarGenerik<T extends BangunDatar> {
    private T bangun;

    public void setBangun(T bangun) {
        this.bangun = bangun;
    }

    public T getBangun() {
        return bangun;
    }

    public double luas() {
        return bangun.hitungLuas();
    }

    public double keliling() {
        return bangun.hitungKeliling();
    }
}

