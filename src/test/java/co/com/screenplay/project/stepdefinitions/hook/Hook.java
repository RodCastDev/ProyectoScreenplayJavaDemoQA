package co.com.screenplay.project.stepdefinitions.hook;

import co.com.screenplay.project.hook.OpenWeb;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import org.hamcrest.Matchers;



import static co.com.screenplay.project.utils.Constans.TIIME_SHORT;
import static co.com.screenplay.project.utils.Constans.TITLE;
import static co.com.screenplay.project.utils.Time.waiting;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Hook {

    @Before
    public void SetTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{string} abre el sitio web de pruebas")
    public void openTheTestWebsite(String actor ) {
        OnStage.theActorCalled(actor).attemptsTo(
                OpenWeb.browserURL()
        );
        waiting(TIIME_SHORT);
        theActorInTheSpotlight().should(seeThat(TheWebPage.title(), Matchers.containsString(TITLE))
        );
    }
}
