package filters

import play.api.mvc.*

import javax.inject.*
import scala.concurrent.ExecutionContext

/**
 * This is a simple filter that adds a header to all requests. It's
 * added to the application's list of filters.
 *
 * @param ec This class is needed to execute code asynchronously.
 * It is used below by the `map` method.
 */
@Singleton
class ExampleFilter @Inject()(implicit ec: ExecutionContext) extends EssentialFilter {
  override def apply(next: EssentialAction) = EssentialAction { request =>
    next(request).map { result =>
      result.withHeaders("X-ExampleFilter" -> "foo")
    }
  }
}