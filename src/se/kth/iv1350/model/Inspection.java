package se.kth.iv1350.model;

import se.kth.iv1350.dto.VehicleDTO;

/**
 * Created by Emil on 2017-04-27.
 */
public class Inspection {

    private VehicleDTO vehicle;
    private int inspectionCost;
    private String inspectionDescription;
    private boolean passed;

    /**
     * This constructor creates a new instance of an Inspection.
     * @param inspectionDescription The description of the inspection
     * @param inspectionCost The cost of the inspection
     */
    public Inspection(String inspectionDescription, int inspectionCost, VehicleDTO vehicle) {
        this.vehicle = vehicle;
        this.inspectionCost = inspectionCost;
        this.inspectionDescription = inspectionDescription;
        this.passed = false;
    }

    @Override
    public boolean equals(Object object) {
        if(!(object instanceof Inspection))
            return false;
        Inspection inspToCompare = (Inspection) object;
        if(inspToCompare.getInspectionCost() == this.inspectionCost) {
            if (inspToCompare.getInspectionDescription().equalsIgnoreCase(this.inspectionDescription)) {
                if (inspToCompare.getVehicle().equals(this.vehicle))
                    return true;
            }
        }
        return false;
    }

    public VehicleDTO getVehicle() {
        return vehicle;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public int getInspectionCost() {
        return inspectionCost;
    }

    public String getInspectionDescription() {
        return inspectionDescription;
    }
}
