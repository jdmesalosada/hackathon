package questions.login;

import model.api.LoginResponse;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;
import util.environment.ResponseUtil;

public class TheLoginResponse
{
    public static Question<LoginResponse> get() {
        return actor -> ResponseUtil.getModelFromResponse(SerenityRest.lastResponse().asString(), LoginResponse.class);
    }
}
