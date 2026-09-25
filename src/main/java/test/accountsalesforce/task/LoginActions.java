package test.accountsalesforce.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.conditions.Check;
import test.accountsalesforce.userinterfaces.LoginPage;

import static test.accountsalesforce.utils.data.logindata.LoginData.*;

public class LoginActions implements Task{
    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                Check.whether(LoginPage.INPUT_USERNAME.resolveFor(actor).isVisible()).andIfSo(
                        SendKeys.of(USERNAME_CORRECT).into(LoginPage.INPUT_USERNAME),
                        SendKeys.of(PASSWORD_CORRECT).into(LoginPage.INPUT_PASSWORD),
                        Click.on(LoginPage.BUTTON_LOGIN)
                )
        );
    }
    public static LoginActions login(){
        return  Tasks.instrumented(LoginActions.class);
    }

}
