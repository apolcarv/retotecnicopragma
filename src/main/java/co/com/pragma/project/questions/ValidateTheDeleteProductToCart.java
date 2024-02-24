package co.com.pragma.project.questions;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.annotations.Subject;

import static co.com.pragma.project.ui.HomeUI.BUTTON_DELETE_TO_CARD;
import static co.com.pragma.project.utils.Constant.TWO;
import static co.com.pragma.project.utils.SelectLocator.getAmountYourCart;
import static co.com.pragma.project.utils.Time.waiting;

@AllArgsConstructor
@Slf4j
public class ValidateTheDeleteProductToCart implements Question<Boolean> {

    private final int confirmAmount;

    @Override
    @Subject("{0} valida la cantidad de productos dentro del carrito #confirmAmount")
    public Boolean answeredBy(Actor actor) {
        boolean result;
        String getAmountProduct  = String.valueOf(getAmountYourCart());
        String txtNumberValidate = String.valueOf(confirmAmount);
        if (txtNumberValidate.equals(getAmountProduct)) {
            log.info(getAmountProduct);
            for (int i = 0; i < getAmountYourCart(); i++){
                actor.attemptsTo(Click.on(BUTTON_DELETE_TO_CARD));
                waiting(getAmountYourCart());
            }
            result = true;
        } else {
            for (int i = 0; i < getAmountYourCart(); i++) {
                actor.attemptsTo(Click.on(BUTTON_DELETE_TO_CARD));
                waiting(TWO);
            }
            result = false;
        }
        return result;
    }

    public static ValidateTheDeleteProductToCart success(int confirmAmount) {
        return new ValidateTheDeleteProductToCart(confirmAmount);
    }
}