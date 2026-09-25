package test.accountsalesforce.questions.visibilityvalidator;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class ElementVisibilityValidator implements Question<Boolean>{

    private final Target messageTarget;
    public ElementVisibilityValidator(Target messageTarget){
        this.messageTarget = messageTarget;
    }
    @Override
    public Boolean answeredBy(Actor actor){
        WaitUntil.the(messageTarget, WebElementStateMatchers.isVisible());
        return Visibility.of(messageTarget).asBoolean().answeredBy(actor);  }

    public static ElementVisibilityValidator visiblityElement(Target messageTarget){
        return new ElementVisibilityValidator(messageTarget);
    }

}
