package co.com.pragma.project.stepdefinition;

import co.com.pragma.project.questions.ValidateErrorCredentials;
import co.com.pragma.project.tasks.Login;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.util.EnvironmentVariables;
import org.hamcrest.Matchers;

import static co.com.pragma.project.utils.Constant.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AuthenticationStep {

    private static EnvironmentVariables environmentVariables;
    private String user;
    private String pwd;


    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("ingresa las credenciales")
    public void enterTheCredentials() {
        /*
        Las variables user y pwd se almacenara las credenciales que estan guardadas en el archivo serenity.conf
        Esto se hace con el fin de no exponerlas claramente, el datos viene en encode base 64, dando robustes a la
        codificación, para este proyecto puntual, ya que esto puede ser almacenada en un servicio de parameterStore AWS
        O tambien dentro de  las variables del sistema, eso depende del gobierno de calidad que tenga el cliente
        */
        user = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(USER_NAME);
        pwd = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(PWD);
        theActorCalled(ACTOR).attemptsTo(
                Login.authentication(user, pwd)
        );
    }

    @When("ingresa las credenciales incorrectas")
    public void entertheincorrectcredentials() {
        user = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(USER_NAME);
        pwd = "";
        theActorCalled(ACTOR).attemptsTo(
                Login.authentication(user,pwd)
        );
    }

    @Then("visualizara el home y espera una validacion")
    public void itWillDisplayTheHomeAndWaitForAValidation() {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        TheWebPage.title(),
                        Matchers.containsString(TITLE_WEBSITE)
                )
        );
    }

    @Then("visualizara un mensaje de error")
    public void willDisplayAnErrorMessage() {
        theActorInTheSpotlight().should(
                seeThat(ValidateErrorCredentials.faild(ERROR_MESSAGE_TEXT))
        );
    }
}