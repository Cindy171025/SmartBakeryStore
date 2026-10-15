package com.mycompany.smartbakerystore;

import com.mycompany.smartbakerystore.Kue;
import com.mycompany.smartbakerystore.DapatDibungkus;

public class KueBasah extends Kue implements DapatDibungkus {
    private double berat;
    private double hargaPerKilo;

    public KueBasah(String nama, double berat, double hargaPerKilo) {
        super(nama, berat * hargaPerKilo);
        this.berat = berat;
        this.hargaPerKilo = hargaPerKilo;
    }

    @Override
    public double hitungHarga() {
        return berat * hargaPerKilo;
    }

    @Override
    public void bungkus() {
        System.out.println("[Kue Basah] Mengemas " + getNama() + " menggunakan daun pisang/plastik mika khusus.");
    }

    @Override
    public String toString() {
        return super.toString() + "\nTipe : Kue Basah\nBerat : " + berat + " kg";
    }
}