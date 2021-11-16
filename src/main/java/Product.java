import java.util.Scanner;

public class Product {
    /**
     * Variable to simplify invoice making process, so that the number of product
     * could be definied in choosen product itself.
     */
    private int productCounter;
    private String productName;
    private Double productPrice;
    private Double priceTax;
    /**
     * A uniqe value to every Product as a way of simple indentification.
     */
    private int productID;

    /**
     * A constructor to initlize a Product and add it to Products list.
     * @param input a scanner, nothing special.
     */
    public Product(final Scanner input) {
        System.out.println("Podaj nazwę produktu");
        try {
            productName = input.nextLine();
            System.out.println("Podaj cenę produktu");
            productPrice = Double.parseDouble(input.nextLine());
            System.out.println("Podaj wartość podatku dla tego produktu");
            priceTax = Double.parseDouble(input.nextLine());
        } catch (Exception e) {
            System.out.println("Wystapił błąd, proszę spróbować ponownie");
        }
    }
}
