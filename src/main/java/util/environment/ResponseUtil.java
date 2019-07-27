package util.environment;

import com.google.gson.Gson;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.CoreMatchers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;

public class ResponseUtil {

    private static Gson gson = new Gson();

    private ResponseUtil() {
    }

    public static String getResponseMessage() {
        return getResponse().extract().response().asString();
    }

    public static int getStatusCode() {
        return getResponse().extract().statusCode();
    }

    public static ValidatableResponse getResponse() {
        return SerenityRest.then();
    }

    public static String getContentType() {
        return getResponse().extract().header("Content-Type");
    }

    public static String getResponseAsString() {
        Response response;
        try {
            response = SerenityRest.then().extract().response();
        } catch (IllegalStateException exc) {
            throw new IllegalStateException("La respuesta recibida no es la esperada por lo cual no puede ser convertida al modelo.");
        }
        assertThat("La respuesta es nula.", response,
                is(CoreMatchers.notNullValue()));
        assertThat("La respuesta es vacia.", response.asString(),
                not(isEmptyOrNullString()));
        return response.asString();
    }

    public static <T> T getModelFromResponse(Class<T> clazz) {
        return getModelFromResponse(ResponseUtil.getResponseAsString(), clazz);
    }

    public static <T> T getModelFromResponse(String jsonMessage, Class<T> clazz) {
        return getModelFromStringMessage(jsonMessage, clazz);
    }

    private static <T> T getModelFromStringMessage(String jsonMessage, Class<T> clazz) {
        Object model;
        try {
            //log.info("***** Service response *******: " + jsonMessage);
            model = gson.fromJson(jsonMessage, clazz);
        } catch (Exception exc) {
            throw new IllegalStateException("La respuesta : " + jsonMessage
                    + " no puede ser convertida al modelo. Mensaje de error: " + exc.getMessage());
        }
        return (T) model;
    }
}
