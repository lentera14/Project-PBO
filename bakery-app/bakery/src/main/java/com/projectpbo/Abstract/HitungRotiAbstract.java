package com.uaspbo.Abstract;

import java.util.Map;

public abstract class HitungRotiAbstract {
  public abstract Map<String, Double> hitungBiayaDasar();

  public abstract Double hitungKeju(Double berat);

  public abstract Double hitungCoklat(Double berat);

  public abstract Double hitungVanilla(Double berat);

  public abstract Double hitungRedBean(Double berat);

  public abstract Double hitungSosis(Double berat);

  public abstract Double hitungBeef(Double berat);

  public abstract Double hitungBawangBombay(Double berat);
}
