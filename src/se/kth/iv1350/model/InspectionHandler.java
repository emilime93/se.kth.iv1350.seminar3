package se.kth.iv1350.model;

import se.kth.iv1350.integration.CarDataBaseHandler;

/**
 * Created by Emil on 2017-04-27.
 */
public class InspectionHandler {

    private InspectionList inspectionList;
    private CarDataBaseHandler carDataBaseHandler;

    public InspectionHandler(InspectionList inspectionList, CarDataBaseHandler carDataBaseHandler) {
        this.inspectionList = inspectionList;
        this.carDataBaseHandler = carDataBaseHandler;
    }

    public int calculateCost() {
        int accumulatedCost = 0;
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
     * @param inspectionToSave The inspection to save
     */
    public void saveInspectionResult(Inspection inspectionToSave) {
        carDataBaseHandler.saveInspectionResult(inspectionToSave);
    }

    public void setInspectionList(Inspection[] inspectionList) {
        this.inspectionList.setInspections(inspectionList);
    }


}
