package Fakturator;
import java.util.Scanner;

public class Customer {
    private String customerName;
    /**
     * A unique value that is given to every new "Customer"
     * as a way to simplify database usage.
     */
    private final int customerID;
    private double customerNIP;
    private String customerAdress;
    private String customerPostalCode;
    private String customerTown;

    public Customer(final Scanner input, final int iD) {
        this.customerID = iD;
        try {
            System.out.println("Podaj imię i nazwisko klienta lub nazwę firmy");
            customerName = input.nextLine();
            System.out.println("Podaj NIP, pamiętaj że musi on mieć 10 cyfr");
            customerNIP = Double.parseDouble(input.nextLine());
            System.out.println("Podaj miasto zamieszkania/siedziby");
            customerTown = input.nextLine();
            System.out.println("Podaj ulicę i numer budynku");
            customerAdress = input.nextLine();
            System.out.println("Podaj kod pocztowy");
            customerPostalCode = input.nextLine();
        } catch (Exception e) {
            System.out.println("Wystąpił Błąd, proszę spróbować jeszcze raz");
        }
    }
    public int getCustomerID() {
        return customerID;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void printCustomer() {
        System.out.println(customerName);
        System.out.println(customerNIP);
        System.out.println(customerTown);
        System.out.println(customerAdress);
        System.out.println(customerPostalCode);
    }
}
