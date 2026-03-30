package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityLengthTest {

    private static final double EPSILON = 0.001;

    // 1️⃣ Explicit Target Unit: Feet
    @Test
    void testAddition_ExplicitTargetUnit_Feet() {

        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength result = q1.add(q2, LengthUnit.FEET);

        assertEquals(2.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    // 2️⃣ Explicit Target Unit: Inches
    @Test
    void testAddition_ExplicitTargetUnit_Inches() {

        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength result = q1.add(q2, LengthUnit.INCHES);

        assertEquals(24.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }

    // 3️⃣ Explicit Target Unit: Yards
    @Test
    void testAddition_ExplicitTargetUnit_Yards() {

        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength result = q1.add(q2, LengthUnit.YARDS);

        assertEquals(0.666, result.getValue(), EPSILON);
        assertEquals(LengthUnit.YARDS, result.getUnit());
    }

    // 4️⃣ Explicit Target Unit: Centimeters
    @Test
    void testAddition_ExplicitTargetUnit_Centimeters() {

        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.INCHES);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.INCHES);

        QuantityLength result = q1.add(q2, LengthUnit.CENTIMETERS);

        assertEquals(5.08, result.getValue(), EPSILON);
        assertEquals(LengthUnit.CENTIMETERS, result.getUnit());
    }

    // 5️⃣ Target same as first operand
    @Test
    void testAddition_TargetUnit_SameAsFirstOperand() {

        QuantityLength q1 = new QuantityLength(2.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(3.0, LengthUnit.FEET);

        QuantityLength result = q1.add(q2, LengthUnit.YARDS);

        assertEquals(3.0, result.getValue(), EPSILON);
    }

    // 6️⃣ Target same as second operand
    @Test
    void testAddition_TargetUnit_SameAsSecondOperand() {

        QuantityLength q1 = new QuantityLength(2.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(3.0, LengthUnit.FEET);

        QuantityLength result = q1.add(q2, LengthUnit.FEET);

        assertEquals(9.0, result.getValue(), EPSILON);
    }

    // 7️⃣ Commutativity
    @Test
    void testAddition_Commutativity() {

        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength result1 = q1.add(q2, LengthUnit.YARDS);
        QuantityLength result2 = q2.add(q1, LengthUnit.YARDS);

        assertEquals(result1.getValue(), result2.getValue(), EPSILON);
    }

    // 8️⃣ With Zero
    @Test
    void testAddition_WithZero() {

        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(0.0, LengthUnit.INCHES);

        QuantityLength result = q1.add(q2, LengthUnit.YARDS);

        assertEquals(1.667, result.getValue(), EPSILON);
    }

    // 9️⃣ Negative Values
    @Test
    void testAddition_NegativeValues() {

        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(-2.0, LengthUnit.FEET);

        QuantityLength result = q1.add(q2, LengthUnit.INCHES);

        assertEquals(36.0, result.getValue(), EPSILON);
    }

    // 🔟 Null Target Unit
    @Test
    void testAddition_NullTargetUnit() {

        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        assertThrows(
                IllegalArgumentException.class,
                () -> q1.add(q2, null)
        );
    }

    // 1️⃣1️⃣ Large to Small Scale
    @Test
    void testAddition_LargeToSmallScale() {

        QuantityLength q1 = new QuantityLength(1000.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(500.0, LengthUnit.FEET);

        QuantityLength result = q1.add(q2, LengthUnit.INCHES);

        assertEquals(18000.0, result.getValue(), EPSILON);
    }

    // 1️⃣2️⃣ Small to Large Scale
    @Test
    void testAddition_SmallToLargeScale() {

        QuantityLength q1 = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength result = q1.add(q2, LengthUnit.YARDS);

        assertEquals(0.667, result.getValue(), EPSILON);
    }

}