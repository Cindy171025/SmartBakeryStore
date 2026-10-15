package com.mycompany.smartbakerystore;

import com.mycompany.smartbakerystore.Kue;
import com.mycompany.smartbakerystore.DapatDibungkus;

public class KueTradisional extends Kue implements DapatDibungkus {
    private int jumlahBiji;
    private double hargaPerBiji;

    public KueTradisional(String nama, int jumlahBiji, double hargaPerBiji) {
        super(nama, jumlahBiji * hargaPerBiji);
        this.jumlahBiji = jumlahBiji;
        this.hargaPerBiji = hargaPerBiji;
    }

    @Override
    public double hitungHarga() {
        return jumlahBiji * hargaPerBiji;
    }

    @Override
    public void bungkus() {
        System.out.println("[Kue Tradisional] Mengemas " + getNama() + " menggunakan keranjang bambu tradisional.");
    }

    @Override
    public String toString() {
        return super.toString() + "\nTipe : Kue Tradisional\nJumlah Biji : " + jumlahBiji;
    }
}