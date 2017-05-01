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

    public Inspection getNextInspection() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public void saveInspectionResult() {

    }
}
