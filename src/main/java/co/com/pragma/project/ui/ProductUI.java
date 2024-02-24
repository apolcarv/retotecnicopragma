package co.com.pragma.project.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductUI extends PageObject {

    /**
     * Mapeo de localizadores del Product
     */

    public static final Target BUTTON_PLACE_ORDER = Target.the("pulsa el boton, realizar pedido ")
            .located(By.xpath("//button[@data-target='#orderModal']"));

    public static final Target INPUT_NAME = Target.the("inserta el nombre")
            .located(By.id("name"));

    public static final Target INPUT_COUNTRY = Target.the("inserta el pais")
            .located(By.id("country"));

    public static final Target INPUT_CITY = Target.the("inserta la ciudad")
            .located(By.id("city"));

    public static final Target INPUT_CREDIT_CARD = Target.the("inserta el numero de tarjeta de credito de prueba")
            .located(By.id("card"));

    public static final Target INPUT_MONTH = Target.the("inserta el año en curso o actual")
            .located(By.id("month"));

    public static final Target INPUT_YEAR = Target.the("inserta el mes en curso o actual")
            .located(By.id("year"));

    public static final Target BUTTON_PURCHASE = Target.the("pulsa el boton,  comprar ")
            .located(By.xpath("//button[@onclick='purchaseOrder()']"));

    public static final Target TXT_MENSSAGE_COMPLETE_ORDER_ENGLISH = Target.the("obtiene el texto Gracias por su compra! - en ingles")
            .located(By.xpath("//div[@class='sweet-alert  showSweetAlert visible']//h2[contains(text(),'Thank you for your purchase!')]"));

    public static final Target TXT_MENSSAGE_COMPLETE_ORDER_SPANISH = Target.the("obtiene el texto Gracias por su compra! - en español")
            .located(By.xpath("//div[@class='sweet-alert  showSweetAlert visible']//h2//font[contains(text(),'Gracias por su compra!')]"));

    public static final Target TXT_MENSSAGE_COMPLETE_ORDER_SPANISH2 = Target.the("obtiene el texto Gracias por su compra! - en español")
            .located(By.xpath("//div[@class='sweet-alert  showSweetAlert visible']//h2[contains(text(),'Gracias por su compra!')]"));

}