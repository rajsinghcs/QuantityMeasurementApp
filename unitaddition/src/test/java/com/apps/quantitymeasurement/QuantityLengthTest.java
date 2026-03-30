package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityLengthTest {

    private static final double EPSILON = 0.001;

    // ---------- ENUM CONSTANT TESTS ----------

    @Test
    void testLengthUnitEnum_FeetConstant() {
        assertEquals(1.0, LengthUnit.FEET.getConversionFactor(), EPSILON);
    }

    @Test
    void testLengthUnitEnum_InchesConstant() {
        assertEquals(1.0 / 12.0, LengthUnit.INCHES.getConversionFactor(), EPSILON);
    }

    @Test
    void testLengthUnitEnum_YardsConstant() {
        assertEquals(3.0, LengthUnit.YARDS.getConversionFactor(), EPSILON);
    }

    @Test
    void testLengthUnitEnum_CentimetersConstant() {
        assertEquals(1.0 / 30.48, LengthUnit.CENTIMETERS.getConversionFactor(), EPSILON);
    }

    // ---------- CONVERT TO BASE UNIT ----------

    @Test
    void testConvertToBaseUnit_FeetToFeet() {
        assertEquals(5.0,
                LengthUnit.FEET.convertToBaseUnit(5.0),
                EPSILON);
    }

    @Test
    void testConvertToBaseUnit_InchesToFeet() {
        assertEquals(1.0,
                LengthUnit.INCHES.convertToBaseUnit(12.0),
                EPSILON);
    }

    @Test
    void testConvertToBaseUnit_YardsToFeet() {
        assertEquals(3.0,
                LengthUnit.YARDS.convertToBaseUnit(1.0),
                EPSILON);
    }

    @Test
    void testConvertToBaseUnit_CentimetersToFeet() {
        assertEquals(1.0,
                LengthUnit.CENTIMETERS.convertToBaseUnit(30.48),
                EPSILON);
    }

    // ---------- CONVERT FROM BASE UNIT ----------

    @Test
    void testConvertFromBaseUnit_FeetToFeet() {
        assertEquals(2.0,
                LengthUnit.FEET.convertFromBaseUnit(2.0),
                EPSILON);
    }

    @Test
    void testConvertFromBaseUnit_FeetToInches() {
        assertEquals(12.0,
                LengthUnit.INCHES.convertFromBaseUnit(1.0),
                EPSILON);
    }

    @Test
    void testConvertFromBaseUnit_FeetToYards() {
        assertEquals(1.0,
                LengthUnit.YARDS.convertFromBaseUnit(3.0),
                EPSILON);
    }

    @Test
    void testConvertFromBaseUnit_FeetToCentimeters() {
        assertEquals(30.48,
                LengthUnit.CENTIMETERS.convertFromBaseUnit(1.0),
                EPSILON);
    }

    // ---------- QUANTITY EQUALITY ----------

    @Test
    void testQuantityLengthRefactored_Equality() {

        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        assertTrue(q1.equals(q2));
    }

    // ---------- CONVERSION ----------

    @Test
    void testQuantityLengthRefactored_ConvertTo() {

        QuantityLength q = new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength result = q.convertTo(LengthUnit.INCHES);

        assertEquals(12.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }

    // ---------- ADDITION ----------

    @Test
    void testQuantityLengthRefactored_Add() {

        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength result = q1.add(q2, LengthUnit.FEET);

        assertEquals(2.0, result.getValue(), EPSILON);
    }

    @Test
    void testQuantityLengthRefactored_AddWithTargetUnit() {

        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength result = q1.add(q2, LengthUnit.YARDS);

        assertEquals(0.666, result.getValue(), EPSILON);
        assertEquals(LengthUnit.YARDS, result.getUnit());
    }

    // ---------- NULL UNIT VALIDATION ----------

    @Test
    void testQuantityLengthRefactored_NullUnit() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new QuantityLength(1.0, null)
        );
    }

    // ---------- INVALID VALUE VALIDATION ----------

    @Test
    void testQuantityLengthRefactored_InvalidValue() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new QuantityLength(Double.NaN, LengthUnit.FEET)
        );
    }

    // ---------- ROUND TRIP CONVERSION ----------

    @Test
    void testRoundTripConversion_RefactoredDesign() {

        QuantityLength q = new QuantityLength(10.0, LengthUnit.FEET);

        QuantityLength converted =
                q.convertTo(LengthUnit.INCHES)
                 .convertTo(LengthUnit.FEET);

        assertEquals(q.getValue(), converted.getValue(), EPSILON);
    }

    // ---------- ZERO ADDITION ----------

    @Test
    void testAddition_WithZero() {

        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(0.0, LengthUnit.INCHES);

        QuantityLength result = q1.add(q2, LengthUnit.FEET);

        assertEquals(5.0, result.getValue(), EPSILON);
    }

}