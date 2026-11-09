package com.mycompany.smartbakerystore;

public class KueKering extends Kue implements DapatDibungkus, DapatDiskon {
    private int jumlahPcs;
    private double hargaPerPcs;

    public KueKering(String nama, int jumlahPcs, double hargaPerPcs) throws Exception {
        super(nama, hargaPerPcs);
        this.jumlahPcs = jumlahPcs;
        this.hargaPerPcs = hargaPerPcs;
    }

    @Override
    public double hitungHarga() {
        return jumlahPcs * hargaPerPcs;
    }

    @Override
    public void bungkus() {
        System.out.println("[Kue Kering] Dikemas dalam jar toples kedap udara.");
    }

    @Override
    public double hitungDiskon() {
        return hitungHarga() * 0.10; // Diskon 10%
    }

    @Override
    public String toString() {
        return super.toString() + "\nTipe         : Kue Kering\nJumlah Pcs   : " + jumlahPcs;
    }
}