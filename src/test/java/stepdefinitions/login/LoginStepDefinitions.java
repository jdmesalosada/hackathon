package stepdefinitions.login;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.api.AppUser;
import model.api.SessionVariables;
import tasks.login.SendTheirCredentials;
import tasks.login.ValidateLoginResponse;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginStepDefinitions {

    @When("^he sends their credentials$")
    public void he_sends_their_credentials() {
        AppUser appUser = theActorInTheSpotlight().recall(SessionVariables.APP_USER.toString());

        theActorInTheSpotlight().attemptsTo(
                SendTheirCredentials.toLogIn(appUser.getCredentials())
        );
    }

    @Then("^he should be able to access to their favorite music$")
    public void should_be_able_to_access_to_their_favorite_music() {
        theActorInTheSpotlight().attemptsTo(ValidateLoginResponse.hasExpectedInfo());
    }

}
