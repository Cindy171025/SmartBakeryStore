package com.mycompany.smartbakerystore;

public class KueTart extends Kue implements DapatDibungkus, DapatDiskon {
    private double ukuranTier;
    private double hargaDasarTart;

    public KueTart(String nama, double ukuranTier, double hargaDasarTart) throws Exception {
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
        return hitungHarga() * 0.15; // Diskon 15%
    }

    @Override
    public void jenisPenyajian() {
        System.out.println("-> Penyajian Kue Tart: Disajikan dalam box khusus ulang tahun lengkap dengan pisau.");
    }

    @Override
    public String toString() {
        return super.toString() + "\nTipe         : Kue Tart\nUkuran Tier  : " + ukuranTier;
    }
}