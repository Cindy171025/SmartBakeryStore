package com.mycompany.smartbakerystore;

public class KueTradisional extends Kue {
    private int jumlahBiji;
    private double hargaPerBiji;

    public KueTradisional(String nama, int jumlahBiji, double hargaPerBiji) throws Exception {
        super(nama, hargaPerBiji);
        this.jumlahBiji = jumlahBiji;
        this.hargaPerBiji = hargaPerBiji;
    }

    @Override
    public double hitungHarga() {
        return jumlahBiji * hargaPerBiji;
    }

    @Override
    public void jenisPenyajian() {
        System.out.println("-> Penyajian Kue Tradisional: Disajikan di atas tampah anyaman bambu.");
    }

    @Override
    public String toString() {
        return super.toString() + "\nTipe         : Kue Tradisional\nJumlah Biji  : " + jumlahBiji;
    }
}