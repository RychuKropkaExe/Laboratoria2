package Fakturator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;


public final class DatabaseHandler {
    /**
     * All these lists are the "storage" of the app.
     */
    protected ArrayList<Customer> customersList = new ArrayList<>();
    protected ArrayList<Seller> sellersList = new ArrayList<>();
    protected ArrayList<Product> productsList = new ArrayList<>();
    protected ArrayList<Invoice> invoicesList = new ArrayList<>();

    /**
     *  A method to insert a Customer into the invoice.
     * @param invoiceIndex which invoice to take.
     * @param customerIndex which customer to insert.
     */
    public void setInvoiceCustomer(final int invoiceIndex, final int customerIndex) {
        invoicesList.get(invoiceIndex).setCustomer(customersList.get(customerIndex));
    }

    /**
     * a method to insert a Seller into the invoice.
     * @param invoiceIndex which invoice to take.
     * @param sellerIndex which seller to insert.
     */
    public void setInvoiceSeller(final int invoiceIndex, final int sellerIndex) {
        invoicesList.get(invoiceIndex).setSeller(sellersList.get(sellerIndex));
    }

    /**
     *a method to insert a Product into the invoice.
     * @param invoiceIndex which invoice to take.
     * @param productIndex which product to insert.
     * @param input a scanner, because we need to ask user how many products should be inserted.
     */
    public void setInvoiceProducts(final int invoiceIndex, final int productIndex, final Scanner input) {
        invoicesList.get(invoiceIndex).setProducts(productsList.get(productIndex), input);
    }

    /**
     * To scale printed invoice we need to
     * know what is the longest product name on the invoice.
     * @return size of the longest product name.
     */
    public int getLongestProduct() {
        int length = 0;
        for (Product product : productsList) {
            if (product.getProductName().length() > length) {
                length = product.getProductName().length();
            }
        }
        return length;
    }

    /**
     * To scale printed invoice we need to
     * know what is the length(size in string terms) of the longest price.
     * @return size(in string terms) of the longest price
     */
    public int getLongestPrice() {
        int length = 0;
        for (Product product : productsList) {
            if (String.valueOf(new BigDecimal(product.getProductPrice() * product.getProductCounter())).length() > length) {
                length = String.valueOf(new BigDecimal(product.getProductPrice()
                        * product.getProductCounter())).length();
            }
        }
        return length;
    }
}
