package se.kth.iv1350.model;

/**
 * An interface for the observer pattern that tells a view when a inspection has been done.
 */
public interface InspectionResultObserver {

    /**
     * This method reports that a new inspection result has been saved.
     * @param inspectionIsPassed Whether the inspection in question passed or not.
     */
    void newInspectionResult(boolean inspectionIsPassed);
}
