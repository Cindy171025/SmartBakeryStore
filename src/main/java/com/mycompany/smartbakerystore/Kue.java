package com.mycompany.smartbakerystore;

public abstract class Kue {
    private String nama;
    private double harga;

    public Kue(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    // Abstract method yang wajib di-override oleh subclass
    public abstract double hitungHarga();

    @Override
    public String toString() {
        return "Nama Kue : " + nama + "\nHarga Dasar : Rp " + harga;
    }
}