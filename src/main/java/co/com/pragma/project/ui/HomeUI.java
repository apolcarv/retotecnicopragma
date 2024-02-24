package co.com.pragma.project.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class HomeUI {
    /**
     * Mapeo de localizadores del home
     */

    public static final Target MODAL_HOME = Target.the("selecciona en el modal la opcion Home")
            .located(By.xpath("//div[@class='navbar-collapse']//a[starts-with(@href,'index')]"));

    public static final Target MODAL_CART = Target.the("selecciona en el modal la opcion Cart")
            .located(By.id("cartur"));

    //Localizador parametrizado - items categoria
    public static final Target ITEM_CATEGORY = Target.the("Selecciona cualquier de las tres categoria")
            .locatedBy("//div[@class='list-group']/a[{0}]");

    //Localizador parametrizado - General para los productos de las distintas categorias
    public static final Target CARD_PRODUCT = Target.the("Selecciona cualquier producto de la categoria" +
                    "seleccionada")
            .locatedBy("//div[{0}]/div/div/h4/a[@class='hrefch']");

    //Localizador - General para los productos de las distintas categorias
    public static final Target BUTTON_ADD_TO_CARD = Target.the("agrega productos a la canasta")
            .located(By.xpath("//a[@class='btn btn-success btn-lg']"));

}