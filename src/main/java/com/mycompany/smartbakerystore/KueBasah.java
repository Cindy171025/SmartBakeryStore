package com.mycompany.smartbakerystore;

public class KueBasah extends Kue implements DapatDiskon {
    private double berat;
    private double hargaPerKilo;

    public KueBasah(String nama, double berat, double hargaPerKilo) throws Exception {
        super(nama, hargaPerKilo);
        this.berat = berat;
        this.hargaPerKilo = hargaPerKilo;
    }

    @Override
    public double hitungHarga() {
        return berat * hargaPerKilo;
    }

    @Override
    public double hitungDiskon() {
        return hitungHarga() * 0.05; // Diskon 5%
    }

    @Override
    public void jenisPenyajian() {
        System.out.println("-> Penyajian Kue Basah: Disajikan segar dengan alas daun pisang.");
    }

    @Override
    public String toString() {
        return super.toString() + "\nTipe         : Kue Basah\nBerat        : " + berat + " Kg";
    }
}