package se.kth.iv1350.model;

/**
 * Created by Emil on 2017-04-27.
 */
public class Garage {

    private Display display;
    private boolean doorOpen;

    /**
     * Creates a garage with a closed door and a display "connected" to it.
     */
    public Garage() {
        display = new Display();
        doorOpen = false;
    }

    /**
     * Updates display number and opens the door of the garage
     */
    public void nextCustomer() {
        display.displayNextNumber();
        openDoor();
    }

    /**
     * Opens the door of the garage
     */
    public void openDoor() {
        this.doorOpen = true;
        // Printouts for dummy implementation
        System.out.println("Garage: Door is open!");
    }

    /**
     * Closes the door of the garage
     */
    public void closeDoor() {
        this.doorOpen = false;
        // Printouts for dummy implementation
        System.out.println("Garage: Door is closed!");
    }
}
