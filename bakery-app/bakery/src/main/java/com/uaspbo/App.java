package com.uaspbo;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) {

    RotiManis rotiManis = new RotiManis();
    RotiTawar rotiTawar = new RotiTawar();
    Pizza pizza = new Pizza();

    Scanner input = new Scanner(System.in);

    while (true) {
      System.out.println("1. Roti Manis");
      System.out.println("2. Roti Tawar");
      System.out.println("3. Pizza");
      System.out.println("");
      System.out.print("Masukkan jenis roti pesanan : ");
      int jenis = input.nextInt();

      if(jenis == 1){
        System.out.println("");
        System.out.println("=====================================");
        System.out.println("========= Variant Roti Manis ========");
        System.out.println("=====================================");
        System.out.println("Variant 1");
        System.out.println("\tFilling : Keju, Coklat");
        System.out.println("\tTopping : Coklat");
        System.out.println("Variant 2");
        System.out.println("\tFilling : Red Bean");
        System.out.println("\tTopping : Vanilla");
        System.out.println("Variant 3");
        System.out.println("\tFilling : Keju, Sosis");
        System.out.println("\tTopping : -");
      } else if(jenis == 2){
        System.out.println("=====================================");
        System.out.println("========= Variant Roti Tawar ========");
        System.out.println("=====================================");
        System.out.println("Variant 1");
        System.out.println("\tFilling : Coklat");
        System.out.println("Variant 2");
        System.out.println("\tFilling : Keju");
      } else if(jenis == 3){
        System.out.println("=====================================");
        System.out.println("============ Variant Pizza ==========");
        System.out.println("=====================================");
        System.out.println("Variant 1");
        System.out.println("\tTopping : Keju, Sosis,");
        System.out.println("\t\tSmoked Beef, Bawang Bombay");
      } else {
        System.out.println("Mohom masukkan pesanan dengan benar (1, 2, 3)");
        break;
      }

      System.out.println("");
      System.out.print("Masukkan variant pesanan : ");
      int variant = input.nextInt();

      System.out.println("");
      System.out.print("Masukkan jumlah pesanan : ");
      int jmlh = input.nextInt();

      System.out.println("");
      if(jenis == 1){
        rotiManis.inputPesanan(jmlh);
        rotiManis.inputVariant(variant);
        rotiManis.procesHasil();
        break;
      } else if(jenis == 2) {
        rotiTawar.inputPesanan(jmlh);
        rotiTawar.inputVariant(variant);
        rotiTawar.procesHasil();
        break;
      } else if(jenis == 3){
        pizza.inputPesanan(jmlh);
        pizza.inputVariant(variant);
        pizza.procesHasil();
        break;
      }
    }

    input.close();

  }
}
