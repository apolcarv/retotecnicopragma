package co.com.pragma.project.stepdefinition;

import co.com.pragma.project.questions.ValidateCheckoutIncomplete;
import co.com.pragma.project.tasks.PurchasingIncompleteForm;
import co.com.pragma.project.tasks.RandomlySelectCategoryAndProducts;
import co.com.pragma.project.tasks.YourCart;
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

public class CheckoutIncompleteStep {

    private static EnvironmentVariables environmentVariables;
    private String user;
    private String pwd;

    public static final String userDirectoryPath = System.getProperty("user.dir");

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("se autentica de forma exitosa y realiza el proceso incompleto el formulario de datos de la compra")
    public void successfullyAuthenticatesAndPerformsTheIncompleteProcessThePurchaseDataFor() {
        theActorCalled(ACTOR).attemptsTo(
                RandomlySelectCategoryAndProducts.withParams(ADD_ONE_PRODUCTS),
                YourCart.access(),
                PurchasingIncompleteForm.withParams(
                        String.format(
                                STRING_FORMA_THREE_PARAMS,
                                userDirectoryPath,
                                PATH_JSON,
                                NAME_JSON_DATA_INFORMATION))
        );
    }

    @Then("visualizara un mensaje del formulario incompleto")
    public void willDisplayAnIncompleteFormMessage() {
        theActorInTheSpotlight().should(
                seeThat(
                        ValidateCheckoutIncomplete.withParams(
                                ERROR_MESSAGE_TEXT_ALERT_FILL_FORM))
        );
    }
}