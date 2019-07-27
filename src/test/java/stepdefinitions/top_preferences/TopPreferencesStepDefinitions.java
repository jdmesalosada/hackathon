package stepdefinitions.top_preferences;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import tasks.top_preferences.AskForTheirTopPreferences;
import tasks.top_preferences.ItIsNotAbleToAccess;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class TopPreferencesStepDefinitions {

    @When("^he asks for the top (.*) based on their preferences$")
    public void he_asks_for_the_top_artists_based_on_their_preferences(String filter) {
        theActorInTheSpotlight().attemptsTo(
                AskForTheirTopPreferences.basedOnTheirTaste(filter)
        );
    }

    @Then("^he should see a result that matches with their musical taste$")
    public void he_should_see_a_result_that_matches_with_their_musical_taste() {

    }

    @Then("^he should not be able to see the top preferences$")
    public void should_not_be_able_to_access_to_top_preferences() {
        theActorInTheSpotlight().attemptsTo(
                ItIsNotAbleToAccess.toTheirTopPreferences()
        );
    }
}
