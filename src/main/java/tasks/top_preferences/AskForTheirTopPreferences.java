package tasks.top_preferences;

import endpoints.EndPoints;
import interactions.Get;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import tasks.common.GetAuthToken;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AskForTheirTopPreferences implements Task {

    private final String filter;

    public AskForTheirTopPreferences(String filter) {
        this.filter = filter;
    }

    public static Performable basedOnTheirTaste(String filter) {
        return instrumented(AskForTheirTopPreferences.class, filter);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.toResource(EndPoints.TopPreferences.path()).with(
                        req -> req.pathParam("type", filter)
                                .header(GetAuthToken.ofUserInScene())
                )
        );

    }
}
