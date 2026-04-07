package com.app.quantitymeasurement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuantityMeasurementDTO {

    private Double thisValue;
    private String thisUnit;
    private String thisMeasurementType;

    private Double thatValue;
    private String thatUnit;
    private String thatMeasurementType;

    private String operation;

    private String resultString;
    private Double resultValue;
    private String resultUnit;
    private String resultMeasurementType;

    private String errorMessage;
    private boolean error;
}