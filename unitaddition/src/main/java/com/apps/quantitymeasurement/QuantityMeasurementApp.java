package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        System.out.println(
                q1.add(q2, LengthUnit.FEET)
        );

        System.out.println(
                q1.add(q2, LengthUnit.INCHES)
        );

        System.out.println(
                q1.add(q2, LengthUnit.YARDS)
        );

        QuantityLength q3 = new QuantityLength(36.0, LengthUnit.INCHES);
        QuantityLength q4 = new QuantityLength(1.0, LengthUnit.YARDS);

        System.out.println(
                q3.add(q4, LengthUnit.FEET)
        );
    }
}