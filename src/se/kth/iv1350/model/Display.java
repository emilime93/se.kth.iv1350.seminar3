package se.kth.iv1350.model;

/**
 * Created by Emil on 2017-05-01.
 */
public class Display {

    private int currentNumber;

    /**
     * Creates an Display instance and sets the current number to 0
     */
    Display() {
        this.currentNumber = 0;
    }

    /**
     * Increments the current number and displays it on the display
     */
    void displayNextNumber() {
        this.currentNumber++;
        display();
    }

    /**
     * Displays the current number on the display. In our dummy implementation this only prints
     * the status to the out stream
     */
    private void display() {
        System.out.println("Display: Updating display number: " + this.currentNumber);
    }
}
