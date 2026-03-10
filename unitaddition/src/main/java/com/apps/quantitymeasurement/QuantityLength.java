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

    // Convert this quantity to another unit
    public QuantityLength convertTo(LengthUnit targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double baseValue = unit.convertToBaseUnit(value);
        double converted = targetUnit.convertFromBaseUnit(baseValue);

        return new QuantityLength(converted, targetUnit);
    }

    // UC6 Addition (default unit)
    public QuantityLength add(QuantityLength other) {

        if (other == null) {
            throw new IllegalArgumentException("Quantity cannot be null");
        }

        double sumFeet =
                unit.convertToBaseUnit(value) +
                other.unit.convertToBaseUnit(other.value);

        double result = unit.convertFromBaseUnit(sumFeet);

        return new QuantityLength(result, unit);
    }

    // UC7 Addition with explicit target unit
    public QuantityLength add(QuantityLength other, LengthUnit targetUnit) {

        if (other == null) {
            throw new IllegalArgumentException("Quantity cannot be null");
        }

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double sumFeet =
                unit.convertToBaseUnit(value) +
                other.unit.convertToBaseUnit(other.value);

        double result = targetUnit.convertFromBaseUnit(sumFeet);

        return new QuantityLength(result, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof QuantityLength)) return false;

        QuantityLength other = (QuantityLength) obj;

        double thisFeet = unit.convertToBaseUnit(value);
        double otherFeet = other.unit.convertToBaseUnit(other.value);

        return Double.compare(thisFeet, otherFeet) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(unit.convertToBaseUnit(value));
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}