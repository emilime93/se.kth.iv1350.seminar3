package se.kth.iv1350.view;

import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.dto.CreditCardDTO;
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
        doHardcodedCashShit();
    }

    /**
     * Hardcoded input from view to make a Card Payment
     */
    private void doHardcodedShit() {
        controller.nextCustomer();
        controller.closeDoor();
        double price = controller.enterRegNumber("abc 123");
        CreditCardDTO creditCard = new CreditCardDTO("Memi Hihhi Bant", "1337 420", "666", new Date());
        controller.makeCardPayment(price, creditCard);

        Inspection inspection1 = controller.nextInspection();
        inspection1.setPassed(true);
        controller.enterInspectionResult(inspection1);

        Inspection inspection2 = controller.nextInspection();
        inspection2.setPassed(true);
        controller.enterInspectionResult(inspection2);

        Inspection inspection3 = controller.nextInspection();
        inspection3.setPassed(true);
        controller.enterInspectionResult(inspection3);
    }

    /**
     * Hardcoded input from view to do a Cash Payment
     */
    private void doHardcodedCashShit() {
        controller.nextCustomer();
        controller.closeDoor();
        double price = controller.enterRegNumber("abc 123");
        controller.makeCashPayment(100, price);

        Inspection inspection1 = controller.nextInspection();
        inspection1.setPassed(true);
        controller.enterInspectionResult(inspection1);

        Inspection inspection2 = controller.nextInspection();
        inspection2.setPassed(true);
        controller.enterInspectionResult(inspection2);

        Inspection inspection3 = controller.nextInspection();
        inspection3.setPassed(true);
        controller.enterInspectionResult(inspection3);
    }
}
