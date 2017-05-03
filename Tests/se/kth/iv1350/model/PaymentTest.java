package se.kth.iv1350.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.dto.CreditCardDTO;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Emil on 2017-05-02.
 */
public class PaymentTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCashPaymentReciept() throws Exception {
        Payment payment = new Payment(70, 100);
    }

    @Test
    public void testCardPaymentReciept() throws Exception {
        Payment payment = new Payment(100, new CreditCardDTO(
                "Bosse Eriksson", "4321", "111", new Date()
        ));

    }

}