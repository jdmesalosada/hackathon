package tasks.recommendations;

import endpoints.EndPoints;
import interactions.Get;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import tasks.common.GetAuthToken;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AskForRecommendations implements Task {

    public static Performable toListenToMusic(){
        return instrumented(AskForRecommendations.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        RestAssured.baseURI = "https://api.spotify.com";

        actor.attemptsTo(
                Get.toResource(EndPoints.Recommendations.path()).with(
                        req -> req.header(GetAuthToken.ofUserInScene())
                        .contentType(ContentType.JSON)
                )

        );

        String response = SerenityRest.lastResponse().asString();

    }
}
