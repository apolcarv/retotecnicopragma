package co.com.pragma.project.utils;


import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

@Slf4j
public class Alert implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            org.openqa.selenium.Alert alert = BrowseTheWeb.as(theActorInTheSpotlight()).getDriver().switchTo().alert();
            log.info(alert.getText());
            alert.accept();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Alert isPresent() {
        return new Alert();
    }
}