package Fakturator;
import java.math.BigDecimal;
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

    public void setProductCounter(int productCounter) {
        this.productCounter = productCounter;
    }
    public void printProduct() {
        System.out.print(productName);
        if(productName.length() < AppManager.getDbhandler().getLongestProduct()) {
            for(int k = 0; k < AppManager.getDbhandler().getLongestProduct() - productName.length();k++) {
                System.out.print(" ");
            }
        }
        System.out.print(" " + productCounter);
        if(String.valueOf(productCounter).length() < 6) {
            for(int i = 0; i < 6-String.valueOf(productCounter).length(); i++) {
                System.out.print(" ");
            }
        }

        System.out.print(" " + new BigDecimal(productPrice*productCounter).toPlainString());
        if(String.valueOf(new BigDecimal(productPrice*productCounter)).length() < AppManager.getDbhandler().getLongestPrice()) {
            for (int i = 0; i < AppManager.getDbhandler().getLongestPrice() - String.valueOf(new BigDecimal(productPrice*productCounter)).length(); i++) {
                System.out.print(" ");
            }
        }

        System.out.print(" " + priceTax + "%");
        for(int i = 0; i < 6 - String.valueOf(priceTax).length(); i++) {
            System.out.print(" ");
        }
        System.out.println(" "
                + String.format("%.2f",new BigDecimal((priceTax/100)*productCounter*productPrice)));
    }
}
