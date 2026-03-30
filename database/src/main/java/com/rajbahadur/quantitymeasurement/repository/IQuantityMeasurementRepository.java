package com.rajbahadur.quantitymeasurement.repository;

import java.util.List;

import com.rajbahadur.quantitymeasurement.entity.QuantityMeasurementEntity;

public interface IQuantityMeasurementRepository {

    void save(QuantityMeasurementEntity entity);

    List<QuantityMeasurementEntity> findAll();
    
    void deleteAllMeasurements();
}
