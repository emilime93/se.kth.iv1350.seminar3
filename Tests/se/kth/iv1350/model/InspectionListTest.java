package se.kth.iv1350.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.dto.VehicleDTO;

import static org.junit.Assert.*;

/**
 * Created by Emil on 2017-05-01.
 */
public class InspectionListTest {

    InspectionList instance;

    @Before
    public void setUp() throws Exception {
        VehicleDTO dummyVehicle = new VehicleDTO("abc 123");
        Inspection[] inspections = new Inspection[] {
                new Inspection("brakes", 30, dummyVehicle),
                new Inspection("engine", 50, dummyVehicle),
                new Inspection("wheels", 10, dummyVehicle)
        };
        instance = new InspectionList(inspections);
    }

    @After
    public void tearDown() throws Exception {
        instance = null;
    }

    @Test
    public void testHasNext() throws Exception {
        boolean expected = true;
        boolean calculatedAnswer = instance.hasNext();
        assertEquals("The list did not return TRUE on hasNext() when supposed to", expected, calculatedAnswer);
    }

    @Test
    public void testHasntNext() throws Exception {
        while (instance.hasNext()) {
            instance.getNextInspection();
        }
        boolean expected = false;
        boolean calculated = instance.hasNext();
        assertEquals("hasNext() falsley returned true", expected, calculated);
    }

}