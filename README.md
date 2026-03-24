# QuantityMeasurementApp

This project demonstrates progressive enhancement of a **Quantity Measurement system using seventeen use cases (UC1–UC17)**.  
Each use case builds upon the previous one, improving functionality, design, scalability, and real-world applicability using Spring Boot.

---

## ✅ UC1 – Feet Measurement Equality  
**Branch:** feature/UC1-FeetMeasurementEquality  

### Description  
Introduces object equality by implementing a `Feet` class to compare measurements.

### Functional Scope
- Compare two feet measurements  
- Equality based on value (not reference)  
- Validate numeric input  
- Implement `equals()` and `hashCode()`  

---

## ✅ UC2 – Feet and Inches Measurement Equality  
**Branch:** feature/UC2-FeetAndInchesMeasurementEquality  

### Description  
Adds `Inches` unit and enables cross-unit comparison.

### Functional Scope
- Compare Feet ↔ Feet  
- Compare Inches ↔ Inches  
- Compare Feet ↔ Inches using conversion  
- Maintain equality contract  

---

## ✅ UC3 – Generic Quantity Class (DRY Principle)  
**Branch:** feature/UC3-GenericQuantityClassForDRYPrinciple  

### Description  
Refactors system using a generic `QuantityLength` class.

### Functional Scope
- Replace Feet & Inches classes  
- Centralize conversion logic  
- Support cross-unit comparison  

### Design Changes
- Introduced `LengthUnit` enum  
- Single reusable class  
- Conversion to base unit  

---

## ✅ UC4 – Extended Unit Support  
**Branch:** feature/UC4-ExtendedUnitSupport  

### Description  
Adds more units like Yards and Centimeters.

### Functional Scope
- Add Yards, Centimeters  
- Maintain backward compatibility  
- Seamless comparisons  

---

## ✅ UC5 – Addition of Quantities  
**Branch:** feature/UC5-AdditionOfQuantities  

### Description  
Introduces arithmetic operations on quantities.

### Functional Scope
- Add two quantities  
- Handle unit conversion before addition  
- Return result in standard unit  

---

## ✅ UC6 – Temperature Measurement  
**Branch:** feature/UC6-TemperatureMeasurement  

### Description  
Adds temperature measurement with special conversion rules.

### Functional Scope
- Support Celsius & Fahrenheit  
- Handle non-linear conversions  
- Compare temperatures correctly  

---

## ✅ UC7 – Weight Measurement  
**Branch:** feature/UC7-WeightMeasurement  

### Description  
Introduces weight units and operations.

### Functional Scope
- Support kg, grams, tonnes  
- Conversion and comparison  
- Arithmetic operations  

---

## ✅ UC8 – Volume Measurement  
**Branch:** feature/UC8-VolumeMeasurement  

### Description  
Adds volume measurement support.

### Functional Scope
- Support litre, ml, gallon  
- Conversion + operations  
- Extend system scalability  

---

## ✅ UC9 – Factory Design Pattern  
**Branch:** feature/UC9-FactoryPattern  

### Description  
Introduces Factory pattern for object creation.

### Functional Scope
- Create measurement objects dynamically  
- Remove tight coupling  
- Improve extensibility  

---

## ✅ UC10 – Strategy Pattern  
**Branch:** feature/UC10-StrategyPattern  

### Description  
Applies Strategy pattern for conversion logic.

### Functional Scope
- Separate conversion algorithms  
- Plug-and-play measurement strategies  
- Improve maintainability  

---

## ✅ UC11 – Exception Handling (Basic)  
**Branch:** feature/UC11-ExceptionHandling  

### Description  
Introduces custom exception handling.

### Functional Scope
- Handle invalid units  
- Prevent invalid operations  
- Custom exceptions for errors  

---

## ✅ UC12 – Persistence with Repository  
**Branch:** feature/UC12-PersistenceLayer  

### Description  
Adds database support using JPA.

### Functional Scope
- Store operations in DB  
- Use repository layer  
- Enable data persistence  

---

## ✅ UC13 – Service Layer  
**Branch:** feature/UC13-ServiceLayer  

### Description  
Introduces service layer for business logic.

### Functional Scope
- Separate controller & business logic  
- Handle compare, add, convert  
- Improve architecture  

---

## ✅ UC14 – DTO Layer  
**Branch:** feature/UC14-DTOLayer  

### Description  
Adds DTOs for API communication.

### Functional Scope
- Encapsulate request/response  
- Decouple internal model  
- Improve API design  

---

## ✅ UC15 – Operation History & Queries  
**Branch:** feature/UC15-OperationHistory  

### Description  
Adds tracking and querying of operations.

### Functional Scope
- Store operation history  
- Query by:
  - Operation type  
  - Measurement type  
- Count operations  

---

## ✅ UC16 – Validation & Advanced Features  
**Branch:** feature/UC16-ValidationAndEnhancements  

### Description  
Improves robustness with validation and error handling.

### Functional Scope
- Input validation  
- Better error messages  
- Prepare for production  

---

## ✅ UC17 – Spring Boot REST API + Testing + Documentation  
**Branch:** feature/UC17-SpringBootIntegration  

### Description  
Transforms the application into a full Spring Boot REST system.

### Functional Scope
- REST APIs using `@RestController`  
- Swagger/OpenAPI documentation  
- Global exception handling (`@ControllerAdvice`)  
- Security configuration (basic)  
- H2 (dev) + MySQL (prod) setup  
- Unit testing (MockMvc)  
- Integration testing  
- Actuator monitoring  
- Maven build & reports  

---

## 🚀 Final Outcome
- Fully functional **Enterprise-grade REST API**
- Supports:
  - Compare, Add, Convert  
  - Multiple measurement types  
  - Operation history  
  - Error handling  
- Built with:
  - Clean architecture (Controller → Service → Repository)  
  - Spring Boot ecosystem  
  - Testing + Documentation + Monitoring  

---
