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

    @Test
    public void testCashPaymentReciept() throws Exception {
        Payment payment = new Payment(100, 70);
        double change = payment.makeCashPayment();
        double expectedChange = 30;
        boolean expected = true;
        boolean calculated = false;
        if(change == expectedChange) {
            calculated = true;
        }
        assertEquals("Incorrect change", expected, calculated);
    }

    @Test
    public void testCardPaymentReciept() throws Exception {
        Payment payment = new Payment(100, new CreditCardDTO(
                "Bosse Eriksson", "4321", "111", new Date()
        ));
        boolean calculated = payment.makeCardPayment();
        boolean expected = true;
        assertEquals("Card payment that should be authorized isnt authroized", expected, calculated);
    }

}