package com.mycompany.smartbakerystore;

import java.util.ArrayList;
import java.util.HashMap;

public class SmartBakeryStore {
    private String namaToko;
    private DapurProduksi dapurUtama; // KOMPOSISI (Composition)
    private ArrayList<Kue> daftarKue; // AGREGASI (Aggregation - ArrayList)
    private HashMap<String, Pelanggan> dataPelanggan; // AGREGASI (Aggregation - HashMap)

    public SmartBakeryStore(String namaToko) {
        this.namaToko = namaToko;
        this.dapurUtama = new DapurProduksi("Dapur Utama Pusat", 10); // Objek anak dibuat secara internal (Composition)
        this.daftarKue = new ArrayList<>();
        this.dataPelanggan = new HashMap<>();
    }

    public void bukaToko() {
        System.out.println("\n*** Menginisialisasi " + this.namaToko + " ***");
        dapurUtama.mulaiPanggang();
    }

    public void tambahKue(Kue k) {
        daftarKue.add(k);
        System.out.println("-> Sukses! Kue ditambahkan ke etalase. (Total: " + daftarKue.size() + ")");
    }

    public void tambahPelanggan(Pelanggan p) {
        dataPelanggan.put(p.getIdPelanggan(), p);
        System.out.println("-> Berhasil mendaftarkan pelanggan!");
    }

    public void lihatEtalase() {
        if (daftarKue.isEmpty()) {
            System.out.println("Etalase masih kosong.");
            return;
        }
        for (int i = 0; i < daftarKue.size(); i++) {
            System.out.println((i + 1) + ". " + daftarKue.get(i).toString());
            System.out.println("Harga Akhir : Rp " + daftarKue.get(i).hitungHarga());
            
            if (daftarKue.get(i) instanceof DapatDiskon) {
                System.out.println("Diskon      : Rp " + ((DapatDiskon) daftarKue.get(i)).hitungDiskon());
            }
            System.out.println("-----------------------------------------");
        }
    }

    // Menggunakan throws dan Custom Exception baru
    public void cariKue(String keyword) throws ProdukKueTidakDitemukanException {
        System.out.println("\nMencari Kue dengan Nama: " + keyword);
        boolean ketemu = false;
        for (Kue k : daftarKue) {
            if (k.getNama().equalsIgnoreCase(keyword)) {
                System.out.println(k.toString());
                System.out.println("Harga Akhir : Rp " + k.hitungHarga());
                ketemu = true;
            }
        }
        if (!ketemu) {
            throw new ProdukKueTidakDitemukanException("Gagal: Produk kue dengan nama '" + keyword + "' tidak terdaftar di etalase toko.");
        }
    }

    public void cariPelanggan(String id) {
        if (dataPelanggan.containsKey(id)) {
            System.out.println("Ditemukan! Nama Pelanggan: " + dataPelanggan.get(id).getNama());
        } else {
            System.out.println("Pelanggan dengan ID tersebut tidak terdaftar.");
        }
    }

    public void lihatSemuaPelanggan() {
        System.out.println("Total Pelanggan Terdaftar: " + dataPelanggan.size());
        for (Pelanggan p : dataPelanggan.values()) {
            System.out.println("- ID: " + p.getIdPelanggan() + " | Nama: " + p.getNama());
        }
    }

    public Pelanggan getPelanggan(String id) { return dataPelanggan.get(id); }
    public Kue getKueInt(int index) { return daftarKue.get(index); }
    public int getJumlahKue() { return daftarKue.size(); }
}