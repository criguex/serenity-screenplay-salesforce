package test.accountsalesforce.task;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import test.accountsalesforce.userinterfaces.AccountPage;
import test.accountsalesforce.utils.randomdata.RandomData;
import java.util.List;
import static test.accountsalesforce.utils.data.testdata.TestData.*;

public class EditAccountActions implements Task {
    List<WebElementFacade> listSelectType;

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                WaitUntil.the(AccountPage.INPUT_NAME, WebElementStateMatchers.isVisible()),
                Clear.field(AccountPage.INPUT_NAME),
                SendKeys.of(RandomData.getRandomString(NEW_NAME_OF_ACCOUNT)).into(AccountPage.INPUT_NAME),
                Clear.field(AccountPage.INPUT_WEBSITE),
                SendKeys.of(RandomData.getRandomString(TEXT_WEBSITE)).into(AccountPage.INPUT_WEBSITE),
                Clear.field(AccountPage.INPUT_DESCRIPTION),
                SendKeys.of(RandomData.getRandomDescription()).into(AccountPage.INPUT_DESCRIPTION),
                Clear.field(AccountPage.INPUT_PHONE),
                SendKeys.of(RandomData.getRandomString(TEXT_PHONE_EDITED)).into(AccountPage.INPUT_PHONE),
                Clear.field(AccountPage.INPUT_BILLING_ADDRESS_STREET),
                SendKeys.of(RandomData.getRandomString(TEXT_ADDRESS_STREET)).into(AccountPage.INPUT_BILLING_ADDRESS_STREET),
                Clear.field(AccountPage.INPUT_BILLING_CITY),
                SendKeys.of(RandomData.getRandomString(TEXT_CITY)).into(AccountPage.INPUT_BILLING_CITY),
                Clear.field(AccountPage.INPUT_BILLING_PROVINCE),
                SendKeys.of(RandomData.getRandomString(TEXT_PROVINCE)).into(AccountPage.INPUT_BILLING_PROVINCE),
                Clear.field(AccountPage.INPUT_BILLING_POSTALCODE),
                SendKeys.of(RandomData.getRandomString(TEXT_POSTAL_CODE)).into(AccountPage.INPUT_BILLING_POSTALCODE),
                Clear.field(AccountPage.INPUT_BULLING_COUNTRY),
                SendKeys.of(RandomData.getRandomString(TEXT_COUNTRY)).into(AccountPage.INPUT_BULLING_COUNTRY),
                Clear.field(AccountPage.INPUT_SHIPPING_ADDRESS),
                SendKeys.of(RandomData.getRandomString(TEXT_ADDRESS_STREET)).into(AccountPage.INPUT_SHIPPING_ADDRESS),
                Clear.field(AccountPage.INPUT_SHIPPING_CITY),
                SendKeys.of(RandomData.getRandomString(TEXT_CITY)).into(AccountPage.INPUT_SHIPPING_CITY),
                Clear.field(AccountPage.INPUT_SHIPPING_PROVINCE),
                SendKeys.of(RandomData.getRandomString(TEXT_PROVINCE)).into(AccountPage.INPUT_SHIPPING_PROVINCE),
                Clear.field(AccountPage.INPUT_SHIPPING_POSTALCODE),
                SendKeys.of(RandomData.getRandomString(TEXT_POSTAL_CODE)).into(AccountPage.INPUT_SHIPPING_POSTALCODE),
                Clear.field(AccountPage.INPUT_SHIPPING_COUNTRY),
                SendKeys.of(RandomData.getRandomString(TEXT_COUNTRY)).into(AccountPage.INPUT_SHIPPING_COUNTRY),
                Scroll.to(AccountPage.BUTTON_LIST_TYPE_ROLE),
                Click.on(AccountPage.BUTTON_LIST_TYPE_ROLE),
                WaitUntil.the(AccountPage.BUTTON_SELECT_TYPE_ROLE, WebElementStateMatchers.isVisible())
        );

        listSelectType = BrowseTheWeb.as(actor).findAll(AccountPage.BUTTON_SELECT_TYPE_ROLE);
        int randomNumberSelectType = RandomData.getRandomNumber(0, listSelectType.size());

        actor.attemptsTo(
                MoveMouse.to(listSelectType.get(randomNumberSelectType)).then(
                        Click.on(listSelectType.get(randomNumberSelectType)).afterWaitingUntilPresent().afterWaitingUntilEnabled()
                ),Click.on(AccountPage.BUTTON_SAVE_ACCOUNT),
                WaitUntil.the(AccountPage.TEXT_SUCCESSFUL_EDIT, WebElementStateMatchers.isVisible())
        );

    }

    public static EditAccountActions editAccount(){
        return Tasks.instrumented(EditAccountActions.class);
    }
}
