package com.mycompany.smartbakerystore;

import com.mycompany.smartbakerystore.Kue;
import com.mycompany.smartbakerystore.DapatDiskon;
import com.mycompany.smartbakerystore.DapatDibungkus;

public class KueTart extends Kue implements DapatDibungkus, DapatDiskon {
    private double ukuranTier; // Ukuran/tingkat tart
    private double hargaDasarTart;

    public KueTart(String nama, double ukuranTier, double hargaDasarTart) {
        super(nama, hargaDasarTart);
        this.ukuranTier = ukuranTier;
        this.hargaDasarTart = hargaDasarTart;
    }

    @Override
    public double hitungHarga() {
        return hargaDasarTart * ukuranTier;
    }

    @Override
    public void bungkus() {
        System.out.println("[Kue Tart] Mengemas " + getNama() + " dengan kotak kue mewah berpita.");
    }

    @Override
    public double hitungDiskon() {
        // Diskon khusus tart sebesar 15%
        return hitungHarga() * 0.15;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTipe : Kue Tart\nUkuran Tier : " + ukuranTier;
    }
}