package co.com.screenplay.project.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomeUI extends PageObject {

    public static final Target ID_CARD_ELEMENTS = Target.the("Boton elementosHP")
            .located(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[2]"));
    public static final Target BTN_ELEMENTS = Target.the("Boton elementos")
            .located(By.xpath("//div[@class='header-wrapper']//div[contains(text(),'Elements')]"));
    public static final Target BTN_LIST_ELEMENTS = Target.the("boton lista opciones elementos")
            .locatedBy("//div[@class='accordion']//div[@class='element-group'][1]//li[@id='item-{0}']");
    public static final Target TEXT_RANDOM_NAME_BTN = Target.the("texto random, del nombre de los botones")
            .located(By.xpath("//h1[@class='text-center']"));

}
