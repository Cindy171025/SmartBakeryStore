package com.mycompany.smartbakerystore;

public abstract class Kue {
    protected String nama;
    protected double harga;
    public static int totalKueBerhasilDibuat = 0;

    public Kue(String nama, double harga) throws Exception {
        if (harga < 0) {
            throw new Exception("Harga dasar kue tidak boleh bernilai negatif!");
        }
        this.nama = nama;
        this.harga = harga;
        totalKueBerhasilDibuat++;
    }

    public String getNama() { return this.nama; }
    public double getHarga() { return this.harga; }

    public void jenisPenyajian() {
        System.out.println("-> Penyajian umum: Disajikan di dalam kotak kue standar.");
    }

    public abstract double hitungHarga();

    @Override
    public String toString() {
        return "Nama Kue     : " + nama + "\nHarga Dasar  : Rp " + harga;
    }
}