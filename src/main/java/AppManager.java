import javax.xml.crypto.Data;
import java.awt.image.DataBuffer;
import java.util.ArrayList;
import java.util.Scanner;

public class AppManager {
    public static DatabaseHandler dbhandler = new DatabaseHandler();
    /**
     * This class need to comunicate with user, and
     * it gives him options preceed with numbers, and this
     * value stores his choice.
     * */
    private static int choosenOption;
    public static void invoiceMaker(Scanner input) {
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
                        System.out.println(customer.getCustomerName());
                    }
                }
            }
            if (choosenOption == 2) {
                dbhandler.customersList.add(new Customer(input));
            }
            System.out.println("1: Wybierz sprzedawcę z istniejących \n"
                    + "2: Dodaj");
            choosenOption = Integer.parseInt(input.nextLine());
            if (choosenOption == 1) {
                if (dbhandler.customersList.size() == 0) {
                    System.out.println("Brak zapisanych klientów");
                    choosenOption = 2;
                } else {
                    for (Customer customer : dbhandler.customersList) {
                        System.out.println(customer.getCustomerName());
                    }
                }
            }
            if (choosenOption == 2) {
                dbhandler.customersList.add(new Customer(input));
            }

        } catch (Exception e) {
            System.out.println("Wystapił błąd, prosimy spróbować ponownie");
        }
        finally {
            input.close();
        }


    }
    public static void showInvoice() {
        System.out.println("działa");
    }
    public static void newValue() {
        System.out.println("Wybierz rodzaj: \n"
        + "");
    }
}
