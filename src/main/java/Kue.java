package com.mycompany.smartbakerystore;

public class Kue {
    private String namaKue;
    private double harga;
    private int stok;
    private static int totalKueDibuat = 0;

    public Kue(String namaKue, double harga, int stok) {
        this.namaKue = namaKue;
        setHarga(harga);
        setStok(stok);
        totalKueDibuat++;
    }

    public String getNamaKue() { return namaKue; }
    public void setNamaKue(String namaKue) { this.namaKue = namaKue; }

    public double getHarga() { return harga; }
    public void setHarga(double harga) {
        if (harga >= 0) this.harga = harga;
    }

    public int getStok() { return stok; }
    public void setStok(int stok) {
        if (stok >= 0) this.stok = stok;
    }

    public static int getTotalKueDibuat() {
        return totalKueDibuat;
    }

    public void tampilkanInfo() {
        System.out.printf("Kue: %-15s | Harga: Rp%.2f | Stok: %d pcs\n", namaKue, harga, stok);
    }

    public void jenisPenyajian() {
        System.out.println("-> Penyajian umum: Disajikan di dalam kotak kue standar.");
    }
}