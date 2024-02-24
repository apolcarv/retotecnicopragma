package co.com.pragma.project.questions;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.annotations.Subject;
import org.openqa.selenium.Alert;

import static co.com.pragma.project.questions.ValidateCheckoutIncomplete.searchAlertRobot;
import static co.com.pragma.project.utils.Constant.TWO;
import static co.com.pragma.project.utils.Time.waiting;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


@AllArgsConstructor
@Slf4j
public class ValidateErrorCredentials implements Question<Boolean> {

    private final String errorText;

    @Override
    @Subject("{0} valida el texto #errorText")
    public Boolean answeredBy(Actor actor) {
        boolean result;
        searchAlertRobot(910,500);
        waiting(TWO);
        Alert alert = BrowseTheWeb.as(theActorInTheSpotlight()).getDriver().switchTo().alert();
        String txtValidate = alert.getText();
        log.info(alert.getText());
        if (txtValidate != null && txtValidate.equals(errorText)) {
            log.info(txtValidate);
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public static ValidateErrorCredentials faild(String errorText) {
        return new ValidateErrorCredentials(errorText);
    }
}