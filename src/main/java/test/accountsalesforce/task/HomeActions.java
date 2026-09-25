package test.accountsalesforce.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import test.accountsalesforce.userinterfaces.HomePage;

public class HomeActions implements Task {
    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                WaitUntil.the(HomePage.BUTTON_ACCOUNTS, WebElementStateMatchers.isVisible()),
                MoveMouse.to(HomePage.BUTTON_ACCOUNTS),
                Click.on(HomePage.BUTTON_ACCOUNTS)
        );
    }

    public static HomeActions home(){
        return Tasks.instrumented(HomeActions.class);
    }
}
