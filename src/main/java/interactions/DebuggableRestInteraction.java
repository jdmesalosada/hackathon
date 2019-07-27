
package interactions;

import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.thucydides.core.util.EnvironmentVariables;


abstract class DebuggableRestInteraction extends RestInteraction {

    private EnvironmentVariables environmentVariables;

    boolean isDebuggable() {
        return environmentVariables.getPropertyAsBoolean("debug.rest.queries", false);
    }
}

