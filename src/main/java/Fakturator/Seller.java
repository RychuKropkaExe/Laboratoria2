package Fakturator;

import java.util.Scanner;

public class Seller {
    private String sellerName;
    /**
     * A unique value that is given to every new "Customer"
     * as a way to simplify indentification.
     */
    private final int sellerID;
    private double sellerNIP;
    private String sellerAdress;
    private String sellerPostalCode;
    private String sellerTown;
    public Seller(final Scanner input,final int sellerID) {
        this.sellerID=sellerID;
        try {
            System.out.println("Podaj imię i nazwisko sprzedawcy lub nazwę firmy");
            sellerName = input.nextLine();
            System.out.println("Podaj NIP, pamiętaj że musi on mieć 10 cyfr");
            sellerNIP = Double.parseDouble(input.nextLine());
            System.out.println("Podaj miasto zamieszkania/siedziby");
            sellerTown = input.nextLine();
            System.out.println("Podaj numer budynku");
            sellerAdress = input.nextLine();
            System.out.println("Podaj kod pocztowy");
            sellerPostalCode = input.nextLine();
        } catch (Exception e) {
            System.out.println("Wystąpił Błąd, proszę spróbować jeszcze raz");
        }
    }

    public String getSellerName() {
        return sellerName;
    }

    public int getSellerID() {
        return sellerID;
    }

    public double getSellerNIP() {
        return sellerNIP;
    }

    public String getSellerAdress() {
        return sellerAdress;
    }

    public String getSellerPostalCode() {
        return sellerPostalCode;
    }

    public String getSellerTown() {
        return sellerTown;
    }
    public void printSeller() {
        System.out.println(sellerName);
        System.out.println("NIP: " + sellerNIP);
        System.out.println(sellerTown);
        System.out.println(sellerAdress);
        System.out.println(sellerPostalCode);
    }
}
