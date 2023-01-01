package com.uaspbo;

import java.util.HashMap;
import java.util.Map;

import com.uaspbo.Abstract.HitungRotiAbstract;
import com.uaspbo.Interface.BahanRotiInterface;
import com.uaspbo.Interface.BahanVariantInterface;

public class Roti extends HitungRotiAbstract implements BahanRotiInterface, BahanVariantInterface {
  
  public double beratDough;
  public double beratTerigu;
  public double beratGula;
  public double beratButter;
  public double beratRagi;
  public double beratSusuBubuk;
  public double beratSusuCair;
  public double beratTelur;
  public double beratEsBatu;
  public double beratTotal;
  public double jumlahRoti;
  public double jumlahPesanan;

  
  @Override
  public Double hitungKeju(Double berat) {
    Double a = berat / keju[0] * keju[1];
    return a;
  }

  @Override
  public Double hitungCoklat(Double berat) {
    Double b = berat / coklat[0] * coklat[1];
    return b;
  }

  @Override
  public Double hitungVanilla(Double berat) {
    Double c = berat / vanilla[0] * vanilla[1];
    return c;
  }

  @Override
  public Double hitungRedBean(Double berat) {
    Double d = berat / redBean[0] * redBean[1];
    return d;
  }

  @Override
  public Double hitungSosis(Double berat) {
    Double e = berat / sosis[0] * sosis[1];
    return e;
  }

  @Override
  public Double hitungBeef(Double berat) {
    Double f = berat / beef[0] * beef[1];
    return f;
  }

  @Override
  public Double hitungBawangBombay(Double berat) {
    Double g = berat / bawangBombay[0] * bawangBombay[1];
    return g;
  }

  @Override
  public Map<String, Double> hitungBiayaDasar() {
    Double a = this.beratTerigu / terigu[0] * terigu[1];
    Double b = this.beratGula / gula[0] * gula[1];
    Double c = this.beratButter / butter[0] * butter[1];
    Double d = this.beratRagi / ragi[0] * ragi[1];
    Double e = this.beratSusuBubuk / susuBubuk[0] * susuBubuk[1];
    Double f = this.beratSusuCair / susuCair[0] * susuCair[1];
    Double g = this.beratTelur / telur[0] * telur[1];
    Double h = this.beratEsBatu / esBatu[0] * esBatu[1];
    
    Map<String, Double> total = new HashMap<String, Double>();

    Double totalBiaya = a + b + c + d + e + f + g + h;
    Double biayaPcs = totalBiaya / this.jumlahPesanan;

    total.put("totalBiaya", totalBiaya);
    total.put("biayaPcs", biayaPcs);

    return total;
  }

}
