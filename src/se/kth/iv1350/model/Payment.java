package se.kth.iv1350.model;

import se.kth.iv1350.dto.CreditCardDTO;

/**
 * Created by Emil on 2017-05-02.
 */
public class Payment {

    private int cost;
    private int amountPaid;
    private CreditCardDTO creditCard;

    public Payment(int cost, int amountPaid) {
        this.cost = cost;
        this.amountPaid = amountPaid;
    }

    public Payment(int cost, CreditCardDTO creditCard) {
        this.cost = cost;
        this.creditCard = creditCard;
    }

    public boolean makeCardPayment() {
        ExtPayAuthSys extPayAuthSys = new ExtPayAuthSys();
        return true;
    }

    public int makeCashPayment() {
        return cost - amountPaid;
    }
}
