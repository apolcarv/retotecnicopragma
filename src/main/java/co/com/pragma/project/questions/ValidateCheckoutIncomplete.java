package co.com.pragma.project.questions;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.annotations.Subject;
import org.openqa.selenium.Alert;

import java.awt.*;
import java.awt.event.InputEvent;

import static co.com.pragma.project.ui.ProductUI.BUTTON_PURCHASE;
import static co.com.pragma.project.utils.Constant.TIME_SHORT;
import static co.com.pragma.project.utils.Time.waiting;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

@AllArgsConstructor
@Slf4j
public class ValidateCheckoutIncomplete implements Question<Boolean> {

    private final String errorText;

    @Override
    @Subject("{0} valida la alerta de error #errorText")
    public Boolean answeredBy(Actor actor) {
        boolean result;
        waiting(TIME_SHORT);
        actor.attemptsTo(Scroll.to(BUTTON_PURCHASE));
        searchAlertRobot(910,750);
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

    public static ValidateCheckoutIncomplete withParams(String errorText) {
        return new ValidateCheckoutIncomplete(errorText);
    }

    public static void searchAlertRobot(int x, int y){
        try {
            Robot robot = new Robot();
            robot.mouseMove(x, y);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        } catch (AWTException e) {
            log.error(String.valueOf(e));
        }
    }
}