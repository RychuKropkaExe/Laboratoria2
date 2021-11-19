package Fakturator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AppManagerTest {

    @Test
    void newValue() {
        String data = "Chleb" +
                "\n2137" + "\n23";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Scanner scanner = new Scanner(System.in);
        AppManager.newValue(scanner);
        Assertions.assertEquals(2137,AppManager.getDbhandler().productsList.get(0).getProductPrice());
        Assertions.assertEquals(23,AppManager.getDbhandler().productsList.get(0).getPriceTax());
        Assertions.assertEquals("Chleb",AppManager.getDbhandler().productsList.get(0).getProductName());

    }
}