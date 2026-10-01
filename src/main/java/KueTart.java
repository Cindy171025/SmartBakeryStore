package com.mycompany.smartbakerystore;

public class KueTart extends Kue {
    private int diameterCM;

    public KueTart(String namaKue, double harga, int stok, int diameterCM) {
        super(namaKue, harga, stok);
        this.diameterCM = diameterCM;
    }

    public int getDiameterCM() { return diameterCM; }
    public void setDiameterCM(int diameterCM) { this.diameterCM = diameterCM; }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[KUE TART]   Nama: %-12s | Harga: Rp%.2f | Stok: %-3d | Ukuran: %d cm\n", 
                getNamaKue(), getHarga(), getStok(), diameterCM);
    }

    @Override
    public void jenisPenyajian() {
        System.out.println("-> Penyajian Kue Tart: Disajikan dalam box khusus ulang tahun lengkap dengan pisau & lilin.");
    }
}