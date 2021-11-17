import java.util.ArrayList;
import java.util.Scanner;

public class Invoice {
    private ArrayList<Product> products = new ArrayList<>();
    private Customer customer;
    private Seller seller;
    private String date;

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(Product product, Scanner input) {
        System.out.println("Wprowadź ilość:");
        product.setProductCounter(Integer.parseInt(input.nextLine()));
        products.add(product);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
