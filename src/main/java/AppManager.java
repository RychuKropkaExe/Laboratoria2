import javax.xml.crypto.Data;
import java.awt.image.DataBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class AppManager {
    private static DatabaseHandler dbhandler = new DatabaseHandler();
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
    public static void invoiceMaker(Scanner input) {
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
                    dbhandler.invoicesList.get(dbhandler.invoiceCounter).setCustomer(dbhandler.customersList.get(choosenOption));
                }
            }
            if (choosenOption == 2) {
                dbhandler.customersList.add(new Customer(input, dbhandler.customerCounter));
                dbhandler.customerCounter++;
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
                    dbhandler.invoicesList.get(dbhandler.invoiceCounter).setSeller(dbhandler.sellersList.get(choosenOption));
                }
            }
            if (choosenOption == 2) {
                dbhandler.sellersList.add(new Seller(input, dbhandler.sellerCounter));
                dbhandler.sellerCounter++;
            }
            while (true) {
                System.out.println("1: Wybierz produkt z listy \n"
                + "2: zakończ wybieranie");
                choosenOption = Integer.parseInt(input.nextLine());
                if(choosenOption == 2) {
                    break;
                }
                if(choosenOption == 1) {
                    if (dbhandler.productsList.size() != 0) {
                        for (Product product : dbhandler.productsList) {
                            System.out.println(counter + ": " + product.getProductName());
                            counter++;
                        }
                        counter=0;
                        choosenOption = Integer.parseInt(input.nextLine());
                        dbhandler.invoicesList.get(dbhandler.invoiceCounter).setProducts(dbhandler.productsList.get(choosenOption), input);
                    } else {
                        System.out.println("Brak produktów do wybrania, wprowadź odpowiednie do bazy");
                        throw new NullPointerException();
                    }
                }
            }
            dbhandler.invoicesList.get(dbhandler.invoiceCounter).setDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        } catch (Exception e) {
            System.out.println(e);
            if(e instanceof NullPointerException) {
                System.out.println("Nie można utworzyć faktury, gdyż nie ma z czego");
            } else {
                System.out.println("Wystapił błąd, prosimy spróbować ponownie");
            }
                dbhandler.invoicesList.set(dbhandler.invoiceCounter, null);
                dbhandler.invoiceCounter--;
        }


    }
    public static void showInvoice(Scanner input) {
        if(dbhandler.invoicesList.size() != 0) {
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
        System.out.println(display.getDate());

    }
    public static void newValue(Scanner input) {
        dbhandler.productsList.add(new Product(input, dbhandler.productCounter));
        dbhandler.productCounter++;
    }
}
