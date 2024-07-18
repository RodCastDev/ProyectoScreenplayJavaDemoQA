package co.com.screenplay.project.stepdefinitions;

import co.com.screenplay.project.questions.ValidateTextBtnElementsList;
import co.com.screenplay.project.tasks.ChooseRandomElementTask;
import co.com.screenplay.project.tasks.FuntionsElementsTask;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.Before;

import static co.com.screenplay.project.utils.Constans.REMEMBER_TEXT_BTN;
import static co.com.screenplay.project.utils.DataFaker.fackeNumberRageOneAndNine;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class OpenWebStepDef {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @And("desea validar la funcion de la carta elementos")
    public void wantValidateTheFunctionOfTheLetterElements() {
        theActorInTheSpotlight().attemptsTo(
                FuntionsElementsTask.chooseElement()
        );
    }

    @When("selecciona aleatoreamente alguna de las subfunciones")
    public void voidRandomlySelectsSomeOfTheSubfunctions() {
        theActorInTheSpotlight().attemptsTo(
                ChooseRandomElementTask.withParams(fackeNumberRageOneAndNine())
        );
    }

    @Then("vizualizara en la cabecera el nombre de la opcion elegida")
    public void ItWillDisplayInTheHeaderTheNameOfTheChosenOption() {

        String validateText = theActorInTheSpotlight().recall(REMEMBER_TEXT_BTN);

        theActorInTheSpotlight().should(seeThat(
                ValidateTextBtnElementsList.withParams(validateText)));
    }
}
