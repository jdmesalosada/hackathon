package stepdefinitions.recommendations;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import tasks.recommendations.AskForRecommendations;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RecommendationStepDefinitions {


    @When("^he asks for recommendations about what music to listen$")
    public void he_asks_for_recommendations_about_what_music_to_listen() {
        theActorInTheSpotlight().attemptsTo(
                AskForRecommendations.toListenToMusic()
        );
    }

    @Then("^he should see a list of music recommended based on their musical taste$")
    public void he_should_see_a_list_of_music_recommended_based_on_their_musical_taste() {

    }
}
