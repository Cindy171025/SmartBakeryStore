package com.mycompany.smartbakerystore;

public class DapurProduksi {
    private String namaDapur;
    private int kapasitasOven;

    public DapurProduksi(String namaDapur, int kapasitasOven) {
        this.namaDapur = namaDapur;
        this.kapasitasOven = kapasitasOven;
    }

    public void mulaiPanggang() {
        System.out.println("-> " + namaDapur + " diaktifkan. Kapasitas oven: " + kapasitasOven + " baki.");
    }
}