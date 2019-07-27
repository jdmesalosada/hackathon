

package interactions;

import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class Get extends DebuggableRestInteraction {

  private final String resource;

  public Get(String resource) {
    this.resource = resource;
  }

  @Step("{0} executes a GET on the resource #resource")
  @Override
  public <T extends Actor> void performAs(T actor) {
    if (isDebuggable()) {
      rest().log().all().get(as(actor).resolve(resource)).then().log().all();
    } else {
      rest().get(as(actor).resolve(resource));
    }
  }

  public static Get toResource(String resource) {
    return instrumented(Get.class, resource);
  }
}

