package controllers

import play.api.mvc.*
import services.Counter

import javax.inject.*

/**
 * This controller demonstrates how to use dependency injection to
 * bind a component into a controller class. The class creates an
 * `Action` that shows an incrementing count to users.
 */
@Singleton
class ClickController @Inject()(cc: ControllerComponents, counter: Counter)
                               (implicit assetsFinder: AssetsFinder)
  extends AbstractController(cc) {

  def click = Action {
    val count = counter.nextCount().toString
    Ok(views.html.clicks("How many clicks?", count))
  }

}
