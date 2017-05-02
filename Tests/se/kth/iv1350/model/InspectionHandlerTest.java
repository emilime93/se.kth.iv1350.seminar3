package se.kth.iv1350.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.dto.VehicleDTO;
import se.kth.iv1350.integration.CarDataBaseHandler;

import static org.junit.Assert.*;

/**
 * Created by Emil on 2017-05-01.
 */
public class InspectionHandlerTest {

    Inspection[] inspections;
    InspectionList inspectionList;
    InspectionHandler inspectionHandler;

    @Before
    public void setUp() throws Exception {
        String dummyRegNo = "abc 123";
        VehicleDTO dummyVehicle = new VehicleDTO(dummyRegNo);
        inspections = new Inspection[] {
                new Inspection("brakes", 30, dummyVehicle),
                new Inspection("engine", 50, dummyVehicle),
                new Inspection("wheels", 10, dummyVehicle)
        };
        inspectionList = new InspectionList(inspections);
        inspectionHandler = new InspectionHandler(inspectionList, new CarDataBaseHandler());
    }

    @After
    public void tearDown() throws Exception {
        inspections = null;
        inspectionList = null;
    }

    @Test
    public void calculateCost() throws Exception {
        int expected = 30 + 50 + 10;
        int calculated = inspectionHandler.calculateCost();
        assertEquals("The supposedly equal costs isnt equal", expected, calculated);
    }

    @Test
    public void getNextInspection() throws Exception {
        Inspection i = inspectionHandler.getNextInspection();
        if (i == null)
            fail("FAIL!!11!!1!11");
        if(!(i instanceof Inspection))
            fail("FAIL!!!!!!!");
    }

    @Test
    public void hasNext() throws Exception {
        boolean expected = true;
        boolean calculated = inspectionHandler.hasNext();
        assertEquals("Something is wrong", expected, calculated);
    }

    @Test
    public void saveInspectionResult() throws Exception {
        //TODO
    }

}