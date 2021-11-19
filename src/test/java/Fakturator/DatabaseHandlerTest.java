package Fakturator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseHandlerTest {

    /**
     * Testy sprawdzające, czy w przypadku braku produktów, te funkcję zwrócą wartość 0.
     */
    @Test
    void getLongestProduct() {
        Assertions.assertEquals(0, AppManager.getDbhandler().getLongestProduct());
    }
    @Test
    void getLongestPrice() {
        Assertions.assertEquals(0, AppManager.getDbhandler().getLongestPrice());
    }
}