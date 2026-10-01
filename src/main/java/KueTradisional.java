package com.mycompany.smartbakerystore;

public class KueTradisional extends Kue {
    private String asalDaerah;

    public KueTradisional(String namaKue, double harga, int stok, String asalDaerah) {
        super(namaKue, harga, stok);
        this.asalDaerah = asalDaerah;
    }

    public String getAsalDaerah() { return asalDaerah; }
    public void setAsalDaerah(String asalDaerah) { this.asalDaerah = asalDaerah; }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[TRADISIONAL] Nama: %-12s | Harga: Rp%.2f | Stok: %-3d | Asal: %s\n", 
                getNamaKue(), getHarga(), getStok(), asalDaerah);
    }

    @Override
    public void jenisPenyajian() {
        System.out.println("-> Penyajian Kue Tradisional: Disajikan dengan sentuhan etnik dan beralaskan daun.");
    }
}