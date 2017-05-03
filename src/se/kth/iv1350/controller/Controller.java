package se.kth.iv1350.controller;

import se.kth.iv1350.dto.CreditCardDTO;
import se.kth.iv1350.dto.VehicleDTO;
import se.kth.iv1350.integration.CarDataBaseHandler;
import se.kth.iv1350.model.*;

/**
 * Created by Emil on 2017-04-27.
 */
public class Controller {

    private Garage garage;
    private CarDataBaseHandler carDataBaseHandler;
    private InspectionHandler inspectionHandler;

    public Controller(Garage garage, CarDataBaseHandler carDataBaseHandler, InspectionHandler inspectionHandler) {
        this.garage = garage;
        this.carDataBaseHandler = carDataBaseHandler;
        this.inspectionHandler = inspectionHandler;
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
     * Fetches the inspections for a specified vehicle and calculates the cost
     * @param regNo The registration number for the vehicle
     * @return The cost for all the inspections of the vehicle
     */
    public double enterRegNumber(String regNo) {
        VehicleDTO vehicle = new VehicleDTO(regNo);
        Inspection[] inspections = carDataBaseHandler.getInspectionsByVehicle(vehicle);
        inspectionHandler.setInspectionList(inspections);
        return inspectionHandler.calculateCost();
    }

    public boolean makeCardPayment(double cost, CreditCardDTO creditCard) {
        Payment payment = new Payment(cost, creditCard);
        boolean authorized = payment.makeCardPayment();
        payment.printReceipt();
        return authorized;
    }

    public double makeCashPayment(double amountPaid, double cost) {
        Payment payment = new Payment(amountPaid, cost);
        double change = payment.makeCashPayment();
        payment.printReceipt();
        return change;
    }

    public Inspection nextInspection() {
        return inspectionHandler.getNextInspection();
        //TODO null handling of Inspection
    }

    public void enterInspectionResult(Inspection inspection) {
        inspectionHandler.saveInspectionResult(inspection);
    }

}
