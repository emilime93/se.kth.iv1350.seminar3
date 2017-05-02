package se.kth.iv1350.integration;

import se.kth.iv1350.dto.VehicleDTO;
import se.kth.iv1350.model.Inspection;

/**
 * Created by Emil on 2017-05-01.
 */
public class CarDataBaseHandler {

    private Inspection[] dataBaseInspections;

    /**
     * Creates a fake database full of dummy inspections.
     * In reality this should establish a connection a real database
     */
    public CarDataBaseHandler() {
        String dummyRegNr = "ABC 123";
        VehicleDTO dummyVehicle = new VehicleDTO(dummyRegNr);
        dataBaseInspections = new Inspection[] {
            new Inspection("Brakes", 30, dummyVehicle),
            new Inspection("Engine", 50, dummyVehicle),
            new Inspection("Lights", 10, dummyVehicle)
        };
    }

    /**
     * In this version this function returns the dummy inspections from the dummy database.
     * @param vehicle The vehicle to search inspections by
     * @return Dummy inspection list
     */
    public Inspection[] getInspectionsByVehicle(VehicleDTO vehicle) {
        //Returns the dummy inspection, in reality this should search by car.
        return dataBaseInspections;
    }

    /**
     * Saves the inspection (result) in the database
     * @param inspectionToSetResultFor The inspection to save
     */
    public void saveInspectionResult(Inspection inspectionToSetResultFor) {
        for (int i = 0; i < dataBaseInspections.length; i++) {
            if (dataBaseInspections[i].equals(inspectionToSetResultFor)) {
                dataBaseInspections[i].setPassed(
                        inspectionToSetResultFor.isPassed()
                );
            }
        }

    }
}
