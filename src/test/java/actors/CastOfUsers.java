package actors;

import abilities.CallLoginApi;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.config.RestAssuredConfig;
import io.restassured.parsing.Parser;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import stepdefinitions.conf.TestEnvironment;

import util.environment.EnvironmentDataHandler;

import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;
import static io.restassured.config.RestAssuredConfig.config;

public class CastOfUsers extends Cast {

  private final TestEnvironment testEnvironment;

  public CastOfUsers(EnvironmentVariables environmentVariables) {
    testEnvironment = new TestEnvironment(environmentVariables);
  }

  @Override
  public Actor actorNamed(String actorName, Ability... abilities) {
    SerenityRest.setDefaultConfig(restAssuredConfig());
    SerenityRest.setDefaultParser(Parser.JSON);

    Actor user = super.actorNamed(actorName, abilities);
    SerenityRest.useRelaxedHTTPSValidation();
    user.can(CallAnApi.at(testEnvironment.getRestAPIBaseUrl()));
    user.can(CallLoginApi.at(EnvironmentDataHandler.get().url_get_token()));

    return user;
  }

  private RestAssuredConfig restAssuredConfig() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    return config().objectMapperConfig(
        objectMapperConfig().jackson2ObjectMapperFactory((cls, charset) -> objectMapper));
  }
}
