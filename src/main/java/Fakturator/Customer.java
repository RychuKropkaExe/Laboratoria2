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

    public Customer(final Scanner input, final int customerID) {
        this.customerID=customerID;
        try {
            System.out.println("Podaj imię i nazwisko klienta lub nazwę firmy");
            customerName = input.nextLine();
            System.out.println("Podaj NIP, pamiętaj że musi on mieć 10 cyfr");
            customerNIP = Double.parseDouble(input.nextLine());
            System.out.println("Podaj miasto zamieszkania/siedziby");
            customerTown = input.nextLine();
            System.out.println("Podaj numer budynku");
            customerAdress = input.nextLine();
            System.out.println("Podaj kod pocztowy");
            customerPostalCode = input.nextLine();
        } catch (Exception e) {
            System.out.println("Wystąpił Błąd, proszę spróbować jeszcze raz");
        }
    }

    public String getCustomerTown() {
        return customerTown;
    }

    public String getCustomerPostalCode() {
        return customerPostalCode;
    }

    public String getCustomerAdress() {
        return customerAdress;
    }

    public double getCustomerNIP() {
        return customerNIP;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }
}
