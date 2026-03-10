package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1000.0, WeightUnit.GRAM);

        System.out.println("Equality Test:");
        System.out.println(w1.equals(w2));

        QuantityWeight converted = w1.convertTo(WeightUnit.POUND);
        System.out.println("Convert 1 KG to Pound: " + converted);

        QuantityWeight sum = w1.add(w2);
        System.out.println("Addition: " + sum);

        QuantityWeight sumInGram = w1.add(w2, WeightUnit.GRAM);
        System.out.println("Addition in Gram: " + sumInGram);
    }
}