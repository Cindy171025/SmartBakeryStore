package com.mycompany.smartbakerystore;

public class KueBasah extends Kue {
    private int dayaTahanHari;

    public KueBasah(String namaKue, double harga, int stok, int dayaTahanHari) {
        super(namaKue, harga, stok);
        this.dayaTahanHari = dayaTahanHari;
    }

    public int getDayaTahanHari() { return dayaTahanHari; }
    public void setDayaTahanHari(int dayaTahanHari) { this.dayaTahanHari = dayaTahanHari; }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[KUE BASAH]  Nama: %-12s | Harga: Rp%.2f | Stok: %-3d | Daya Tahan: %d Hari\n", 
                getNamaKue(), getHarga(), getStok(), dayaTahanHari);
    }

    @Override
    public void jenisPenyajian() {
        System.out.println("-> Penyajian Kue Basah: Harus segera dikonsumsi karena mudah basi di suhu ruang.");
    }
}