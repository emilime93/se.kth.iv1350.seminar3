package se.kth.iv1350.model;

/**
 * Created by Emil on 2017-04-27.
 */
public class Inspection {

    private int inspectionCost;
    private String inspectionDescription;

    /**
     * This constructor creates a new instance of an Inspection.
     * @param inspectionDescription The description of the inspection
     * @param inspectionCost The cost of the inspection
     */
    public Inspection(String inspectionDescription, int inspectionCost) {
        this.inspectionCost = inspectionCost;
        this.inspectionDescription = inspectionDescription;
    }

    @Override
    public boolean equals(Object object) {
        if(!(object instanceof Inspection))
            return false;
        Inspection inspToCompare = (Inspection) object;
        if(inspToCompare.getInspectionCost() == this.inspectionCost
                && inspToCompare.getInspectionDescription().equalsIgnoreCase(this.inspectionDescription))
            return true;
        return false;
    }


    public int getInspectionCost() {
        return inspectionCost;
    }

    public String getInspectionDescription() {
        return inspectionDescription;
    }
}
