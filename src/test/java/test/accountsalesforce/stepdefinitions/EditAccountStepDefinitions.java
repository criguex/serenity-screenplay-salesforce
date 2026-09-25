package test.accountsalesforce.stepdefinitions;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import test.accountsalesforce.exceptions.Exceptions;
import test.accountsalesforce.questions.textvalidator.ElementTextValidator;
import test.accountsalesforce.questions.visibilityvalidator.ElementVisibilityValidator;
import test.accountsalesforce.task.EditAccountActions;
import test.accountsalesforce.task.HomeActions;
import test.accountsalesforce.task.LoginActions;
import test.accountsalesforce.task.SelectAcccountToEditActions;
import test.accountsalesforce.userinterfaces.AccountPage;
import test.accountsalesforce.utils.assertiondata.DataAssertions;
import test.accountsalesforce.utils.drivers.MyChromeDriver;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static test.accountsalesforce.exceptions.Exceptions.*;
import static test.accountsalesforce.utils.constants.ConstantsManage.ACTOR;
import static test.accountsalesforce.utils.constants.ConstantsManage.URL;




public class EditAccountStepDefinitions {
    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("actor is on dashboard accounts")
    public void actorIsOnDashboardAccounts() {
        theActorCalled(ACTOR);
        theActorInTheSpotlight().can(BrowseTheWeb.with(MyChromeDriver.chromeHisBrowserWeb().onTheUrl(URL)));
        theActorInTheSpotlight().wasAbleTo(LoginActions.login());
        theActorInTheSpotlight().wasAbleTo(HomeActions.home());
    }
    @Given("Click on edit account")
    public void clickOnEditAccount() {
        theActorInTheSpotlight().wasAbleTo(SelectAcccountToEditActions.selectAcccountToEdit());
    }
    @When("The actor edits the form and saves info")
    public void theActorEditsTheFormAndSavesInfo() {
        theActorInTheSpotlight().wasAbleTo(EditAccountActions.editAccount());
        theActorInTheSpotlight().should(
                seeThat(ElementTextValidator.textValidator(AccountPage.TEXT_SUCCESSFUL_EDIT), containsString(DataAssertions.TEXT_OF_SUCCESSFUL_EDIT))
                        .orComplainWith(Exceptions.class, THE_TEXT_DOES_NOT_STRING)
        );
    }
    @Then("the system displays the update info")
    public void theSystemDisplaysTheUpdateInfo() {
        theActorInTheSpotlight().should(
                seeThat(ElementVisibilityValidator.visiblityElement(AccountPage.TEXT_NAME_ACCOUNT_EDITED), equalTo(true))
                        .orComplainWith(Exceptions.class, THE_TEXT_IS_NOT_EQUAL)
        );    }

}

