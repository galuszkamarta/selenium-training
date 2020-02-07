package Litecart.Tests;

import Litecart.app.Application;
import org.junit.Before;

/**
 * Created by m on 2020-01-24.
 */
public class TestBase {
  public static ThreadLocal<Application> tlApp = new ThreadLocal<>();
  public Application app;

  @Before
  public void start() {
    if (tlApp.get() != null) {
      app = tlApp.get();
      return;
    }

    app = new Application();
    tlApp.set(app);

    Runtime.getRuntime().addShutdownHook(
            new Thread(() -> { app.quit(); app = null; }));
  }
}
