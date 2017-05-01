package se.kth.iv1350.model;

/**
 * Created by Emil on 2017-05-01.
 */
public class Display {

    private int currentNumber;

    /**
     * Creates an Display instance and sets the current number to 0
     */
    public Display() {
        this.currentNumber = 0;
    }

    /**
     * Increments the current number and displays it on the display
     */
    void displayNextNumber() {
        this.currentNumber++;
        display();
    }

    private void display() {
        System.out.println("Display: Updating display number: " + this.currentNumber);
    }
}
