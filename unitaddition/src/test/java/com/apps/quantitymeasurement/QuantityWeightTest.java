package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityWeightTest {

    private static final double EPSILON = 1e-6;

    // ---------- EQUALITY TESTS ----------

    @Test
    void testEquality_KilogramToKilogram_SameValue() {
        QuantityWeight q1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight q2 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_KilogramToKilogram_DifferentValue() {
        QuantityWeight q1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight q2 = new QuantityWeight(2.0, WeightUnit.KILOGRAM);

        assertFalse(q1.equals(q2));
    }

    @Test
    void testEquality_KilogramToGram_EquivalentValue() {
        QuantityWeight q1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight q2 = new QuantityWeight(1000.0, WeightUnit.GRAM);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_GramToKilogram_EquivalentValue() {
        QuantityWeight q1 = new QuantityWeight(1000.0, WeightUnit.GRAM);
        QuantityWeight q2 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_KilogramToPound_EquivalentValue() {
        QuantityWeight q1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight q2 = new QuantityWeight(2.20462, WeightUnit.POUND);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_NullComparison() {
        QuantityWeight q1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        assertFalse(q1.equals(null));
    }

    @Test
    void testEquality_SameReference() {
        QuantityWeight q1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        assertTrue(q1.equals(q1));
    }

    // ---------- CONVERSION TESTS ----------

    @Test
    void testConversion_KilogramToGram() {
        QuantityWeight q = new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        QuantityWeight result = q.convertTo(WeightUnit.GRAM);

        assertEquals(1000.0, result.getValue(), EPSILON);
    }

    @Test
    void testConversion_GramToKilogram() {
        QuantityWeight q = new QuantityWeight(1000.0, WeightUnit.GRAM);

        QuantityWeight result = q.convertTo(WeightUnit.KILOGRAM);

        assertEquals(1.0, result.getValue(), EPSILON);
    }

    @Test
    void testConversion_KilogramToPound() {
        QuantityWeight q = new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        QuantityWeight result = q.convertTo(WeightUnit.POUND);

        assertEquals(2.20462, result.getValue(), 0.01);
    }

    @Test
    void testConversion_PoundToKilogram() {
        QuantityWeight q = new QuantityWeight(2.20462, WeightUnit.POUND);

        QuantityWeight result = q.convertTo(WeightUnit.KILOGRAM);

        assertEquals(1.0, result.getValue(), 0.01);
    }

    @Test
    void testConversion_SameUnit() {
        QuantityWeight q = new QuantityWeight(5.0, WeightUnit.KILOGRAM);

        QuantityWeight result = q.convertTo(WeightUnit.KILOGRAM);

        assertEquals(5.0, result.getValue(), EPSILON);
    }

    // ---------- ADDITION TESTS ----------

    @Test
    void testAddition_SameUnit_KilogramPlusKilogram() {
        QuantityWeight q1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight q2 = new QuantityWeight(2.0, WeightUnit.KILOGRAM);

        QuantityWeight result = q1.add(q2);

        assertEquals(3.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_CrossUnit_KilogramPlusGram() {
        QuantityWeight q1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight q2 = new QuantityWeight(1000.0, WeightUnit.GRAM);

        QuantityWeight result = q1.add(q2);

        assertEquals(2.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_CrossUnit_PoundPlusKilogram() {
        QuantityWeight q1 = new QuantityWeight(2.20462, WeightUnit.POUND);
        QuantityWeight q2 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        QuantityWeight result = q1.add(q2);

        assertEquals(4.40924, result.getValue(), 0.05);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Kilogram() {
        QuantityWeight q1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight q2 = new QuantityWeight(1000.0, WeightUnit.GRAM);

        QuantityWeight result = q1.add(q2, WeightUnit.GRAM);

        assertEquals(2000.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_Commutativity() {
        QuantityWeight q1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight q2 = new QuantityWeight(1000.0, WeightUnit.GRAM);

        QuantityWeight result1 = q1.add(q2);
        QuantityWeight result2 = q2.add(q1);

        assertTrue(result1.equals(result2));
    }

    // ---------- EDGE CASE TESTS ----------

    @Test
    void testAddition_WithZero() {
        QuantityWeight q1 = new QuantityWeight(5.0, WeightUnit.KILOGRAM);
        QuantityWeight q2 = new QuantityWeight(0.0, WeightUnit.GRAM);

        QuantityWeight result = q1.add(q2);

        assertEquals(5.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_NegativeValues() {
        QuantityWeight q1 = new QuantityWeight(5.0, WeightUnit.KILOGRAM);
        QuantityWeight q2 = new QuantityWeight(-2000.0, WeightUnit.GRAM);

        QuantityWeight result = q1.add(q2);

        assertEquals(3.0, result.getValue(), EPSILON);
    }

    @Test
    void testConversion_RoundTrip() {
        QuantityWeight q = new QuantityWeight(1.5, WeightUnit.KILOGRAM);

        QuantityWeight result =
                q.convertTo(WeightUnit.GRAM)
                 .convertTo(WeightUnit.KILOGRAM);

        assertEquals(1.5, result.getValue(), EPSILON);
    }

    // ---------- VALIDATION TESTS ----------

    @Test
    void testConstructor_NullUnit() {
        assertThrows(IllegalArgumentException.class,
                () -> new QuantityWeight(1.0, null));
    }

    @Test
    void testConstructor_InvalidValue() {
        assertThrows(IllegalArgumentException.class,
                () -> new QuantityWeight(Double.NaN, WeightUnit.KILOGRAM));
    }
}