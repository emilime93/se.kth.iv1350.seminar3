package se.kth.iv1350.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.dto.VehicleDTO;
import se.kth.iv1350.integration.CarDataBaseHandler;
import se.kth.iv1350.model.Garage;
import se.kth.iv1350.model.Inspection;
import se.kth.iv1350.model.InspectionHandler;

import static org.junit.Assert.*;

/**
 * Created by Emil on 2017-05-03.
 */
public class ControllerTest {

    Controller controller;

    @Before
    public void setUp() throws Exception {
        Garage garage = new Garage();
        CarDataBaseHandler carDataBaseHandler = new CarDataBaseHandler();
        InspectionHandler inspectionHandler = new InspectionHandler(carDataBaseHandler);
        this.controller = new Controller(garage, inspectionHandler);
        this.controller.enterRegNumber("abc 123"); //here the database is fetched
    }

    @After
    public void tearDown() throws Exception {
        controller = null;
    }

    @Test
    public void testNextInspectionIsntNull() throws Exception {
        Inspection calculated = controller.nextInspection();
        assertNotNull(calculated);
    }

}