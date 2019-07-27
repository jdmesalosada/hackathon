package abilities;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;

public class CallLoginApi implements Ability {

    private final String baseURL;

    private CallLoginApi(String baseURL) {
        this.baseURL = baseURL;
    }

    public static CallLoginApi at(String baseURL) {
        return new CallLoginApi(baseURL);
    }

    public static CallLoginApi as(Actor actor) {
        return (CallLoginApi) actor.abilityTo(CallLoginApi.class);
    }

    public String resolve(String resource) {
        return this.baseURL + resource;
    }
}
