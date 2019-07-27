package stepdefinitions.conf;

import net.thucydides.core.util.EnvironmentVariables;
import util.environment.EnvironmentDataHandler;

public class TestEnvironment {
    // Automatically injected by Serenity
    private EnvironmentVariables environmentVariables;

    public TestEnvironment(EnvironmentVariables environmentVariables) {
        if (System.getProperty("env") == null) {
            throw new IllegalArgumentException("You have to define the env variable with any of these values: local, dev or uat");
        }
        this.environmentVariables = environmentVariables;
    }

    //Todo: Verificar como traer un perfil especifico para traer la url de acuerdo al ambiente.
    public String getRestAPIBaseUrl() {
        return EnvironmentDataHandler.get().url();
    }
}
