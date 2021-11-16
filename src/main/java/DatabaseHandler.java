import java.util.ArrayList;
import java.util.Scanner;


public class DatabaseHandler {
    protected ArrayList<Customer> customersList = new ArrayList<>();
    public void setcustomersList(Customer newCustomer){
        customersList.add(newCustomer);
    }
    public ArrayList<Customer> getcustomersList(){
        return customersList;
    }
}
