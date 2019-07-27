package tasks.login;

import model.api.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import questions.login.TheLoginResponse;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SendTheirCredentialsAndRemember implements Task {

    private final String credentials;

    public SendTheirCredentialsAndRemember(String credentials) {
        this.credentials = credentials;
    }

    public static Performable toContinueManagingTheirAccount(String credentials) {
        return instrumented(SendTheirCredentialsAndRemember.class, credentials);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SendTheirCredentials.toLogIn(credentials)
        );

        actor.remember(SessionVariables.AUTHORIZATION_TOKEN.toString(), TheLoginResponse.get().answeredBy(actor).getAccess_token());
    }
}
