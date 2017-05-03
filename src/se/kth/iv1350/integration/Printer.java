package se.kth.iv1350.integration;


import se.kth.iv1350.model.Receipt;

/**
 * Created by Emil on 2017-05-01.
 */
public class Printer {

    /**
     * Prints the receipt to the standard out stream
     * @param receipt The receipt to be printed
     */
    public static void printReciept(Receipt receipt) {
        System.out.println(receipt);
    }

}
