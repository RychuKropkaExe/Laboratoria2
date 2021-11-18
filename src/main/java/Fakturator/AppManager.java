package Fakturator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public final class AppManager {
    private AppManager() {

    }
    private static DatabaseHandler dbhandler = new DatabaseHandler();
    private static int customerCounter = 0;
    private static int sellerCounter = 0;
    private static int productCounter = 0;
    private static int invoiceCounter = 0;
    /**
     * This class need to communicate with user, and
     * it gives him options preceed with numbers, and this
     * value stores his choice.
     * */
    private static int choosenOption;
    /**
     * it sole purpose of existance is to display numbers in loops.
     */
    private static int counter = 0;

    /**
     * A method to create an Invoice.
     * @param input we need to take users input so..
     */
    public static void invoiceMaker(final Scanner input) {
        dbhandler.invoicesList.add(new Invoice());
        try {
            System.out.println("Proszę wprowadzić odpowiednie dane do faktury \n"
                    + "Pamiętaj, że wszystkie dane muszą być poprawne \n"
                    + "by faktura została zaakceptowana \n");
            System.out.println("1:Wybierz klienta z istniejąych \n"
                    + "2: Dodaj");
            choosenOption = Integer.parseInt(input.nextLine());
            if (choosenOption == 1) {
                if (dbhandler.customersList.size() == 0) {
                    System.out.println("Brak zapisanych klientów");
                    choosenOption = 2;
                } else {
                    for (Customer customer : dbhandler.customersList) {
                        System.out.println(counter + ": " + customer.getCustomerName());
                        counter++;
                    }
                    counter = 0;
                    choosenOption = Integer.parseInt(input.nextLine());
                    dbhandler.setInvoiceCustomer(invoiceCounter, choosenOption);
                }
            }
            if (choosenOption == 2) {
                dbhandler.customersList.add(new Customer(input, customerCounter));
                dbhandler.setInvoiceCustomer(invoiceCounter, customerCounter);
                customerCounter++;
            }
            System.out.println("1: Wybierz sprzedawcę z istniejących \n"
                    + "2: Dodaj");
            choosenOption = Integer.parseInt(input.nextLine());
            if (choosenOption == 1) {
                if (dbhandler.sellersList.size() == 0) {
                    System.out.println("Brak zapisanych sprzedawców");
                    choosenOption = 2;
                } else {
                    for (Seller seller : dbhandler.sellersList) {
                        System.out.println(counter + ": " + seller.getSellerName());
                    }
                    counter = 0;
                    choosenOption = Integer.parseInt(input.nextLine());
                    dbhandler.setInvoiceSeller(invoiceCounter, choosenOption);
                }
            }
            if (choosenOption == 2) {
                dbhandler.sellersList.add(new Seller(input, sellerCounter));
                dbhandler.setInvoiceSeller(invoiceCounter, sellerCounter);
                sellerCounter++;
            }
            while (true) {
                System.out.println("1: Wybierz produkt z listy \n"
                + "2: zakończ wybieranie");
                choosenOption = Integer.parseInt(input.nextLine());
                if (choosenOption == 2) {
                    break;
                }
                if (choosenOption == 1) {
                    if (dbhandler.productsList.size() != 0) {
                        for (Product product : dbhandler.productsList) {
                            System.out.println(counter + ": " + product.getProductName());
                            counter++;
                        }
                        counter = 0;
                        choosenOption = Integer.parseInt(input.nextLine());
                        dbhandler.setInvoiceProducts(invoiceCounter, choosenOption, input);
                    } else {
                        System.out.println("Brak produktów do wybrania, wprowadź odpowiednie do bazy");
                        throw new NullPointerException();
                    }
                }
            }
            dbhandler.invoicesList.get(invoiceCounter).setDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
            invoiceCounter++;
        } catch (Exception e) {
            System.out.println(e);
            if (e instanceof NullPointerException) {
                System.out.println("Nie można utworzyć faktury, gdyż nie ma z czego");
            } else {
                System.out.println("Wystapił błąd, prosimy spróbować ponownie");
            }
                dbhandler.invoicesList.set(invoiceCounter, null);
                invoiceCounter--;
        }


    }
    public static void showInvoice(final Scanner input) {
        if (dbhandler.invoicesList.size() != 0) {
            System.out.println("Wybierz którą fakturę chcesz wyświetlić:");
            for (Invoice invoice : dbhandler.invoicesList) {
                System.out.println(counter + ": " + (invoice.getCustomer()).getCustomerID() + " " + (invoice.getCustomer()).getCustomerName());
            }
            choosenOption = Integer.parseInt(input.nextLine());
        } else {
            System.out.println("Brak faktur do wyświetlenia");
        }
        Invoice display = dbhandler.invoicesList.get(choosenOption);
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println(display.getDate() + "\n");
        System.out.println("Nabywca:");
        display.getCustomer().printCustomer();
        System.out.println(" ");
        System.out.println("Sprzedawca: ");
        display.getSeller().printSeller();
        System.out.println(" ");
        System.out.print("LP " + "Produkt");
        //Magic numbers below represents length of words below which the values are displayed.
        //In if below its the length of word "Produkt"
        if (dbhandler.getLongestProduct() > 7) {
            for (int i = 0; i < dbhandler.getLongestProduct() - 7; i++) {
                System.out.print(" ");
            }
        }
        System.out.print(" Liczba" + " Wartość");
        if (dbhandler.getLongestPrice() > 7) {
            for (int i = 0; i < dbhandler.getLongestPrice() - 8; i++) {
                System.out.print(" ");
            }
        }
        System.out.println("  Podatek" +  " Wartość podatku");
        for (Product product : display.getProducts()) {
            counter++;
            System.out.print(counter + "  ");
            product.printProduct();
        }
        counter = 0;
        System.out.println("-----------------------------------------------------------------------------");
    }
    public static void newValue(Scanner input) {
        dbhandler.productsList.add(new Product(input, productCounter));
        productCounter++;
    }
    public static DatabaseHandler getDbhandler() {
        return dbhandler;
    }
}
