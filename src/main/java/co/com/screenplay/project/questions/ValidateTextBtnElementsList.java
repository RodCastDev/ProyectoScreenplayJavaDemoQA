package co.com.screenplay.project.questions;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.screenplay.project.ui.HomeUI.TEXT_RANDOM_NAME_BTN;

@Slf4j
@AllArgsConstructor
public class ValidateTextBtnElementsList implements Question<Boolean> {

    private String validateTextSubElementBtn;
    @Override
    public Boolean answeredBy(Actor actor) {
        boolean result;

        String validateTextBtnHeader = TEXT_RANDOM_NAME_BTN.resolveFor(actor).getText();

        if(validateTextBtnHeader != null && validateTextSubElementBtn.equals(validateTextBtnHeader)){
            log.info(validateTextBtnHeader);
            result = true;
        }else {
            result = false;
        }
        return result;
    }
    public static ValidateTextBtnElementsList withParams (String validateTextSubElementBtn){
        return new ValidateTextBtnElementsList((validateTextSubElementBtn));
    }
}
