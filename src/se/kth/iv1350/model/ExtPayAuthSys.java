package se.kth.iv1350.model;

/**
 * A class representing a dummy External Payment Authorization System.
 */
public class ExtPayAuthSys {

    /**
     * Authorizes payment at the authorization system.
     * However this dummy implementation always successfully authorizes the payment
     * @param paymentToAuthroize The payment to authorize
     * @return The status of the authorization. True for <code>Authorized</code> and false otherwise
     */
    public static boolean authorizePayment(Payment paymentToAuthroize) {
        return true;
    }
}