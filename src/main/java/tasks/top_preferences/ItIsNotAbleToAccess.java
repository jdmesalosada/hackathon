package tasks.top_preferences;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import org.apache.http.HttpStatus;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.hamcrest.CoreMatchers.equalTo;

public class ItIsNotAbleToAccess implements Task {

    public static Performable toTheirTopPreferences(){
        return instrumented(ItIsNotAbleToAccess.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.should(
                seeThat("", act -> SerenityRest.lastResponse().statusCode(), equalTo(HttpStatus.SC_FORBIDDEN))
        );
    }
}
