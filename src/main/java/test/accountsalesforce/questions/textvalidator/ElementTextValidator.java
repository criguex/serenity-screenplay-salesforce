package test.accountsalesforce.questions.textvalidator;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class ElementTextValidator implements Question<String> {
    private final Target text;

    public ElementTextValidator(Target text){
        this.text = text;
    }

    @Override
    public String answeredBy(Actor actor){
        WaitUntil.the(text, WebElementStateMatchers.isVisible());
        return BrowseTheWeb.as(actor).find(text).getText();
    }

    public static ElementTextValidator textValidator(Target text){
        return new ElementTextValidator(text);
    }
}
