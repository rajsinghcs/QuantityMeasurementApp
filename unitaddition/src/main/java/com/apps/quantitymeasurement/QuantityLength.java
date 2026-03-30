package com.apps.quantitymeasurement;

public class QuantityLength {

    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
        }

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    private double convertToBase() {
        return unit.toFeet(value);
    }


    //add quantity length method
    public QuantityLength add(QuantityLength other) {

        if (other == null) {
            throw new IllegalArgumentException("Quantity cannot be null");
        }

        double sumFeet = this.convertToBase() + other.convertToBase();
        double result = unit.fromFeet(sumFeet);

        return new QuantityLength(result, unit);
    }

    // add method with explicit target unit

    public QuantityLength add(QuantityLength other, LengthUnit targetUnit) {

        if (other == null) {
            throw new IllegalArgumentException("Quantity cannot be null");
        }

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double sumFeet = addInFeet(other);

        double result = targetUnit.fromFeet(sumFeet);

        return new QuantityLength(result, targetUnit);
    }

    // private unity method
    private double addInFeet(QuantityLength other) {
        return this.convertToBase() + other.convertToBase();
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof QuantityLength)) return false;

        QuantityLength other = (QuantityLength) obj;

        return Double.compare(this.convertToBase(), other.convertToBase()) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(convertToBase());
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}