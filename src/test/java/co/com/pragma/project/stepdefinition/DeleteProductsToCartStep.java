package co.com.pragma.project.stepdefinition;

import co.com.pragma.project.questions.ValidateTheDeleteProductToCart;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static co.com.pragma.project.utils.Constant.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DeleteProductsToCartStep {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Then("visualizara la eliminacion de los  productos que fueron agregados anteriormente")
    public void willDisplayTheRemovalOfTheProductsThatWerePreviouslyAdded() {
        theActorInTheSpotlight().should(
                seeThat(ValidateTheDeleteProductToCart.success(ONE))
        );
    }
}
