package se.kth.iv1350.startup;

import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.integration.CarDataBaseHandler;
import se.kth.iv1350.model.Garage;
import se.kth.iv1350.model.InspectionHandler;
import se.kth.iv1350.view.InspectionsStatsView;
import se.kth.iv1350.view.View;

public class Main {

    public static void main(String[] args) {
        Garage garage = new Garage();
        CarDataBaseHandler carDataBaseHandler = new CarDataBaseHandler();
        InspectionHandler inspectionHandler = new InspectionHandler(carDataBaseHandler);
        Controller controller = new Controller(garage, inspectionHandler);
        new InspectionsStatsView(controller);
        new View(controller);
    }
}
