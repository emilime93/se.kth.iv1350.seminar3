package se.kth.iv1350.model;

/**
 * An exception for when the entered license number isn't found by the system for some reason.
 */

public class IllegalLicenseNumberException extends Exception {

    public IllegalLicenseNumberException(String message) {
        super(message);
    }

}
