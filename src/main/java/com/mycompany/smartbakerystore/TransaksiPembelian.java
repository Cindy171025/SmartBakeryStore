package com.mycompany.smartbakerystore;

public class TransaksiPembelian {
    public static void prosesBeli(Pelanggan pelanggan, Kue kue) {
        System.out.println("\n-----------------------------------------");
        System.out.println("             STRUK PEMBELIAN             ");
        System.out.println("-----------------------------------------");
        System.out.println("Pelanggan : " + pelanggan.getNama() + " (" + pelanggan.getIdPelanggan() + ")");
        System.out.println("Produk    : " + kue.getNama());
        System.out.println("Harga     : Rp " + kue.hitungHarga());
        System.out.println("Status    : Transaksi berhasil dicatat.");
        kue.jenisPenyajian();

        if (kue instanceof DapatDibungkus) {
            ((DapatDibungkus) kue).bungkus();
        }
        System.out.println("-----------------------------------------");
    }
}