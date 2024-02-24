package co.com.pragma.project.questions;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;

import java.util.Arrays;
import java.util.List;

import static co.com.pragma.project.ui.ProductUI.*;
import static co.com.pragma.project.utils.Constant.TIME_SHORT;
import static co.com.pragma.project.utils.Time.waiting;

@AllArgsConstructor
@Slf4j
public class ValidateCheckoutComplete implements Question<Boolean> {


    @Override
    @Subject("{0} valida que se haya completado la orden de compra #confirmOrder")
    public Boolean answeredBy(Actor actor) {
        /*
        Se realiza valiacion de tres localizadores , uno en ingles y los otros dos en español, esto con el fin de tener
        el control de errores, ya que la pagina alguna veces el mensaje final de la compra aparece del alguna de los dos
        idiomas (español-ingles) y tiende a cambiar un atributo y puede aparecer de las dos maneras
         */
        waiting(TIME_SHORT);
        List<Target> elements = Arrays.asList(
                TXT_MENSSAGE_COMPLETE_ORDER_SPANISH,
                TXT_MENSSAGE_COMPLETE_ORDER_ENGLISH,
                TXT_MENSSAGE_COMPLETE_ORDER_SPANISH2
        );

        for (net.serenitybdd.screenplay.targets.Target element : elements) {
            boolean elementoVisible = Visibility.of(element).answeredBy(actor);
            if (elementoVisible) {
                // Loguear el mensaje del idioma encontrado y retornar true
                log.info("Validación en " + element.getName() + ", exitosa");
                return true;
            }
        }
            // Si ninguno de los elementos está visible, retornar false
            log.info("No se encontró ninguno de los textos a validar");
            return false;

    }

    public static ValidateCheckoutComplete withParams() {
        return new ValidateCheckoutComplete();
    }
}