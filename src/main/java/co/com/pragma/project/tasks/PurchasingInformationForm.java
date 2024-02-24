package co.com.pragma.project.tasks;


import co.com.pragma.project.models.PurchasingDataInformationFormDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

import static co.com.pragma.project.ui.HomeUI.MODAL_CART;
import static co.com.pragma.project.ui.ProductUI.*;
import static co.com.pragma.project.utils.Constant.TIME_SHORT;
import static co.com.pragma.project.utils.Date.dateMonth;
import static co.com.pragma.project.utils.Date.dateYear;
import static co.com.pragma.project.utils.Time.waiting;

@AllArgsConstructor
@Slf4j
public class PurchasingInformationForm implements Task {

    private String pathFile;
    private static final Faker faker = Faker.instance(new Locale("es", "CO"), new Random());

    @Override
    @Step("{0} ingresa hasta el modal del carrito de compras, para llenar el formulario de datos con la informacion" +
            "personal")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(MODAL_CART),
                Click.on(BUTTON_PLACE_ORDER)
        );
        waiting(TIME_SHORT);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            PurchasingDataInformationFormDTO dataInformationFormDTO = objectMapper.readValue
                    (data(pathFile), PurchasingDataInformationFormDTO.class);

            String firstNameFul = dataInformationFormDTO.getFirstNameFul();
            String country = dataInformationFormDTO.getCountry();
            String city = dataInformationFormDTO.getCity();
            String creditCard = dataInformationFormDTO.getCreditCard();
            String month = dataInformationFormDTO.getMonth();
            String year = dataInformationFormDTO.getYear();

            actor.attemptsTo(
                    Enter.theValue(firstNameFul).into(INPUT_NAME),
                    Enter.theValue(country).into(INPUT_COUNTRY),
                    Enter.theValue(city).into(INPUT_CITY),
                    Enter.theValue(creditCard).into(INPUT_CREDIT_CARD),
                    Enter.theValue(month).into(INPUT_MONTH),
                    Enter.theValue(year).into(INPUT_YEAR),
                    Click.on(BUTTON_PURCHASE)
            );

        } catch (IOException e) {
            log.error(String.valueOf(e));
        }
    }

    public static PurchasingInformationForm withParams(String pathFile) {
        return Tasks.instrumented(PurchasingInformationForm.class, pathFile);
    }

    /**
     * El sub metodo (data) recibe un parametro de la ruta completa, donde se encuentra el archivo .json
     * se crea con el fin de separar la responsabilidad del metodo principal
     * tambien se creo con el fin de obtener los datos,
     * y reemplazarlos por los valores que estan parametrizados linea 99 - 106
     * */
    public static String data(String pathFile) throws IOException {
        LocalDate currentDate = LocalDate.now();
        ObjectMapper objectMapper = new ObjectMapper();
        File fileTemplate = new File(pathFile);
        JsonNode jsonNode = objectMapper.readTree(fileTemplate);

        /*
          los 6 campos tipos string, se les asignara el valor de cada uno de los datos del formulario
          se utiliza el pluguin faker para generarlos aleatorio con el fin que el script tenga robustes
          se trabaja de dicha manera para protejer los datos
          */
        String names = String.valueOf(faker.name().name());
        String contry = faker.address().country();
        String city = faker.address().city();
        String creditCard = faker.finance().creditCard();
        String month = dateMonth(currentDate);
        String year = dateYear(currentDate);

        String jsonModified = jsonNode.toString()
                .replace("${firstNameFul}", names)
                .replace("${country}", contry)
                .replace("${city}", city)
                .replace("${creditCard}", creditCard)
                .replace("${month}", month)
                .replace("${year}", year);

        log.info(jsonModified);

        return jsonModified;
    }
}