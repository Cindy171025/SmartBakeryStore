package com.mycompany.smartbakerystore;

public class KueKering extends Kue {
    private String jenisToples;

    public KueKering(String namaKue, double harga, int stok, String jenisToples) {
        super(namaKue, harga, stok);
        this.jenisToples = jenisToples;
    }

    public String getJenisToples() { return jenisToples; }
    public void setJenisToples(String jenisToples) { this.jenisToples = jenisToples; }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[KUE KERING] Nama: %-12s | Harga: Rp%.2f | Stok: %-3d | Kemasan: %s\n", 
                getNamaKue(), getHarga(), getStok(), jenisToples);
    }

    @Override
    public void jenisPenyajian() {
        System.out.println("-> Penyajian Kue Kering: Dikemas kedap udara dalam toples agar renyah tahan lama.");
    }
}