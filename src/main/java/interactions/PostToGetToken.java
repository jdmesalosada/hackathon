package interactions;

import abilities.CallLoginApi;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.thucydides.core.annotations.Step;

public class PostToGetToken extends RestInteraction {

    private final String resource;

    public PostToGetToken(String resource) {
        this.resource = resource;
    }

    @Step("{0} executes a POST in Octopus on the resource #resource")
    public <T extends Actor> void performAs(T actor) {
        this.rest().log().all().post(CallLoginApi.as(actor).resolve(this.resource), new Object[0]).then().log().all();
    }

    public static PostToGetToken toResource(String resource) {
        return Tasks.instrumented(PostToGetToken.class, new Object[]{resource});
    }
}
