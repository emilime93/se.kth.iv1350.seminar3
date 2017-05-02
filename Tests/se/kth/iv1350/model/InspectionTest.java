package se.kth.iv1350.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.dto.VehicleDTO;

import static org.junit.Assert.*;

/**
 * Created by Emil on 2017-05-01.
 */
public class InspectionTest {

    Inspection instance;
    Inspection other;
    Inspection sameAsInstance;

    @Before
    public void setUp() {
        String regNo1 = "ABC 123";
        String regNo2 = "DEF 456";
        VehicleDTO vehicle1 = new VehicleDTO(regNo1);
        VehicleDTO vehicle2 = new VehicleDTO(regNo2);

        instance = new Inspection("Brakes", 30, vehicle1);
        other = new Inspection("Engine", 50, vehicle2);
        sameAsInstance = new Inspection("brakes", 30, vehicle1);
    }

    @After
    public void tearDown() {
        instance = null;
        other = null;
        sameAsInstance = null;
    }

    @Test
    public void testNotEquals() {
        boolean calculatedResult = instance.equals(other);
        boolean expectedResult = false;
        assertEquals("The two inspections was wrongfully deemed to be equal", expectedResult, calculatedResult);
    }

    @Test
    public void testEquals() {
        boolean calculatedResult = instance.equals(sameAsInstance);
        boolean expectedResult = true;
        assertEquals("The two inspections was wrongfully deemed not to be equal", expectedResult, calculatedResult);
    }

}