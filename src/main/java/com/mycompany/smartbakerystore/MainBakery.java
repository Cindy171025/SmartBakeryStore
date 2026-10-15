package com.mycompany.smartbakerystore;

import java.util.ArrayList;
import java.util.Scanner;

public class MainBakery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Kue> daftarKue = new ArrayList<>();
        int pilihan = 0;

        do {
            System.out.println("\n=========================================");
            System.out.println("       MENU SMART BAKERY STORE           ");
            System.out.println("=========================================");
            System.out.println("1. Tambah Kue Basah");
            System.out.println("2. Tambah Kue Kering");
            System.out.println("3. Tambah Kue Tart");
            System.out.println("4. Tambah Kue Tradisional");
            System.out.println("5. Tampilkan Semua Daftar Kue & Total");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu (1-6): ");
            
            if (scanner.hasNextInt()) {
                pilihan = scanner.nextInt();
                scanner.nextLine(); // Membersihkan buffer enter
            } else {
                System.out.println("Input tidak valid! Harap masukkan angka.");
                scanner.nextLine();
                continue;
            }

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nama Kue Basah : ");
                    String namaBasah = scanner.nextLine();
                    System.out.print("Masukkan Berat (kg)     : ");
                    double berat = scanner.nextDouble();
                    System.out.print("Masukkan Harga per Kg   : Rp ");
                    double hargaPerKilo = scanner.nextDouble();
                    
                    daftarKue.add(new KueBasah(namaBasah, berat, hargaPerKilo));
                    System.out.println("-> Kue Basah berhasil ditambahkan!");
                    break;

                case 2:
                    System.out.print("Masukkan Nama Kue Kering : ");
                    String namaKering = scanner.nextLine();
                    System.out.print("Masukkan Jumlah (pcs)    : ");
                    int jumlahPcs = scanner.nextInt();
                    System.out.print("Masukkan Harga per Pcs   : Rp ");
                    double hargaPerPcs = scanner.nextDouble();
                    
                    daftarKue.add(new KueKering(namaKering, jumlahPcs, hargaPerPcs));
                    System.out.println("-> Kue Kering berhasil ditambahkan!");
                    break;

                case 3:
                    System.out.print("Masukkan Nama Kue Tart   : ");
                    String namaTart = scanner.nextLine();
                    System.out.print("Masukkan Ukuran Tier     : ");
                    double ukuranTier = scanner.nextDouble();
                    System.out.print("Masukkan Harga Dasar Tart: Rp ");
                    double hargaDasarTart = scanner.nextDouble();
                    
                    daftarKue.add(new KueTart(namaTart, ukuranTier, hargaDasarTart));
                    System.out.println("-> Kue Tart berhasil ditambahkan!");
                    break;

                case 4:
                    System.out.print("Masukkan Nama Kue Tradisional : ");
                    String namaTradisional = scanner.nextLine();
                    System.out.print("Masukkan Jumlah Biji          : ");
                    int jumlahBiji = scanner.nextInt();
                    System.out.print("Masukkan Harga per Biji       : Rp ");
                    double hargaPerBiji = scanner.nextDouble();
                    
                    daftarKue.add(new KueTradisional(namaTradisional, jumlahBiji, hargaPerBiji));
                    System.out.println("-> Kue Tradisional berhasil ditambahkan!");
                    break;

                case 5:
                    if (daftarKue.isEmpty()) {
                        System.out.println("\n[!] Belum ada data kue yang dimasukkan.");
                        break;
                    }

                    double totalHargaSemua = 0;
                    double totalDiskonSemua = 0;

                    System.out.println("\n=========================================");
                    System.out.println("       DAFTAR PRODUK SMART BAKERY        ");
                    System.out.println("=========================================\n");

                    for (Kue k : daftarKue) {
                        System.out.println(k.toString());
                        double hargaFinal = k.hitungHarga();
                        System.out.println("Harga Akhir : Rp " + hargaFinal);

                        // Pengecekan Interface menggunakan instanceof
                        if (k instanceof DapatDibungkus) {
                            ((DapatDibungkus) k).bungkus();
                        }

                        if (k instanceof DapatDiskon) {
                            double diskon = ((DapatDiskon) k).hitungDiskon();
                            totalDiskonSemua += diskon;
                            System.out.println("Diskon      : Rp " + diskon);
                        }

                        totalHargaSemua += hargaFinal;
                        System.out.println("-----------------------------------------");
                    }

                    System.out.println("\n=========================================");
                    System.out.println("TOTAL KESELURUHAN");
                    System.out.println("Total Harga  : Rp " + totalHargaSemua);
                    System.out.println("Total Diskon : Rp " + totalDiskonSemua);
                    System.out.println("=========================================");
                    break;

                case 6:
                    System.out.println("Terima kasih telah menggunakan Smart Bakery Store!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih angka 1-6.");
            }
        } while (pilihan != 6);
        
        scanner.close();
    }
}