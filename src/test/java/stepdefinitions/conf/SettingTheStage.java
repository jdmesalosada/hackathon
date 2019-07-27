package stepdefinitions.conf;

import actors.CastOfUsers;
import cucumber.api.java.Before;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;

public class SettingTheStage {

	/**
	 * The EnvironmentVariables field wraps the system properties and the properties defined in the serenity.properties
	 * file. This is a convenient way to access system or environment properties. Serenity will inject it automatically
	 * into a step definition class.
	 */

	EnvironmentVariables environmentVariables;

	@Before
	public void set_the_stage() {
		setTheStage(new CastOfUsers(environmentVariables));
	}
}
