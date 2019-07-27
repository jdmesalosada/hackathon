package tasks.common;

import io.restassured.http.Header;
import model.api.SessionVariables;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class GetAuthToken {
    private static final String AUTHORIZATION = "Authorization";
    private static final String BEARER = "Bearer ";

    public static Header ofUserInScene() {
        return new Header(AUTHORIZATION,
                BEARER + getToken());
    }

    private static String getToken() {
        String token = theActorInTheSpotlight().recall(SessionVariables.AUTHORIZATION_TOKEN.toString());
        if (token == null) {
            throw new NullPointerException("El token esta nulo, ya iniciaste sesion?");
        }
        return token;
    }
}
