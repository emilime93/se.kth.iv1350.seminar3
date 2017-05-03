package se.kth.iv1350.integration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.dto.VehicleDTO;
import se.kth.iv1350.model.Inspection;

import static org.junit.Assert.*;

/**
 * Created by Emil on 2017-05-02.
 */
public class CarDataBaseHandlerTest {

    private CarDataBaseHandler carDataBaseHandler;

    @Before
    public void setUp() throws Exception {
        carDataBaseHandler = new CarDataBaseHandler();
    }

    @After
    public void tearDown() throws Exception {
        carDataBaseHandler = null;
    }

    @Test
    public void testSaveInspectionResult() throws Exception {
        String regNo = "abc 123";
        VehicleDTO dummyVehicle = new VehicleDTO(regNo);
        Inspection inspectionToSave = new Inspection("Brakes", 30, dummyVehicle);
        inspectionToSave.setPassed(true);
        carDataBaseHandler.saveInspectionResult(inspectionToSave);
        Inspection[] fetchedInspections = carDataBaseHandler.getInspectionsByVehicle(dummyVehicle);
        boolean expected = true;
        boolean calculated = fetchedInspections[0].isPassed();
        assertEquals("The saved inspection result isn't properly saved", expected, calculated);
    }

    @Test
    public void testFailSaveInspectionResult() {
        String regNo = "abc 123";
        VehicleDTO dummyVehicle = new VehicleDTO(regNo);
        Inspection inspectionToSave = new Inspection("engine", 40, dummyVehicle);
        inspectionToSave.setPassed(true);
        carDataBaseHandler.saveInspectionResult(inspectionToSave);
        Inspection[] fetchedInspections = carDataBaseHandler.getInspectionsByVehicle(dummyVehicle);
        boolean expected = false;
        boolean calculated = fetchedInspections[0].isPassed();
        assertEquals("An non-existing inspection wrongfully managed to be saved as a result in the database",
                expected, calculated);
    }

}