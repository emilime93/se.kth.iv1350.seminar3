package se.kth.iv1350.dto;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Emil on 2017-05-01.
 */
public class VehicleDTOTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testEquals() throws Exception {
        VehicleDTO vehicle1 = new VehicleDTO("ABC 123");
        VehicleDTO vehicle2 = new VehicleDTO("abc 123");
        boolean expectedResult = true;
        boolean calculatedResult = vehicle1.equals(vehicle2);
        assertEquals("The two identical vehicles was wrongfully deemed not equal", expectedResult, calculatedResult);
    }

    @Test
    public void testNotEquals() {
        VehicleDTO vehicle1 = new VehicleDTO("ABC 333");
        VehicleDTO vehicle2 = new VehicleDTO("abc 123");
        boolean expectedResult = false;
        boolean calculatedResult = vehicle1.equals(vehicle2);
        assertEquals("The two identical vehicles was wrongfully deemed not equal", expectedResult, calculatedResult);
    }

}