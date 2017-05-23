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
        String licenseNumber = "abc 124";

        try {
            price = controller.enterRegNumber(licenseNumber);
        } catch (IllegalLicenseNumberException illegalLicenseNumber) {
            System.out.println("Error: This license number does not have any inspections associated with it.");
            controller.logException(illegalLicenseNumber);
        } catch (IllegalLicenseNumberFormatException illegalFormat) {
            controller.logException(illegalFormat);
            System.out.println("Error: Wrong licence number format. \n" + illegalFormat.getMessage());
            controller.logException(illegalFormat);
        } catch (Exception e) {
            controller.logException(e);
            System.out.println("Error: Unknown error. Try again or contact your IT guy.");
        }

        System.out.println();

        Inspection inspection;

        while ((inspection = controller.nextInspection()) != null) {
            System.out.println("Next inspection:\n" + inspection);
            inspection.setPassed(true);
            System.out.println("->Set passed: " + inspection.isPassed() + "\n");
            controller.enterInspectionResult(inspection);
        }


        System.out.println();

        while ((inspection = controller.nextInspection()) != null) {
            System.out.println("Updated inspection:\n" + inspection + "\n");
        }

        if (price < 0) {
            CreditCardDTO creditCard = new CreditCardDTO("Memi Hiho Bant", "1337 420", "666", new Date());
            controller.makeCardPayment(price, creditCard);
        }

        controller.openDoor();
        controller.closeDoor();

    }

    /**
     * Hardcoded input from view to do a Cash Payment
     */
    /**
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
            controller.enterInspectionResult(inspection);
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
     */
}
