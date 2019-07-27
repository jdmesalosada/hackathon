
package interactions;

import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class Post extends DebuggableRestInteraction {

  private final String resource;

  public Post(String resource) {
    this.resource = resource;
  }

  @Step("{0} executes a Post on the resource #resource")
  @Override
  public <T extends Actor> void performAs(T actor) {
    if (isDebuggable()) {
      rest().log().all().post(as(actor).resolve(resource)).then().log().all();
    } else {
      rest().post(as(actor).resolve(resource));
    }
  }

  public static Post toResource(String resource) {
    return instrumented(Post.class, resource);
  }
}

