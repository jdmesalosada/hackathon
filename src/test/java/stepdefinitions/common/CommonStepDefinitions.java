package stepdefinitions.common;

import cucumber.api.java.en.Given;
import model.api.AppUser;
import model.api.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import tasks.login.SendTheirCredentialsAndRemember;
import util.environment.EnvironmentDataHandler;
import util.environment.ResponseUtil;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CommonStepDefinitions {

    private AppUser appUser;
    Actor sergey;

    @Given("^he is logged$")
    public void he_is_logged() {
        AppUser appUser = theActorInTheSpotlight().recall(SessionVariables.APP_USER.toString());

        theActorInTheSpotlight().attemptsTo(
                SendTheirCredentialsAndRemember.toContinueManagingTheirAccount(appUser.getCredentials())
        );

    }

    @Given("^Sergey is a registered user$")
    public void sergey_is_a_registered_user() {
        appUser = ResponseUtil.getModelFromResponse(EnvironmentDataHandler.get().sergey(), AppUser.class);
        sergey = OnStage.theActorCalled("Sergey");
        sergey.remember(SessionVariables.APP_USER.toString(), appUser);
    }
}
