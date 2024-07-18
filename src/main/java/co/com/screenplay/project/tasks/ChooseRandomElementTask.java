package co.com.screenplay.project.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.screenplay.project.ui.HomeUI.BTN_ELEMENTS;
import static co.com.screenplay.project.ui.HomeUI.BTN_LIST_ELEMENTS;
import static co.com.screenplay.project.utils.Constans.REMEMBER_TEXT_BTN;
import static co.com.screenplay.project.utils.DataFaker.fackeNumberRageOneAndNine;

@AllArgsConstructor
public class ChooseRandomElementTask implements Task {

    private String numberRandomBtn;

    @Override
    public <T extends Actor> void performAs(T actor) {
        String number = numberRandomBtn;

        actor.attemptsTo(Scroll.to(BTN_ELEMENTS), Click.on(BTN_LIST_ELEMENTS.of(number)));

        String textBtn = BTN_LIST_ELEMENTS.of(number).resolveFor(actor).getText();
        actor.remember(REMEMBER_TEXT_BTN,textBtn);
    }

    public static ChooseRandomElementTask withParams(String numberRandomBtn) {
        return Tasks.instrumented(ChooseRandomElementTask.class, numberRandomBtn);
    }
}
