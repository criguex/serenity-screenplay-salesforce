package test.accountsalesforce.task;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import test.accountsalesforce.userinterfaces.AccountPage;
import test.accountsalesforce.utils.randomdata.RandomData;

import java.util.List;

public class SelectAcccountToEditActions implements Task {
    List<WebElementFacade> listOptionsAccount;
    @Override
    public <T extends Actor> void performAs(T actor){
        listOptionsAccount = BrowseTheWeb.as(actor).findAll(AccountPage.BUTTON_OPTIONS_ACCOUNT);
        int randomNumberForOptionsAccount = RandomData.getRandomNumber(0, listOptionsAccount.size());

        actor.attemptsTo(
                WaitUntil.the(AccountPage.BUTTON_OPTIONS_ACCOUNT, WebElementStateMatchers.isVisible()),
                Click.on(listOptionsAccount.get(randomNumberForOptionsAccount)).afterWaitingUntilEnabled(),
                Click.on(AccountPage.BUTTON_EDIT_ACCOUNT)
        );
    }
    public static SelectAcccountToEditActions selectAcccountToEdit(){
        return Tasks.instrumented(SelectAcccountToEditActions.class);
    }
}
