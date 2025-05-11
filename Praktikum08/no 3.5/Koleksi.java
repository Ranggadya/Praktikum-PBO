/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author LENOVO
 */
import java.util.ArrayList;

public class Koleksi<T> {
    private int nbelm = 0;
    private ArrayList<T> wadah = new ArrayList<>();

    public void add(T elemen) {
        wadah.add(elemen);
        nbelm++;
    }

    public void delete(int index) {
        if (index >= 0 && index < nbelm) {
            wadah.remove(index);
            nbelm--;
        }
    }

    public T getIsi(int index) {
        if (index >= 0 && index < nbelm) {
            return wadah.get(index);
        } else {
            return null;
        }
    }

    public void setIsi(int index, T elemenBaru) {
        if (index >= 0 && index < nbelm) {
            wadah.set(index, elemenBaru);
        }
    }

    public int getSize() {
        return nbelm;
    }

    public void setSize(int size) {
        this.nbelm = size;
    }

    public void showAll() {
        for (int i = 0; i < nbelm; i++) {
            System.out.println("[" + i + "] " + wadah.get(i));
        }
    }
}
