package com.mycompany.smartbakerystore;

import com.mycompany.smartbakerystore.Kue;
import com.mycompany.smartbakerystore.DapatDiskon;

public class KueKering extends Kue implements DapatDiskon {
    private int jumlah;
    private double hargaPerPcs;

    public KueKering(String nama, int jumlah, double hargaPerPcs) {
        super(nama, jumlah * hargaPerPcs);
        this.jumlah = jumlah;
        this.hargaPerPcs = hargaPerPcs;
    }

    @Override
    public double hitungHarga() {
        return jumlah * hargaPerPcs;
    }

    @Override
    public double hitungDiskon() {
        // Diskon 10% jika pembelian kue kering >= 20 pcs
        if (jumlah >= 20) {
            return hitungHarga() * 0.10;
        }
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTipe : Kue Kering\nJumlah : " + jumlah + " pcs";
    }
}