package com.rajbahadur.quantitymeasurement;

import com.rajbahadur.quantitymeasurement.controller.QuantityMeasurementController;
import com.rajbahadur.quantitymeasurement.dto.QuantityDTO;
import com.rajbahadur.quantitymeasurement.repository.QuantityMeasurementDatabaseRepository;
import com.rajbahadur.quantitymeasurement.service.QuantityMeasurementServiceImpl;


public class QuantityMeasurementApp {

	public static void main(String[] args) {
                
                QuantityMeasurementDatabaseRepository repo = new QuantityMeasurementDatabaseRepository();
                QuantityMeasurementServiceImpl service = new QuantityMeasurementServiceImpl(repo);
                QuantityMeasurementController controller = new QuantityMeasurementController(service);

        QuantityDTO q1 = new QuantityDTO(20, "FEET", "LENGTH");
        QuantityDTO q2 = new QuantityDTO(15, "FEET", "LENGTH");

        controller.performAddition(q1, q2);
        controller.performAddition(q1, q2);
        controller.performSubtraction(q1, q2);
        controller.performDivision(q1, q2);
        controller.performComparison(q1, q2);
        controller.performConversion(q1, "INCHES");
//        controller.deleteAllMeasurements();
    }
}
