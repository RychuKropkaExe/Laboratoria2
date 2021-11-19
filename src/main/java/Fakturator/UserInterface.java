package Fakturator;

import java.util.Scanner;

/**
 *Its a class to communicate with user, from which he can realize
 *the functions needed in this task.
 */
public class UserInterface {
    /**
     * a scanner, nothing special.
     */
    private static Scanner scanner = new Scanner(System.in);
    /**
     * It takes users input to determine which action to make.
     */
    private static int choosenValue;

    public static void main(final String[] args) {
        while (true) {
            System.out.println("Witaj w aplikacji do wystawiania faktur! \n"
                    + "Wybierz czynność którą chcesz wykonać:");
            System.out.println("1: Wystawienie nowej faktury \n"
                    + "2: Podgląd faktury \n"
                    + "3: Wprowadzenie nowego produktu/towaru \n"
                    + "4: Wyjdź");
            try {
                choosenValue = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Podana wartosć nie jest liczbą naturalną");
            }
            switch (choosenValue) {
                case 1:
                    AppManager.invoiceMaker(scanner);
                    break;
                case 2:
                    AppManager.showInvoice(scanner);
                    break;
                case 3:
                    AppManager.newValue(scanner);
                    break;
                case 4:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wybrano złą wartość");
            }
        }
    }
}
