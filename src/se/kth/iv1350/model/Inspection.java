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

    @Override
    public String toString() {
        String description = "";
        description += "Inspection description: " + this.inspectionDescription + "\n" +
                "Cost: " + this.inspectionCost + "\n" +
                "Vehicle: " + this.vehicle.getRegistrationNumber() + "\n" +
                "Passed: " + this.passed;
        return description;
    }

    /**
     * Returns the vehicle for the inspection
     * @return The vehicle for the inspection
     */
    public VehicleDTO getVehicle() {
        return vehicle;
    }

    /**
     * Returns true if the inspection is passed, otherwise false
     * @return True if the inspection is passed, otherwise false
     */
    public boolean isPassed() {
        return passed;
    }

    /**
     * Sets the <code>passed</code> boolean status of the inspection
     * @param passed True if the inspection is passed, false if it's failed
     */
    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    /**
     * Gets the inspection cost
     * @return The cost of the inspection
     */
    public int getInspectionCost() {
        return inspectionCost;
    }

    /**
     * Returns the description of the inspection
     * @return The description of the inspection
     */
    public String getInspectionDescription() {
        return inspectionDescription;
    }
}
