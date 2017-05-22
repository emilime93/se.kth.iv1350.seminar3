package se.kth.iv1350.model;

import se.kth.iv1350.dto.VehicleDTO;
import se.kth.iv1350.integration.CarDataBaseHandler;

/**
 * Created by Emil on 2017-04-27.
 */
public class InspectionHandler {

    private InspectionList inspectionList;
    private CarDataBaseHandler carDataBaseHandler;

    /**
     * Creates an inspection handler. Responsible for handeling the list with inspections and the different actions
     * related to the inspections.
     * @param carDataBaseHandler The car data base handler to use to fetch and save results from
     */
    public InspectionHandler(CarDataBaseHandler carDataBaseHandler) {
        this.inspectionList = new InspectionList();
        this.carDataBaseHandler = carDataBaseHandler;
    }

    /**
     * Calculates the total cost for all inspections for the vehicle, and resets the iterator.
     * @return The total cost of the inspections
     */
    public double calculateCost() {
        double accumulatedCost = 0;
        inspectionList.resetIterator();
        while (inspectionList.hasNext()) {
            accumulatedCost += inspectionList.getNextInspection().getInspectionCost();
        }
        inspectionList.resetIterator();
        System.out.println("InspectionHandler: Calculated cost is: " + accumulatedCost);
        return accumulatedCost;
    }

    /**
     * Fetches the inspections for a specified vehicle and calculates the cost
     * @param regNo The registration number for the vehicle
     * @return The cost for all the inspections of the vehicle
     */
    public double enterRegNumber(String regNo) throws IllegalLicenseNumberFormatException,
            IllegalLicenseNumberException {
        VehicleDTO vehicle = new VehicleDTO(regNo);
        Inspection[] inspections = this.carDataBaseHandler.getInspectionsByVehicle(vehicle);
        setInspectionList(inspections);
        double cost = calculateCost();
        return cost;
    }

    /**
     * Returns the next inspection, null if there ain't no inspection.
     * @return The next inspection.
     */
    public Inspection getNextInspection() {
        return inspectionList.getNextInspection();
    }


    /**
     * Checks if there are more inspections in the list
     * @return Returns true if there are more inspections to be made, false otherwise.
     */
    public boolean hasNext() {
        return inspectionList.hasNext();
    }

    /**
     * Saves the inspection result in the database and fetches the newly updated database to the local list
     * @param inspectionToSave The inspection, with correct result, to save
     */
    public void saveInspectionResult(Inspection inspectionToSave) throws IllegalLicenseNumberException,
            IllegalLicenseNumberFormatException {
        carDataBaseHandler.saveInspectionResult(inspectionToSave);
        VehicleDTO dummyVehicle = new VehicleDTO("ABC 123");
        inspectionList.updateCurrentList(carDataBaseHandler.getInspectionsByVehicle(dummyVehicle));
    }

    /**
     * Sets the inspection list to use
     * @param inspectionList The list of inspections to use
     */
    public void setInspectionList(Inspection[] inspectionList) {
        this.inspectionList.setInspections(inspectionList);
    }
}
