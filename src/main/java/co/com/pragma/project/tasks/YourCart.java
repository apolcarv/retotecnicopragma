package co.com.pragma.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static co.com.pragma.project.ui.HomeUI.MODAL_CART;
import static co.com.pragma.project.ui.ProductUI.BUTTON_PLACE_ORDER;

public class YourCart implements Task {
    @Override
    @Step("{0} Abre el modal del carrito de compras")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(MODAL_CART)
        );
    }

    public static YourCart access() {
        return Tasks.instrumented(YourCart.class);
    }
}