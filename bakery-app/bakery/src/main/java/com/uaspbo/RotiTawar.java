package com.uaspbo;

import java.util.Map;

import com.uaspbo.Interface.FillingInterface;

public class RotiTawar extends Roti implements FillingInterface {
  private int variant;
  private double ratioHarga;

  void inputPesanan(Integer a) {
    this.jumlahPesanan = a;
    this.jumlahRoti = 5.1625;
    this.ratioHarga = this.jumlahPesanan / this.jumlahRoti;

    this.beratDough = ((double) Math.round(100 * 400.0 * ratioHarga) / 100);
    this.beratTerigu = ((double) Math.round(100 * 1000.0 * ratioHarga) / 100);
    this.beratGula = ((double) Math.round(100 * 125.0 * ratioHarga) / 100);
    this.beratButter = ((double) Math.round(100 * 100.0 * ratioHarga) / 100);
    this.beratRagi = ((double) Math.round(100 * 20.0 * ratioHarga) / 100);
    this.beratSusuBubuk = ((double) Math.round(100 * 350.0 * ratioHarga) / 100);
    this.beratSusuCair = ((double) Math.round(100 * 200.0 * ratioHarga) / 100);
    this.beratTelur = ((double) Math.round(100 * 70.0 * ratioHarga) / 100);
    this.beratEsBatu = ((double) Math.round(100 * 300.0 * ratioHarga) / 100);
    this.beratTotal = ((double) Math.round(100 * 2065.0 * ratioHarga) / 100);

  }

  void hitungFilling() {
    if (variant == 1) {
      Double[] coklat = { 80.0, this.hitungCoklat(80.0) };

      totalFilling.put("Coklat", coklat);
      totalFilling.put("total", coklat);

    } else if (variant == 2) {
      Double[] keju = { 80.0, this.hitungKeju(80.0) };

      totalFilling.put("Keju", keju);
      totalFilling.put("total", keju);

    } else {
      System.out.println("Variant tidak ada, variant yang tersedia untuk Roti Tawar adalah (1, 2)");
      System.exit(0);
    }
  }

  void inputVariant(Integer v) {
    this.variant = v;
    this.hitungFilling();
  }

  void procesHasil() {
    Map<String, Double> biayaDasar = this.hitungBiayaDasar();
    Map<String, Double[]> biayaFilling = totalFilling;

    Double totalHarga = (biayaDasar.get("biayaPcs") + biayaFilling.get("total")[1]);

    Double hargaJual = totalHarga * 1.5;
    Double hargaJualTotal = hargaJual * this.jumlahPesanan;

    System.out.println("=====================================");
    System.out.println("========= Pesanan Roti Tawar ========");
    System.out.println("=====================================");
    System.out.println("Varian            : " + this.variant);
    System.out.println("Jumlah Pesanan    : " + this.jumlahPesanan);
    System.out.println("======== Berat Bahan (gram) =========");
    System.out.println("Tepung terigu     : " + this.beratTerigu);
    System.out.println("Gula Pasir        : " + this.beratGula);
    System.out.println("Butter            : " + this.beratButter);
    System.out.println("Ragi              : " + this.beratRagi);
    System.out.println("Susu bubuk        : " + this.beratSusuBubuk);
    System.out.println("Susu cair         : " + this.beratSusuCair);
    System.out.println("Telur             : " + this.beratTelur);
    System.out.println("Es Batu           : " + this.beratEsBatu);
    System.out.println("Total Berat       : " + this.beratTotal);
    System.out.println("");
    System.out.println("============ Berat Variant ==========");
    System.out.println("Filling : ");
    totalFilling.forEach((key, value) -> {
      if (key.equals("total")) {
        System.out.print("");
        ;
      } else {
        System.out.println("\t" + key + "          : " + value[0]);
      }
    });
    System.out.println("Total             : " + (totalFilling.get("total")[0]));
    System.out.println("============= Harga Bahan ===========");
    System.out.println("Harga /pcs        : " + ((double) Math.round(totalHarga * 100) / 100));
    System.out.println("Harga total       : " + ((double) Math.round(totalHarga * this.jumlahPesanan * 100) / 100));
    System.out.println("==== Harga Jual Keuntungan (50%) ====");
    System.out.println("Harga jual /pcs   : " + ((double) Math.round(hargaJual * 100) / 100));
    System.out.println("Harga jual total  : " + ((double) Math.round(hargaJualTotal * 100) / 100));
    totalFilling.clear();
  }
}
