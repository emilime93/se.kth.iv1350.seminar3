package se.kth.iv1350.model;

/**
 * An interface for the observer pattern that tells a view when a inspection has been done.
 */
public interface InspectionResultObserver {

    void newInspectionResult(boolean inspectionIsPassed);
}
