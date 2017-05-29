package se.kth.iv1350.model;

/**
 * Created by Emil on 2017-05-01.
 */
public class InspectionList {

    private Inspection[] inspections;

    private int currentIndex;
    private int numberOfInspections;

    /**
     * Sets the list of inspection to use and initializes the iterator
     * @param inspections The inspection list to use
     */
    public void setInspections(Inspection[] inspections) {
        this.inspections = inspections;
        this.numberOfInspections = inspections.length;
        this.currentIndex = 0;
    }

    /**
     * Sets/updates the inspection list without resetting it
     * @param inspections The updated list. Must be the same as the last one, but modified.
     */
    public void updateCurrentList(Inspection[] inspections) {
        this.inspections = inspections;
    }

    /**
     * Tests if there are more inspections in the list.
     * @return True if there are more inspections in the list. False otherwise
     */
    public boolean hasNext() {
        return currentIndex < numberOfInspections;
    }

    /**
     * Returns the next inspection in the list. Returns null if there are no Inspections
     * @return The next inspection in order.
     */
    public Inspection getNextInspection() {
        try {
            return this.inspections[this.currentIndex++];
        } catch (Exception e) {
            resetIterator();
            return null;
        }
    }

    /**
     * Returns the inspection list in an primitive array format.
     * @return The array of inspections
     */
    Inspection[] getInspectionsArray() {
        Inspection[] inspections = new Inspection[numberOfInspections];
        for (int i = 0; i < inspections.length; i++) {
            inspections[i] = this.inspections[i];
        }
        return inspections;
    }

    /**
     * Resets the iterator so that it will begin checking <code>hasNext()</code> and <code>getNextInspection()</code>
     * from the beginning of the list again.
     */
    public void resetIterator() {
        currentIndex = 0;
    }
}
