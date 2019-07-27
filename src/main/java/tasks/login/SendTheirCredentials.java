package tasks.login;

import endpoints.EndPoints;
import interactions.PostToGetToken;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SendTheirCredentials implements Task {

    private final String credentials;

    public SendTheirCredentials(String credentials) {
        this.credentials = credentials;
    }

    public static Performable toLogIn(String credentials) {
        return instrumented(SendTheirCredentials.class, credentials);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(PostToGetToken.toResource(EndPoints.Login.path()).with(
                req -> req
                        .contentType("application/x-www-form-urlencoded")
                        .header("Authorization", "Basic " + credentials)
                        .formParam("grant_type", "client_credentials").log().all()
        ));
    }
}
