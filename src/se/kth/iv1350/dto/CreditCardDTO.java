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

    /**
     * Returns the name of the card holder
     * @return The name of the card holder
     */
    public String getHolder() {
        return holder;
    }

    /**
     * Returns the card number
     * @return The card number
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Returns the card cvc
     * @return The card cvc
     */
    public String getCvc() {
        return cvc;
    }

    /**
     * Returns the card expiary date
     * @return The expiary date
     */
    public Date getExpiaryDate() {
        return expiaryDate;
    }
}
