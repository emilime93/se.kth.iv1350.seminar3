package se.kth.iv1350.model;

import se.kth.iv1350.dto.CreditCardDTO;

import java.util.Date;

/**
 * Created by Emil on 2017-05-03.
 */
public class Receipt {

    private Date dateOfTransaction;
    private double totalCost;

    private CreditCardDTO creditCard;

    private double amountPaid;
    private double change;

    public Receipt(CreditCardDTO creditCard, double totalCost, Date dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
        this.totalCost = totalCost;
        this.creditCard = creditCard;
    }

    public Receipt(double amountPaid, double totalCost,  double change, Date dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
        this.totalCost = totalCost;
        this.amountPaid = amountPaid;
        this.change = change;
    }

    @Override
    public String toString() {
        String stringRepresentaion = "--- Reciept ---\n" +
                "Cost:\t" + totalCost + "\n";
        // If it's a
        if(creditCard == null) {
            stringRepresentaion +=
                    "Paid:\t" + amountPaid + "\n" +
                            "Change:\t" + change + "\n" +
                            "Car Inspection Company\n";
        } else {    //If the payment if made by credit card
            stringRepresentaion += "Payment by card\n" +
                    "Car Inspection Company\n";
        }

        stringRepresentaion += "Date: " + this.dateOfTransaction;
        return stringRepresentaion;
    }
}
