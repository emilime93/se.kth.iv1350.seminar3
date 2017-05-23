package se.kth.iv1350.integration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.dto.VehicleDTO;
import se.kth.iv1350.model.IllegalLicenseNumberException;
import se.kth.iv1350.model.IllegalLicenseNumberFormatException;
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
    public void testGetInspectionsByVehicle() {
        Inspection[] inspections = new Inspection[0];
        try {
            VehicleDTO vehicle = new VehicleDTO("ABC 123");
            inspections = carDataBaseHandler.getInspectionsByVehicle(vehicle);
        } catch (IllegalLicenseNumberException e) {
            e.printStackTrace();
        } catch (IllegalLicenseNumberFormatException e) {
            e.printStackTrace();
        }

        boolean expected = true;
        boolean calculated = inspections[0].equals(new Inspection("Brakes", 30, new VehicleDTO("abc 123")));
        assertEquals("#1 Two supposedly identical Inspections isnt equal", expected, calculated);

        expected = true;
        calculated = inspections[1].equals(new Inspection("engine", 50, new VehicleDTO("abc 123")));
        assertEquals("#2 Two supposedly identical Inspections isnt equal", expected, calculated);

        expected = true;
        calculated = inspections[2].equals(new Inspection("lights", 10, new VehicleDTO("abc 123")));
        assertEquals("#3 Two supposedly identical Inspections isnt equal", expected, calculated);

        assertEquals("Wrong array length", 3, inspections.length);
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
        Inspection[] fetchedInspections = new Inspection[0];
        try {
            fetchedInspections = carDataBaseHandler.getInspectionsByVehicle(dummyVehicle);
        } catch (IllegalLicenseNumberException e) {
            e.printStackTrace();
        } catch (IllegalLicenseNumberFormatException e) {
            e.printStackTrace();
        }
        boolean expected = false;
        boolean calculated = fetchedInspections[0].isPassed();
        assertEquals("An non-existing inspection wrongfully managed to be saved as a result in the database",
                expected, calculated);
    }

}