package tasks.login;

import model.api.LoginResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import questions.login.TheLoginResponse;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;

public class ValidateLoginResponse implements Task {

    public static Performable hasExpectedInfo(){
        return instrumented(ValidateLoginResponse.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LoginResponse response = TheLoginResponse.get().answeredBy(actor);

        actor.should(
                seeThat("El token", act -> response.getAccess_token(), not(nullValue()) )
        );
    }
}
