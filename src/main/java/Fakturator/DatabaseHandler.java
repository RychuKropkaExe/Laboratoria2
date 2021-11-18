package Fakturator;

import Fakturator.Invoice;
import Fakturator.Seller;

import java.util.ArrayList;


public class DatabaseHandler {
    protected int customerCounter=0;
    protected int sellerCounter=0;
    protected int productCounter=0;
    protected int invoiceCounter=0;
    protected ArrayList<Customer> customersList = new ArrayList<>();
    protected ArrayList<Seller> sellersList = new ArrayList<>();
    protected ArrayList<Product> productsList = new ArrayList<>();
    protected ArrayList<Invoice> invoicesList = new ArrayList<>();
}
