package Fakturator;

import Fakturator.Invoice;
import Fakturator.Seller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;


public class DatabaseHandler {
    protected ArrayList<Customer> customersList = new ArrayList<>();
    protected ArrayList<Seller> sellersList = new ArrayList<>();
    protected ArrayList<Product> productsList = new ArrayList<>();
    protected ArrayList<Invoice> invoicesList = new ArrayList<>();

    public void setInvoiceCustomer(int invoiceIndex, int customerIndex) {
        invoicesList.get(invoiceIndex).setCustomer(customersList.get(customerIndex));
    }
    public void setInvoiceSeller(int invoiceIndex, int sellerIndex) {
        invoicesList.get(invoiceIndex).setSeller(sellersList.get(sellerIndex));
    }
    public void setInvoiceProducts(int invoiceIndex, int productIndex, Scanner input) {
        invoicesList.get(invoiceIndex).setProducts(productsList.get(productIndex), input);
    }
    public int getLongestProduct() {
        int length = 0;
        for(Product product : productsList) {
            if(product.getProductName().length() > length) {
                length = product.getProductName().length();
            }
        }
        return length;
    }
    public int getLongestPrice() {
        int length = 0;
        for(Product product : productsList) {
            if(String.valueOf(new BigDecimal(product.getProductPrice()*product.getProductCounter())).length() > length) {
                length = String.valueOf(product.getProductPrice()*product.getProductCounter()).length();
            }
        }
        return length;
    }
}
