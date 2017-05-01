package se.kth.iv1350.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Emil on 2017-04-30.
 */

class InspectionTest {

    Inspection instance;
    Inspection other;
    Inspection third;

    @BeforeEach
    void setUp() {
        instance = new Inspection("Brakes", 30);
        other = new Inspection("Engine", 50);
        third = new Inspection("brakes", 30);
    }

    @AfterEach
    void tearDown() {
        instance = null;
        other = null;
        third = null;
    }

    @Test
    void testNotEquals() {
        boolean comparisonResult = instance.equals(other);
        assertFalse(comparisonResult, "The condition is true, when supposed to be false.");
    }

    @Test
    void testEquals() {
        boolean comparisonResult = instance.equals(third);
        assertTrue(comparisonResult, "The condition is false, when supposed to be true.");
    }

}