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
    private Receipt receipt;

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
     * Attempts to make a card payment and creates a receipt
     * @return True if the payment was authorized
     */
    public boolean makeCardPayment() {
        boolean isPaymentAuthorized = ExtPayAuthSys.authorizePayment(this);
        this.dateOfTransaction = new Date();
        receipt = new Receipt(this.creditCard, this.cost, this.dateOfTransaction);
        return isPaymentAuthorized;
    }

    /**
     * Makes a cash payment and creates a receipt
     * @return The change amount
     */
    public double makeCashPayment() {
        this.dateOfTransaction = new Date();
        double change = this.amountPaid - this.cost;
        receipt = new Receipt(this.amountPaid, this.cost, change, this.dateOfTransaction);
        return change;
    }
}
