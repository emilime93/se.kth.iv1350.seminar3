package se.kth.iv1350.model;

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
     * Calculates the total cost for all inspections for the vehicle.
     * @return The total cost of the inspections
     */
    public double calculateCost() {
        double accumulatedCost = 0;
        inspectionList.resetIterator();
        while (inspectionList.hasNext()) {
            accumulatedCost += inspectionList.getNextInspection().getInspectionCost();
        }
        return accumulatedCost;
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
     * Saves the inspection result in the database
     * @param inspectionToSave The inspection, with correct result, to save
     */
    public void saveInspectionResult(Inspection inspectionToSave) {
        carDataBaseHandler.saveInspectionResult(inspectionToSave);
    }

    public void setInspectionList(Inspection[] inspectionList) {
        this.inspectionList.setInspections(inspectionList);
    }


}
