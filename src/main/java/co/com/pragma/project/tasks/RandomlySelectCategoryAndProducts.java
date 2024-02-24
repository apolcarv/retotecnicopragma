package co.com.pragma.project.tasks;

import co.com.pragma.project.utils.Alert;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static co.com.pragma.project.ui.HomeUI.*;
import static co.com.pragma.project.utils.Constant.*;
import static co.com.pragma.project.utils.Random.*;
import static co.com.pragma.project.utils.Time.waiting;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

@AllArgsConstructor
@Slf4j
public class RandomlySelectCategoryAndProducts implements Task {

    private int chooseAmountProduct;
    private static final String MENSAGE_ALERT = "Alerta visible";

    @Override
    @Step("{0} Selecciona la categoria de forma aleatoria y de acuerdo a la seleccion de la categoria así mismo" +
            "seleccionara un producto de acuerdo al rango que este disponible")
    public <T extends Actor> void performAs(T actor) {
/*
La funcion (for) se crea con el fin de que nuestro flujo se repita las veces que nosotros queramos, que seria
agregar un producto al carrito de forma aleatorioa seleccionando cualquier categoria y producto de forma aleatoria
sin fallar las veces que se programe dentro del parametro que recibe (chooseAmountProduct)

 */
        for (int i = 0; i < chooseAmountProduct; i++) {
            int randomProduct = randomNumberTwoAndFour();
            String numberCategory = String.valueOf(randomProduct);

            actor.attemptsTo(Click.on(
                            ITEM_CATEGORY.of(numberCategory)),
                    Scroll.to(ITEM_CATEGORY.of(numberCategory))
            );

            switch (randomProduct) {
                case PRODUCT_PHONES:
                    int numberProduct = randomNumberOneToNine();
                    chooseProductToCart(actor, numberProduct);
                    break;
                case PRODUCT_LAPTOPS:
                    int numberProduct1 = randomNumberOneToSix();
                    chooseProductToCart(actor, numberProduct1);
                    break;
                case PRODUCT_MONITORS:
                    int numberProduct2 = randomNumberOneToTwo();
                    chooseProductToCart(actor, numberProduct2);
                    break;
                default:
                    break;
            }
        }
    }

    public static RandomlySelectCategoryAndProducts withParams(int chooseAmountProduct) {
        return Tasks.instrumented(RandomlySelectCategoryAndProducts.class, chooseAmountProduct);
    }

    /*
     El sub-metodo (chooseProductToCart) nos permitira hacer dos cosas en una, la primera siempre selecciona un producto
     de forma aleatoria y como segundo hace un control de errores,
     Por que... Al seleccionar el producto este saca una alert, pero no todos los productos al seleccionarlos sacan
     dicha alerta, la idea del condicional (if - si) es validar esa instruccion que se le da sin interrunpir el flujo,
     del script(robot) este continuara sin problema, ya que tiene el condicional (else - sino o demas) justamente
     para que el haga la instruccion codificada, (hacer un click en el modal home)
     */
    private static void chooseProductToCart(Actor actor, int random) {
        actor.attemptsTo(
                Click.on(CARD_PRODUCT.of(String.valueOf(random)))
        );
        waiting(TIME_SHORT);
        actor.attemptsTo(
                WaitUntil.the(BUTTON_ADD_TO_CARD, isVisible())
                        .forNoMoreThan(TIME_SHORT).seconds(), Click.on(BUTTON_ADD_TO_CARD)
        );

        if (Boolean.TRUE.equals(Alert.isPresent().answeredBy(actor))) {
            log.info(MENSAGE_ALERT);
            actor.attemptsTo(
                    Click.on(MODAL_HOME)
            );
        } else {
            actor.attemptsTo(
                    Click.on(MODAL_HOME)
            );
        }

        waiting(TIME_SHORT);
    }
}