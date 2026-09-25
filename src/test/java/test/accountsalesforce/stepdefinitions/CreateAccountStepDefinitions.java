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
import test.accountsalesforce.task.CreateAccountActions;
import test.accountsalesforce.task.HomeActions;
import test.accountsalesforce.task.LoginActions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static  net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static  net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

import test.accountsalesforce.userinterfaces.SpecificAccountPage;
import test.accountsalesforce.utils.assertiondata.DataAssertions;
import test.accountsalesforce.utils.drivers.MyChromeDriver;

import static test.accountsalesforce.exceptions.Exceptions.*;
import static test.accountsalesforce.utils.constants.ConstantsManage.URL;
import static test.accountsalesforce.utils.constants.ConstantsManage.ACTOR;



public class CreateAccountStepDefinitions {
    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("actor is on the home page")
    public void actorIsOnTheHomePage() {
        theActorCalled(ACTOR);
        theActorInTheSpotlight().can(BrowseTheWeb.with(MyChromeDriver.chromeHisBrowserWeb().onTheUrl(URL)));
        theActorInTheSpotlight().wasAbleTo(LoginActions.login());
    }
    @When("goes to account functionality and click on new")
    public void goesToAccountFunctionalityAndClickOnNew() {
        theActorInTheSpotlight().wasAbleTo(HomeActions.home());
    }

    @When("actor completes form and saves info")
    public void actorCompletesFormAndSavesInfo() {
        theActorInTheSpotlight().wasAbleTo(CreateAccountActions.createAccount());
    }
    @Then("the account is created")
    public void theAccountIsCreated() {
        theActorInTheSpotlight().should(
                seeThat(ElementTextValidator.textValidator(SpecificAccountPage.TEXT_SUCCESSFUL_CREATE), containsString(DataAssertions.TEXT_OF_SUCCESFUL_CREATE)),
                seeThat(ElementVisibilityValidator.visiblityElement(SpecificAccountPage.TEXT_SUCCESSFUL_CREATE), equalTo(true))
                        .orComplainWith(Exceptions.class, THE_ELEMENT_IS_NOT_VISIBLE)
        );
    }
    @Then("the system shows the dashboard of the new account")
    public void theSystemShowsTheDashboardOfTheNewAccount() {
        theActorInTheSpotlight().should(
                seeThat(ElementTextValidator.textValidator(SpecificAccountPage.TEXT_BUTTON_ABOUT), containsString(DataAssertions.TEXT_BUTTON_ABOUT))
                        .orComplainWith(Exceptions.class, THE_TEXT_IS_NOT_EQUAL),
                seeThat(ElementVisibilityValidator.visiblityElement(SpecificAccountPage.DASHBOARD_HORIZONTAL_BAR), equalTo(true))
                        .orComplainWith(Exceptions.class, THE_ELEMENT_IS_NOT_VISIBLE),
                seeThat(ElementVisibilityValidator.visiblityElement(SpecificAccountPage.DASHBOARD_LETF_VERTCAL_BAR), equalTo(true))
                        .orComplainWith(Exceptions.class, THE_ELEMENT_IS_NOT_VISIBLE),
                seeThat(ElementVisibilityValidator.visiblityElement(SpecificAccountPage.DASHBOARD_MAIN_PANEL), equalTo(true))
                        .orComplainWith(Exceptions.class, THE_ELEMENT_IS_NOT_VISIBLE)
        );
    }
}
