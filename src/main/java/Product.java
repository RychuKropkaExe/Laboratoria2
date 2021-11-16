import java.util.Scanner;

public class Product {
    private final int productID;
    /**
     * Variable to simplify invoice making process, so that the number of product
     * could be stored in product instance itself.
     */
    private int productCounter;
    private String productName;
    private Double productPrice;
    private Double priceTax;
    /**
     * A constructor to initlize a Product and add it to Products list.
     * @param input a scanner, nothing special.
     */
    public Product(final Scanner input, int productID) {
        this.productID=productID;
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

    public int getProductID() {
        return productID;
    }

    public Double getPriceTax() {
        return priceTax;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductCounter() {
        return productCounter;
    }
}
