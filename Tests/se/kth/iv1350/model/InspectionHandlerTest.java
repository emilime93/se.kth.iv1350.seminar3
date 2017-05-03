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

    private Inspection[] inspections;
    private InspectionList inspectionList;
    private InspectionHandler inspectionHandler;

    @Before
    public void setUp() throws Exception {
        String dummyRegNo = "abc 123";
        VehicleDTO dummyVehicle = new VehicleDTO(dummyRegNo);
        inspections = new Inspection[] {
                new Inspection("brakes", 30, dummyVehicle),
                new Inspection("engine", 50, dummyVehicle),
                new Inspection("wheels", 10, dummyVehicle)
        };
        inspectionHandler = new InspectionHandler(new CarDataBaseHandler());
        inspectionHandler.setInspectionList(inspections);
    }

    @After
    public void tearDown() throws Exception {
        inspections = null;
        inspectionList = null;
        inspectionHandler = null;
    }

    @Test
    public void testCalculateCostCorrect() throws Exception {
        double expectedDouble = 30 + 50 + 10;
        double calculatedDouble = inspectionHandler.calculateCost();
        boolean expected = true;
        boolean calculated = false;
        if(expectedDouble == calculatedDouble) {
            calculated = true;
        }
        assertEquals("Same costs are not equal", expected, calculated);
    }

    @Test
    public void testGetNextInspectionIsntNull() throws Exception {
        Inspection i = inspectionHandler.getNextInspection();
        assertNotNull(i);
    }

    @Test
    public void hasNext() throws Exception {
        boolean expected = true;
        boolean calculated = inspectionHandler.hasNext();
        assertEquals("Something is wrong", expected, calculated);
    }

    @Test
    public void saveInspectionResult() throws Exception {
        Inspection passedBrakesInspection = new Inspection("brakes", 30, new VehicleDTO("abc 123"));
        passedBrakesInspection.setPassed(true);
        inspectionHandler.saveInspectionResult(passedBrakesInspection);
        boolean passed =  inspectionHandler.getNextInspection().isPassed();
        boolean expected = true;
        assertEquals("The supposedly passed inspection wasn't passed", passed, expected);
    }

}