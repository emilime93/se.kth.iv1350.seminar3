package se.kth.iv1350.view;

import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.dto.CreditCardDTO;
import se.kth.iv1350.model.IllegalLicenseNumberException;
import se.kth.iv1350.model.IllegalLicenseNumberFormatException;
import se.kth.iv1350.model.Inspection;

import java.util.Date;


/**
 * Created by Emil on 2017-04-27.
 */
public class View {

    private Controller controller;

    /**
     * Creates a view with a controller
     * @param controller The controller to be used
     */
    public View(Controller controller) {
        this.controller = controller;
        doHardcodedShit();
    }

    /**
     * Hardcoded input from view to make a Card Payment
     */
    private void doHardcodedShit() {
        controller.nextCustomer();
        controller.closeDoor();
        double price = 0;
        try {
            price = controller.enterRegNumber("abc 123");
        } catch (IllegalLicenseNumberException illegalLicenseNumber) {
            System.out.println();
        } catch (IllegalLicenseNumberFormatException illegalFormat) {

        } catch (Exception e) {

        }

        System.out.println();

        Inspection inspection;
        while ((inspection = controller.nextInspection()) != null) {
            System.out.println("Next inspection:\n" + inspection);
            inspection.setPassed(true);
            System.out.println("->Set passed: " + inspection.isPassed() + "\n");
            try {
                controller.enterInspectionResult(inspection);
            } catch (IllegalLicenseNumberException e) {
                e.printStackTrace();
            } catch (IllegalLicenseNumberFormatException e) {
                e.printStackTrace();
            }
        }

        System.out.println();

        System.out.println("---Updated database after inspections:");
        while ((inspection = controller.nextInspection()) != null) {
            System.out.println(inspection + "\n");
        }

        CreditCardDTO creditCard = new CreditCardDTO("Memi Hiho Bant", "1337 420", "666", new Date());
        controller.makeCardPayment(price, creditCard);

        controller.openDoor();
        controller.closeDoor();

    }

    /**
     * Hardcoded input from view to do a Cash Payment
     */
    private void doHardcodedCashShit() {
        controller.nextCustomer();
        controller.closeDoor();
        double price = 0;
        try {
            price = controller.enterRegNumber("abc 123");
        } catch (IllegalLicenseNumberFormatException e) {
            e.printStackTrace();
        } catch (IllegalLicenseNumberException e) {
            e.printStackTrace();
        }

        System.out.println();

        Inspection inspection;
        while ((inspection = controller.nextInspection()) != null) {
            System.out.println("Next inspection:\n" + inspection);
            inspection.setPassed(true);
            System.out.println("->Set passed: " + inspection.isPassed() + "\n");
            try {
                controller.enterInspectionResult(inspection);
            } catch (IllegalLicenseNumberException e) {
                e.printStackTrace();
            } catch (IllegalLicenseNumberFormatException e) {
                e.printStackTrace();
            }
        }

        System.out.println();

        System.out.println("---Updated database after inspections:");
        while ((inspection = controller.nextInspection()) != null) {
            System.out.println(inspection + "\n");
        }

        controller.makeCashPayment(100, price);

        controller.openDoor();
        controller.closeDoor();
    }
}
