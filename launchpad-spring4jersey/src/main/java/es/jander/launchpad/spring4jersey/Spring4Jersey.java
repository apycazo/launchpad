package es.jander.launchpad.spring4jersey;

import es.jander.launchpad.spring4jersey.etc.ConfigureJersey;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import static org.eclipse.jetty.servlet.ServletContextHandler.NO_SESSIONS;

@Slf4j
public class Spring4Jersey {

  public static void main(String[] args) {
    Server server = configureServer(9000);
    try {
      server.start();
      server.join();
    } catch (Exception ex) {
      log.error("Error occurred while starting Jetty", ex);
      System.exit(1);
    }

    finally {
      server.destroy();
    }
  }

  public static Server configureServer (int port) {
    Server server = new Server(port);

    ServletContextHandler servletContextHandler = new ServletContextHandler(NO_SESSIONS);

    servletContextHandler.setContextPath("/");
    server.setHandler(servletContextHandler);

    // using resource config
    ServletHolder servletHolder = new ServletHolder(new ServletContainer(new ConfigureJersey()));
    servletHolder.setInitOrder(0);
    servletContextHandler.addServlet(servletHolder, "/*");

    // without resource config
    // ServletHolder servletHolder = servletContextHandler.addServlet(ServletContainer.class, "/*");
    // servletHolder.setInitOrder(0);
    // servletHolder.setInitParameter("jersey.config.server.provider.packages","es.jander.codex.rest");

    // add spring support
    AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
    context.setConfigLocation(Spring4Jersey.class.getPackage().getName());
    servletContextHandler.addEventListener(new ContextLoaderListener(context));

    return server;
  }

}
