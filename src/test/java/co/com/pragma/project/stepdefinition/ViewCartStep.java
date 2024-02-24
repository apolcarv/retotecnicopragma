package co.com.pragma.project.stepdefinition;

import co.com.pragma.project.questions.ValidateTheProductToCart;
import co.com.pragma.project.tasks.RandomlySelectCategoryAndProducts;
import co.com.pragma.project.tasks.YourCart;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static co.com.pragma.project.utils.Constant.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ViewCartStep {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("se autentica de forma exitosa y va hasta el carrito de compras")
    public void isSuccessfullyAuthenticatedAndGoesToTheShoppingCart() {
        theActorCalled(ACTOR).attemptsTo(
                RandomlySelectCategoryAndProducts.withParams(ADD_ONE_PRODUCTS),
                YourCart.access()
        );
    }

    @Then("visualizara los productos que anteriormente agrego")
    public void willDisplayTheProductsYouPreviouslyAdded() {
        theActorInTheSpotlight().should(
                seeThat(ValidateTheProductToCart.success(ONE))
        );
    }
}