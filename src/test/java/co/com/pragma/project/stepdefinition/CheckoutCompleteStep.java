package co.com.pragma.project.stepdefinition;

import co.com.pragma.project.questions.ValidateCheckoutComplete;
import co.com.pragma.project.tasks.PurchasingInformationForm;
import co.com.pragma.project.tasks.RandomlySelectCategoryAndProducts;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.util.EnvironmentVariables;

import static co.com.pragma.project.utils.Constant.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CheckoutCompleteStep {

    private static EnvironmentVariables environmentVariables;
    private String user;
    private String pwd;

    public static final String userDirectoryPath = System.getProperty("user.dir");

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("se autentica de forma exitosa y realiza todo el proceso hasta completar el formulario de datos de la compra")
    public void beSuccessfullyAuthenticatedChooseYourPreferredProductsAndFillOutTheFormWithBasicData() {
        theActorCalled(ACTOR).attemptsTo(
                RandomlySelectCategoryAndProducts.withParams(ADD_TWO_PRODUCTS),
                /*
                   Esta constante ADD_TWO_PRODUCTS es la cantidad de productos que deseemos agregar al carrito
                   este se puede cambiar por la cantidad que deseamos EJ: 1,2,3,4,5... Entre más productos se agreguen
                   este tardara en agregarlos.
                 */
                PurchasingInformationForm.withParams(
                        String.format(
                                STRING_FORMA_THREE_PARAMS,
                                /*
                                 Esta constante STRING_FORMA_THREE_PARAMS nos permitira hacer un mejor formato de cadena
                                reemplaza la concatenación : ( + )
                                parametro1 + parametro2 + parametro3 --- Por comas ( , )
                                parametro1 , parametro2 , parametro3
                                aplicando buenas practicas
                                 */
                                userDirectoryPath,
                                PATH_JSON,
                                NAME_JSON_DATA_INFORMATION))
        );
    }

    @Then("visualizara un mensaje y espera una validacion gracias por su compra")
    public void youWillSeeAMessageAndWaitForValidationThankYouForYourPurchase() {
        theActorInTheSpotlight().should(
                seeThat(ValidateCheckoutComplete.withParams())
        );
    }
}