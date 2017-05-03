package se.kth.iv1350.model;

import se.kth.iv1350.dto.CreditCardDTO;

import java.util.Date;

/**
 * Created by Emil on 2017-05-02.
 */
public class Payment {

    private int cost;
    private int amountPaid;
    private CreditCardDTO creditCard;
    private Date dateOfTransaction;

    /**
     * Creates an payment object for a cash payment.
     * @param cost The cost of the payment
     * @param amountPaid The cash amount put into the system
     */
    public Payment(int cost, int amountPaid) {
        this.cost = cost;
        this.amountPaid = amountPaid;
    }

    /**
     * Creates an payment object for a credit card payment
     * @param cost The cost of the payment
     * @param creditCard The credit card to make the payment with
     */
    public Payment(int cost, CreditCardDTO creditCard) {
        this.cost = cost;
        this.creditCard = creditCard;
    }

    /**
     * Attempts to make a card payment
     * @return True if the payment was authorized
     */
    public boolean makeCardPayment() {
        ExtPayAuthSys extPayAuthSys = new ExtPayAuthSys();
        this.dateOfTransaction = new Date();
        return true;
    }

    /**
     * Makes a cash payment
     * @return The change amount
     */
    public int makeCashPayment() {
        this.dateOfTransaction = new Date();
        return cost - amountPaid;
    }

    public Date getDateOfTransaction() {
        return dateOfTransaction;
    }
}
