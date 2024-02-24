package co.com.pragma.project.tasks;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

import static co.com.pragma.project.ui.ProductUI.*;
import static co.com.pragma.project.ui.ProductUI.BUTTON_PURCHASE;
import static co.com.pragma.project.utils.Constant.TIME_SHORT;
import static co.com.pragma.project.utils.Date.dateMonth;
import static co.com.pragma.project.utils.Date.dateYear;
import static co.com.pragma.project.utils.Time.waiting;

@AllArgsConstructor
@Slf4j
public class PurchasingIncompleteForm implements Task {

    private String pathFile;
    private static final Faker faker = Faker.instance(new Locale("es", "CO"), new Random());

    @Override
    @Step("{0} ingresa hasta el modal del carrito de compras, para llenar el formulario de datos con la informacion" +
            "personal pero INCOMPLETO")
    public <T extends Actor> void performAs(T actor) {
        LocalDate currentDate = LocalDate.now();
        actor.attemptsTo(
                Click.on(BUTTON_PLACE_ORDER)
        );
        waiting(TIME_SHORT);
        String names = String.valueOf(faker.name().name());
        String country = faker.address().country();
        String city = faker.address().city();
        String creditCard = "";
        String month = dateMonth(currentDate);
        String year = dateYear(currentDate);
        actor.attemptsTo(
                Enter.theValue(names).into(INPUT_NAME),
                Enter.theValue(country).into(INPUT_COUNTRY),
                Enter.theValue(city).into(INPUT_CITY),
                Enter.theValue(creditCard).into(INPUT_CREDIT_CARD),
                Enter.theValue(month).into(INPUT_MONTH),
                Enter.theValue(year).into(INPUT_YEAR),
                Click.on(BUTTON_PURCHASE)
        );

    }

    public static PurchasingIncompleteForm withParams(String pathFile) {
        return Tasks.instrumented(PurchasingIncompleteForm.class, pathFile);
    }
}