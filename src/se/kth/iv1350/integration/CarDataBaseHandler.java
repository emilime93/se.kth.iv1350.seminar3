package se.kth.iv1350.integration;

import se.kth.iv1350.dto.VehicleDTO;
import se.kth.iv1350.model.IllegalLicenseNumberException;
import se.kth.iv1350.model.IllegalLicenseNumberFormatException;
import se.kth.iv1350.model.Inspection;

/**
 * This class handles the calls to the vehicle registration number database
 */
public class CarDataBaseHandler {

    private Inspection[] dataBaseInspections;

    // License numbers that has inspections.
    private final static String[] LEGAL_LICENSE_NUMBERS = {"ABC 123", "XYZ 789", "AAA 111"};

    /**
     * Creates a fake database full of dummy inspections.
     * In reality this should establish a connection a real database
     */
    public CarDataBaseHandler() {
        String dummyRegNr = "abc 123";
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
     * @return The dummy inspection list
     * @throws IllegalLicenseNumberException If there's no inspection for the specified vehicle,
     * this exception is thrown.
     * @throws IllegalLicenseNumberFormatException If the registration number format if wrong, this exception is thrown.
     */
    public Inspection[] getInspectionsByVehicle(VehicleDTO vehicle) throws IllegalLicenseNumberException,
            IllegalLicenseNumberFormatException {
        //Returns the dummy inspection, in reality this should search by car.

        if(vehicle.getRegistrationNumber().length() != 7) {
            throw new IllegalLicenseNumberFormatException("Wrong licence number format." +
                    " The format should be \"CCC NNN\"");
        }

        for (int i = 0; i < LEGAL_LICENSE_NUMBERS.length; i++) {
            if (LEGAL_LICENSE_NUMBERS[i].equalsIgnoreCase(vehicle.getRegistrationNumber())) {
                return this.dataBaseInspections;
            }
        }
        throw new IllegalLicenseNumberException("The entered licence number has no inspections associated with it.");
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
