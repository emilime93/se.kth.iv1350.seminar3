package se.kth.iv1350.model;

/**
 * Created by Emil on 2017-05-01.
 */
public class InspectionList {

    private Inspection[] inspections;

    private int currentIndex;
    private int numberOfInspections;

    /**
     * Creates an list of inspections from the supplied array of Inspections
     * @param inspections The array of inspections to create the list from.
     */
    public InspectionList(Inspection[] inspections) {
        this.inspections = inspections;
        this.numberOfInspections = inspections.length;
        this.currentIndex = 0;
    }

    public void setInspections(Inspection[] inspections) {
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
            return inspections[currentIndex++];
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Resets the iterator so that it will begin checking <code>hasNext()</code> and <code>getNextInspection()</code>
     * from the beginning of the list again.
     */
    public void resetIterator() {
        currentIndex = 0;
    }
}
