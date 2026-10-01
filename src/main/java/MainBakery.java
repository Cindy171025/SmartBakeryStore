package com.mycompany.smartbakerystore;

import java.util.ArrayList;
import java.util.Scanner;

public class MainBakery {

    // Compile-Time Polymorphism (Method Overloading) - Berdasarkan Nama (String)
    public static void cariKue(ArrayList<Kue> list, String keyword) {
        System.out.println("\n--- Hasil Pencarian Berdasarkan Nama Kue ---");
        boolean ketemu = false;
        for (Kue k : list) {
            if (k.getNamaKue().equalsIgnoreCase(keyword)) {
                k.tampilkanInfo();
                ketemu = true;
            }
        }
        if (!ketemu) {
            System.out.println("Kue tidak ditemukan di etalase.");
        }
    }

    // Compile-Time Polymorphism (Method Overloading) - Berdasarkan Harga Maksimal (Double)
    public static void cariKue(ArrayList<Kue> list, double maxHarga) {
        System.out.println("\n--- Hasil Pencarian Kue di Bawah Harga Rp" + maxHarga + " ---");
        boolean ketemu = false;
        for (Kue k : list) {
            if (k.getHarga() <= maxHarga) {
                k.tampilkanInfo();
                ketemu = true;
            }
        }
        if (!ketemu) {
            System.out.println("Tidak ada kue di bawah harga tersebut.");
        }
    }

    // Runtime Polymorphism & Upcasting (Parameter Superclass)
    public static void simulasiPenyajian(Kue item) {
        item.jenisPenyajian();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Wadah ArrayList bertipe Superclass (Kue) menampung berbagai Subclass secara polimorfis
        ArrayList<Kue> daftarKue = new ArrayList<>();
        int pilihan;

        // Inisialisasi data awal mencakup ke-4 variasi subclass
        daftarKue.add(new KueBasah("Bika Ambon", 35000, 10, 3));
        daftarKue.add(new KueKering("Nastar", 65000, 25, "Toples Besar"));
        daftarKue.add(new KueTart("Black Forest", 150000, 5, 24));
        daftarKue.add(new KueTradisional("Getuk Lindri", 15000, 40, "Jawa Tengah"));

        do {
            System.out.println("\n==================================================");
            System.out.println("            SMART BAKERY STORE   ");
            System.out.println("==================================================");
            System.out.println("1. Tambah Kue Baru (Basah, Kering, Tart, Tradisional)");
            System.out.println("2. Tampilkan Etalase & Dynamic Binding");
            System.out.println("3. Pencarian Kue (Method Overloading)");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("\nPilih Jenis Kue:");
                    System.out.println("1. Kue Basah");
                    System.out.println("2. Kue Kering");
                    System.out.println("3. Kue Tart");
                    System.out.println("4. Kue Tradisional");
                    System.out.print("Masukkan pilihan (1-4): ");
                    int jenis = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nama Kue    : ");
                    String nama = scanner.nextLine();
                    System.out.print("Harga (Rp)  : ");
                    double harga = scanner.nextDouble();
                    System.out.print("Jumlah Stok : ");
                    int stok = scanner.nextInt();
                    scanner.nextLine();

                    if (jenis == 1) {
                        System.out.print("Daya Tahan (hari): ");
                        int tahan = scanner.nextInt();
                        daftarKue.add(new KueBasah(nama, harga, stok, tahan));
                    } else if (jenis == 2) {
                        System.out.print("Jenis Kemasan Toples: ");
                        String toples = scanner.nextLine();
                        daftarKue.add(new KueKering(nama, harga, stok, toples));
                    } else if (jenis == 3) {
                        System.out.print("Diameter Tart (cm): ");
                        int diam = scanner.nextInt();
                        daftarKue.add(new KueTart(nama, harga, stok, diam));
                    } else {
                        System.out.print("Asal Daerah: ");
                        String asal = scanner.nextLine();
                        daftarKue.add(new KueTradisional(nama, harga, stok, asal));
                    }
                    System.out.println("-> Kue berhasil ditambahkan!");
                    break;

                case 2:
                    System.out.println("\n==================================================");
                    System.out.println("      DAFTAR ETALASE & RUNTIME POLYMORPHISM       ");
                    System.out.println("==================================================");
                    System.out.println("Total Objek Kue Dibuat: " + Kue.getTotalKueDibuat());
                    
                    for (int i = 0; i < daftarKue.size(); i++) {
                        System.out.print((i + 1) + ". ");
                        // Dynamic Binding: Java secara otomatis mengeksekusi method sesuai wujud asli objek saat runtime
                        daftarKue.get(i).tampilkanInfo();
                        simulasiPenyajian(daftarKue.get(i));
                        System.out.println("--------------------------------------------------");
                    }
                    break;

                case 3:
                    System.out.println("\n--- MENU PENCARIAN (METHOD OVERLOADING) ---");
                    System.out.println("1. Berdasarkan Nama Kue (String)");
                    System.out.println("2. Berdasarkan Batas Maksimal Harga (Double)");
                    System.out.print("Pilih metode (1/2): ");
                    int subPilih = scanner.nextInt();
                    scanner.nextLine();

                    if (subPilih == 1) {
                        System.out.print("Masukkan nama kue: ");
                        String nCari = scanner.nextLine();
                        cariKue(daftarKue, nCari);
                    } else {
                        System.out.print("Masukkan batas maksimal harga (Rp): ");
                        double hCari = scanner.nextDouble();
                        cariKue(daftarKue, hCari);
                    }
                    break;

                case 4:
                    System.out.println("\nProgram selesai. Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 4);

        scanner.close();
    }
}