package com.uaspbo;

import java.util.Map;

import com.uaspbo.Interface.ToppingInterface;

public class Pizza extends Roti implements ToppingInterface {
  private int variant;
  private double ratioHarga;

  void inputPesanan(Integer a) {
    this.jumlahPesanan = a;
    this.jumlahRoti = 10.263;
    this.ratioHarga = this.jumlahPesanan / this.jumlahRoti;

    this.beratDough = ((double) Math.round(100 * 190.0 * ratioHarga) / 100);
    this.beratTerigu = ((double) Math.round(100 * 1000.0 * ratioHarga) / 100);
    this.beratGula = ((double) Math.round(100 * 100.0 * ratioHarga) / 100);
    this.beratButter = ((double) Math.round(100 * 100.0 * ratioHarga) / 100);
    this.beratRagi = ((double) Math.round(100 * 20.0 * ratioHarga) / 100);
    this.beratSusuBubuk = ((double) Math.round(100 * 200.0 * ratioHarga) / 100);
    this.beratSusuCair = ((double) Math.round(100 * 180.0 * ratioHarga) / 100);
    this.beratTelur = ((double) Math.round(100 * 50.0 * ratioHarga) / 100);
    this.beratEsBatu = ((double) Math.round(100 * 300.0 * ratioHarga) / 100);
    this.beratTotal = ((double) Math.round(100 * 1950.0 * ratioHarga) / 100);

  }

  void hitungTopping() {
    if (variant == 1) {
      Double[] keju = { 30.0, this.hitungKeju(30.0) };
      Double[] sosis = { 50.0, this.hitungSosis(50.0) };
      Double[] beef = { 50.0, this.hitungBeef(50.0) };
      Double[] bawang = { 30.0, this.hitungBawangBombay(30.0) };

      Double[] total = { 30.0 + 30.0 + 50.0 + 50.0, keju[1] + sosis[1] + beef[1] + bawang[1] };

      totalTopping.put("Keju", keju);
      totalTopping.put("Sosis", sosis);
      totalTopping.put("Smoked Beef", beef);
      totalTopping.put("Bawang Bombay", bawang);
      totalTopping.put("total", total);

    } else {
      System.out.println("Variant tidak ada, variant yang tersedia untuk Pizza adalah (1)");
      System.exit(0);
    }
  }

  void inputVariant(Integer v) {
    this.variant = v;
    this.hitungTopping();
  }

  void procesHasil() {
    Map<String, Double> biayaDasar = this.hitungBiayaDasar();
    Map<String, Double[]> biayaTopping = totalTopping;

    Double totalHarga = (biayaDasar.get("biayaPcs") + biayaTopping.get("total")[1]);

    Double hargaJual = totalHarga * 1.5;
    Double hargaJualTotal = hargaJual * this.jumlahPesanan;

    System.out.println("=====================================");
    System.out.println("============ Pesanan Pizza ==========");
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
    System.out.println("Topping : ");
    totalTopping.forEach((key, value) -> {
      if (key.equals("total")) {
        System.out.print("");
        ;
      } else {
        System.out.println("\t" + key + "   : " + value[0]);
      }
    });
    System.out.println("Total             : " + (totalTopping.get("total")[0]));
    System.out.println("============= Harga Bahan ===========");
    System.out.println("Harga /pcs        : " + ((double) Math.round(totalHarga * 100) / 100));
    System.out.println("Harga total       : " + ((double) Math.round(totalHarga * this.jumlahPesanan * 100) / 100));
    System.out.println("==== Harga Jual Keuntungan (50%) ====");
    System.out.println("Harga jual /pcs   : " + ((double) Math.round(hargaJual * 100) / 100));
    System.out.println("Harga jual total  : " + ((double) Math.round(hargaJualTotal * 100) / 100));
    totalTopping.clear();
  }
}
