package se.kth.iv1350.controller;

import se.kth.iv1350.dto.CreditCardDTO;
import se.kth.iv1350.dto.VehicleDTO;
import se.kth.iv1350.integration.CarDataBaseHandler;
import se.kth.iv1350.model.*;
import se.kth.iv1350.view.InspectionsStatsView;

import java.io.IOException;

/**
 * The controller, responsible for communication from view to model layer.
 */
public class Controller {

    private Garage garage;
    private InspectionHandler inspectionHandler;
    private LogHandler logHandler;

    /**
     * Creates a Controller between the View and the Models
     * @param garage The garage to use
     * @param inspectionHandler The inspection handler to use
     */
    public Controller(Garage garage, InspectionHandler inspectionHandler) {
        this.garage = garage;
        this.inspectionHandler = inspectionHandler;

        try {
            this.logHandler = new LogHandler();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Opens the garage door and updates the display queue number
     */
    public void nextCustomer() {
        garage.nextCustomer();
    }

    /**
     * Closes the garage door
     */
    public void closeDoor() {
        garage.closeDoor();
    }

    /**
     * Opens the garage door
     */
    public void openDoor() {
        garage.openDoor();
    }

    /**
     * This method looks up the inspections for the specified vehicle and calculates the cost of the
     * @param regNo The registration number to check for inspections.
     * @return The price for the inspection.
     * @throws IllegalLicenseNumberFormatException If the specified vehicle has a wrongfully formatted registration
     * number, this exception is thrown.
     * @throws IllegalLicenseNumberException If there's no inspections to be made for the specified vehicle
     * this exception is thrown.
     */
    public double enterRegNumber(String regNo) throws IllegalLicenseNumberFormatException,
            IllegalLicenseNumberException {
        return inspectionHandler.enterRegNumber(regNo);
    }

    /**
     * Makes a card payment, you must have used the card constructor of Payment to use this.
     * @param cost The cost of the payment
     * @param creditCard The credit card to pay with
     * @return True if the payment is authorized, false otherwise
     */
    public boolean makeCardPayment(double cost, CreditCardDTO creditCard) {
        Payment payment = new Payment(cost, creditCard);
        boolean authorized = payment.makeCardPayment();
        payment.printReceipt();
        return authorized;
    }

    /**
     * Makes a cash payment, you must have used the cash constructor of Payment to use this.
     * @param amountPaid The cash amount paid to the cashier
     * @param cost The cost of the payment
     * @return The change amount
     */
    public double makeCashPayment(double amountPaid, double cost) {
        Payment payment = new Payment(amountPaid, cost);
        double change = payment.makeCashPayment();
        payment.printReceipt();
        return change;
    }

    /**
     * Gives the next inspection to perform
     * @return The next inspection in the list
     */
    public Inspection nextInspection() {
        return inspectionHandler.getNextInspection();
    }

    /**
     * Saves the inspection result from an edited inspection
     * @param inspection The edited inspection to save to the original
     */
    public void enterInspectionResult(Inspection inspection) {
        inspectionHandler.saveInspectionResult(inspection);
    }

    /**
     * Logs the exception with the current logging method.
     * @param logDetails The exception to be logged.
     */
    public void logException(Throwable logDetails) {
        logHandler.logException(logDetails);
    }

    public void setInspectionResultsObserver(InspectionsStatsView inspectionsStatsView) {
        inspectionHandler.setInspectionResultsObserver(inspectionsStatsView);
    }
}
