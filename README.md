# QuantityMeasurementApp

This project demonstrates progressive enhancement of a Quantity Measurement system using four use cases (UC1–UC4).  
Each use case builds upon the previous one, improving functionality, design, and scalability.

---

## ✅ UC1 – Feet Measurement Equality

**Branch:** `feature/UC1-FeetMeasurementEquality`

### Description
UC1 introduces object equality by implementing a `Feet` class to compare two measurements expressed in feet.

### Functional Scope
- Compare two feet measurements.
- Determine equality based on value (not reference).
- Validate numeric input.
- Ensure proper `equals()` and `hashCode()` implementation.

---

## ✅ UC2 – Feet and Inches Measurement Equality

**Branch:** `feature/UC2-FeetAndInchesMeasurementEquality`

### Description
UC2 extends UC1 by introducing an additional unit, **Inches**, and enabling cross-unit comparisons.

### Functional Scope
- Compare Feet ↔ Feet.
- Compare Inches ↔ Inches.
- Compare Feet ↔ Inches using conversion logic.
- Maintain equality contract across different units.

---

## ✅ UC3 – Generic Quantity Class (DRY Principle)

**Branch:** `feature/UC3-GenericQuantityClassForDRYPrinciple`

### Description
UC3 refactors the system to eliminate duplication introduced in UC2 by creating a generic `QuantityLength` class supported by a `LengthUnit` enum.

### Functional Scope
- Replace separate Feet and Inches classes.
- Centralize unit conversion logic.
- Support cross-unit equality through a single class.
- Preserve all UC1 and UC2 functionality.

### Design Changes
- Introduced `LengthUnit` enum for type-safe unit representation.
- Implemented a single `QuantityLength` class.
- Centralized conversion to a base unit (feet).

---

## ✅ UC4 – Extended Unit Support

**Branch:** `feature/UC4-ExtendedUnitSupport`

### Description
UC4 extends the scalable design from UC3 by introducing additional units: **Yards** and **Centimeters**.

### Functional Scope
- Add support for:
  - Yards
  - Centimeters
- Maintain full backward compatibility.
- Ensure seamless cross-unit comparisons.

---
