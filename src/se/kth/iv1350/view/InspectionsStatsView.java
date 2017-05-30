package se.kth.iv1350.view;

import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.model.InspectionResultObserver;

/**
 * A view responsible for tracking passed and failed inspections. And printing the corresponding stats.
 */
public class InspectionsStatsView implements InspectionResultObserver {

    private final Controller controller;
    private int noOfPassedInspections = 0;
    private int noOfFailedInspections = 0;

    public InspectionsStatsView(Controller controller) {
        this.controller = controller;
        this.controller.setInspectionResultsObserver(this);
    }

    /**
     * Updates the status of the number of passed and failed inspections, and prints the result.
     * @param inspectionIsPassed Whenever the new inspection result was passed or not.
     */
    @Override
    public void newInspectionResult(boolean inspectionIsPassed) {
        if (inspectionIsPassed) {
            noOfPassedInspections++;
        } else {
            noOfFailedInspections++;
        }
        printStats();
    }

    /**
     * Prints the total amount of passed and failed inspections.
     */
    private void printStats() {
        System.out.printf("STATS:\nNumber of passed inspections: %d\nNumber of failed inspections: %d\n\n",noOfPassedInspections
        , noOfFailedInspections);
    }
}
