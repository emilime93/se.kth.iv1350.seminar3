package se.kth.iv1350.model;

/**
 * An exception for when the user enters a license number using the wrong formatt
 */
public class IllegalLicenseNumberFormatException extends Exception {

    public IllegalLicenseNumberFormatException(String message) {
        super(message);
    }
}
