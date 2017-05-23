package se.kth.iv1350.controller;

import se.kth.iv1350.dto.CreditCardDTO;
import se.kth.iv1350.dto.VehicleDTO;
import se.kth.iv1350.integration.CarDataBaseHandler;
import se.kth.iv1350.model.*;

import java.io.IOException;

/**
 * Created by Emil on 2017-04-27.
 */
public class Controller {

    private Garage garage;
    private CarDataBaseHandler carDataBaseHandler;
    private InspectionHandler inspectionHandler;
    private LogHandler logHandler;

    /**
     * Creates a Controller between the View and the Models
     * @param garage The garage to use
     * @param carDataBaseHandler The car database to use
     * @param inspectionHandler The inspection handler to use
     */
    public Controller(Garage garage, CarDataBaseHandler carDataBaseHandler, InspectionHandler inspectionHandler) {
        this.garage = garage;
        this.carDataBaseHandler = carDataBaseHandler;
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
        try {
            inspectionHandler.saveInspectionResult(inspection);
        } catch (IllegalLicenseNumberFormatException e) {
            logException(e);
            e.printStackTrace();
        } catch (IllegalLicenseNumberException e) {
            logException(e);
            e.printStackTrace();
        }
    }

    public void logException(Throwable logDetails) {
        logHandler.logException(logDetails);
    }
}
