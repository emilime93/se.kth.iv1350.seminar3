package se.kth.iv1350.dto;

import java.util.Date;

/**
 * Created by Emil on 2017-05-01.
 */
public class CreditCardDTO {

    private String holder;
    private String cardNumber;
    private String cvc;
    private Date expiaryDate;

    /**
     * Creates a Credit Card DTO that holds relevant information
     * @param holder The name of the card holder
     * @param cardNumber The card number
     * @param cvc The cvc security code
     * @param expiaryDate The expiary date
     */
    public CreditCardDTO(String holder, String cardNumber, String cvc, Date expiaryDate) {
        this.holder = holder;
        this.cardNumber = cardNumber;
        this.cvc = cvc;
        this.expiaryDate = expiaryDate;
    }

    public String getHolder() {
        return holder;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCvc() {
        return cvc;
    }

    public Date getExpiaryDate() {
        return expiaryDate;
    }
}
