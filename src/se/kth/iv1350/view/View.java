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

    public View(Controller controller) {
        this.controller = controller;
        doHardcodedShit();
    }

    private void doHardcodedShit() {
        controller.nextCustomer();
        controller.closeDoor();
        controller.enterRegNumber("abc 123");
        CreditCardDTO creditCard = new CreditCardDTO("Memi Hihhi Bant", "1337 420", "666", new Date());
        controller.makeCardPayment(100, creditCard);

        Inspection inspection1 = controller.nextInspection();
        if (inspection1 == null)
            System.out.println("NULL in View");
        inspection1.setPassed(true);
        controller.enterInspectionResult(inspection1);

        Inspection inspection2 = controller.nextInspection();
        inspection2.setPassed(true);
        controller.enterInspectionResult(inspection2);

        Inspection inspection3 = controller.nextInspection();
        inspection3.setPassed(true);
        controller.enterInspectionResult(inspection3);
    }
    //TODO Hardcode the inputs from the view
}
