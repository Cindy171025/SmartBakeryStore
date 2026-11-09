package com.mycompany.smartbakerystore;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainBakery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SmartBakeryStore toko = new SmartBakeryStore("Smart Bakery Store");
        toko.bukaToko();

        boolean isRunning = true;

        do {
            System.out.println("\n=========================================");
            System.out.println("         MENU UTAMA SMART BAKERY         ");
            System.out.println("=========================================");
            System.out.println("1. Tambah Produk Kue");
            System.out.println("2. Lihat Etalase Produk");
            System.out.println("3. Cari Kue");
            System.out.println("4. Kelola Pelanggan");
            System.out.println("5. Pembelian / Transaksi");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu (1-6): ");

            try {
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        System.out.println("\nPilih Jenis Kue:");
                        System.out.println("1. Kue Basah");
                        System.out.println("2. Kue Kering");
                        System.out.println("3. Kue Tart");
                        System.out.println("4. Kue Tradisional");
                        System.out.print("Pilih (1-4): ");
                        int jenis = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Masukkan Nama Kue: ");
                        String nama = scanner.nextLine();

                        if (jenis == 1) {
                            System.out.print("Masukkan Berat (Kg): ");
                            double berat = scanner.nextDouble();
                            System.out.print("Harga per Kg: Rp ");
                            toko.tambahKue(new KueBasah(nama, berat, scanner.nextDouble()));
                        } else if (jenis == 2) {
                            System.out.print("Masukkan Jumlah (Pcs): ");
                            int pcs = scanner.nextInt();
                            System.out.print("Harga per Pcs: Rp ");
                            toko.tambahKue(new KueKering(nama, pcs, scanner.nextDouble()));
                        } else if (jenis == 3) {
                            System.out.print("Masukkan Ukuran Tier: ");
                            double tier = scanner.nextDouble();
                            System.out.print("Harga Dasar Tart: Rp ");
                            toko.tambahKue(new KueTart(nama, tier, scanner.nextDouble()));
                        } else if (jenis == 4) {
                            System.out.print("Masukkan Jumlah Biji: ");
                            int biji = scanner.nextInt();
                            System.out.print("Harga per Biji: Rp ");
                            toko.tambahKue(new KueTradisional(nama, biji, scanner.nextDouble()));
                        }
                        break;

                    case 2:
                        System.out.println("\n--- DAFTAR ETALASE PRODUK KUE ---");
                        toko.lihatEtalase();
                        break;

                    case 3:
                        System.out.println("\n--- CARI KUE ---");
                        System.out.print("Masukkan Nama Kue yg dicari: ");
                        String keyword = scanner.nextLine();
                        try {
                            toko.cariKue(keyword);
                        } catch (ProdukKueTidakDitemukanException e) {
                            System.out.println("Peringatan: " + e.getMessage());
                        }
                        break;

                    case 4:
                        System.out.println("\n--- KELOLA PELANGGAN ---");
                        System.out.println("1. Tambah Pelanggan");
                        System.out.println("2. Cari Pelanggan via ID");
                        System.out.println("3. Lihat Semua Pelanggan");
                        System.out.print("Pilih: ");
                        int menuP = scanner.nextInt();
                        scanner.nextLine();

                        if (menuP == 1) {
                            System.out.print("Masukkan ID Pelanggan: ");
                            String id = scanner.nextLine();
                            System.out.print("Masukkan Nama Pelanggan: ");
                            String namaP = scanner.nextLine();
                            toko.tambahPelanggan(new Pelanggan(id, namaP));
                        } else if (menuP == 2) {
                            System.out.print("Masukkan ID yg dicari: ");
                            toko.cariPelanggan(scanner.nextLine());
                        } else if (menuP == 3) {
                            toko.lihatSemuaPelanggan();
                        }
                        break;

                    case 5:
                        System.out.println("\n--- SISTEM TRANSAKSI ---");
                        System.out.print("Masukkan ID Pelanggan: ");
                        String idPelanggan = scanner.nextLine();
                        Pelanggan pembeli = toko.getPelanggan(idPelanggan);

                        if (pembeli == null) {
                            System.out.println("Gagal: Pelanggan belum terdaftar!");
                        } else if (toko.getJumlahKue() == 0) {
                            System.out.println("Gagal: Etalase masih kosong.");
                        } else {
                            toko.lihatEtalase();
                            System.out.print("Pilih Nomor Kue yg ingin dibeli: ");
                            int idx = scanner.nextInt() - 1;
                            scanner.nextLine();

                            if (idx >= 0 && idx < toko.getJumlahKue()) {
                                Kue kuePilihan = toko.getKueInt(idx);
                                TransaksiPembelian.prosesBeli(pembeli, kuePilihan);
                            } else {
                                System.out.println("Nomor produk tidak valid!");
                            }
                        }
                        break;

                    case 6:
                        System.out.println("Terima kasih telah menggunakan Smart Bakery Store!");
                        isRunning = false;
                        break;

                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("[!] ERROR INPUT: Harap masukkan angka yang valid.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("[!] SYSTEM ERROR: " + e.getMessage());
            }
        } while (isRunning);

        scanner.close();
    }
}