package com.uaspbo;

import java.util.Map;

import com.uaspbo.Interface.FillingInterface;
import com.uaspbo.Interface.ToppingInterface;

public class RotiManis extends Roti implements FillingInterface, ToppingInterface {
  private int variant;
  private double ratioHarga;

  void inputPesanan(Integer a) {
    this.jumlahPesanan = a;
    this.jumlahRoti = 47.0;
    this.ratioHarga = this.jumlahPesanan / this.jumlahRoti;

    this.beratDough = ((double) Math.round(100 * 50.0 * ratioHarga) / 100);
    this.beratTerigu = ((double) Math.round(100 * 1000.0 * ratioHarga) / 100);
    this.beratGula = ((double) Math.round(100 * 150.0 * ratioHarga) / 100);
    this.beratButter = ((double) Math.round(100 * 150.0 * ratioHarga) / 100);
    this.beratRagi = ((double) Math.round(100 * 20.0 * ratioHarga) / 100);
    this.beratSusuBubuk = ((double) Math.round(100 * 300.0 * ratioHarga) / 100);
    this.beratSusuCair = ((double) Math.round(100 * 250.0 * ratioHarga) / 100);
    this.beratTelur = ((double) Math.round(100 * 80.0 * ratioHarga) / 100);
    this.beratEsBatu = ((double) Math.round(100 * 400.0 * ratioHarga) / 100);
    this.beratTotal = ((double) Math.round(100 * 2350.0 * ratioHarga) / 100);

  }

  void hitungFilling() {
    if (variant == 1) {
      Double[] keju = { 5.0, this.hitungKeju(5.0) };
      Double[] coklat = { 5.0, this.hitungCoklat(5.0) };
      Double[] total = { 5.0 + 5.0, keju[1] + coklat[1] };

      totalFilling.put("Keju", keju);
      totalFilling.put("Coklat", coklat);
      totalFilling.put("total", total);

    } else if (variant == 2) {
      Double[] redBean = { 10.0, this.hitungRedBean(10.0) };

      totalFilling.put("Red Bean", redBean);
      totalFilling.put("total", redBean);

    } else if (variant == 3) {
      Double[] keju = { 10.0, this.hitungKeju(10.0) };
      Double[] sosis = { 10.0, this.hitungSosis(10.0) };
      Double[] total = { 10.0 + 10.0, keju[1] + sosis[1] };

      totalFilling.put("Keju", keju);
      totalFilling.put("Sosis", sosis);
      totalFilling.put("total", total);
    } else {
      System.out.println("Variant tidak ada, variant yang tersedia untuk Roti Manis adalah (1, 2, 3)");
      System.exit(0);
    }
  }

  void hitungTopping() {
    if (variant == 1) {
      Double[] coklat = { 5.0, this.hitungCoklat(5.0) };

      totalTopping.put("Coklat", coklat);
      totalTopping.put("total", coklat);

    } else if (variant == 2) {
      Double[] vanillla = { 5.0, this.hitungVanilla(5.0) };

      totalTopping.put("Vanilla", vanillla);
      totalTopping.put("total", vanillla);

    } else if (variant == 3) {
      Double[] total = { 0.0, 0.0 };
      totalTopping.put("total", total);
    }
  }

  void inputVariant(Integer v) {
    this.variant = v;
    this.hitungFilling();
    this.hitungTopping();
  }

  void procesHasil() {
    Map<String, Double> biayaDasar = this.hitungBiayaDasar();
    Map<String, Double[]> biayaFilling = totalFilling;
    Map<String, Double[]> biayaTopping = totalTopping;

    Double totalHarga = (biayaDasar.get("biayaPcs") + biayaFilling.get("total")[1] + biayaTopping.get("total")[1]);

    Double hargaJual = totalHarga * 1.5;
    Double hargaJualTotal = hargaJual * this.jumlahPesanan;

    System.out.println("=====================================");
    System.out.println("========= Pesanan Roti Manis ========");
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
        System.out.println("");
        ;
      } else {
        System.out.println("\t" + key + "  : " + value[0]);
      }
    });
    System.out.println("Topping : ");
    totalTopping.forEach((key, value) -> {
      if (key.equals("total")) {
        System.out.println("");
        ;
      } else {
        System.out.println("\t" + key + "   : " + value[0]);
      }
    });
    System.out.println("Total             : " + (totalFilling.get("total")[0] + totalTopping.get("total")[0]));
    System.out.println("============= Harga Bahan ===========");
    System.out.println("Harga /pcs        : " + ((double) Math.round(totalHarga * 100) / 100));
    System.out.println("Harga total       : " + ((double) Math.round(totalHarga * this.jumlahPesanan  * 100) / 100));
    System.out.println("==== Harga Jual Keuntungan (50%) ====");
    System.out.println("Harga jual /pcs   : " + ((double) Math.round(hargaJual * 100) / 100));
    System.out.println("Harga jual total  : " + ((double) Math.round(hargaJualTotal * 100) / 100));
    totalFilling.clear();
    totalTopping.clear();
  }

}