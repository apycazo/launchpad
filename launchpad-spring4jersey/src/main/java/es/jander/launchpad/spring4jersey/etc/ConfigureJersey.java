package es.jander.launchpad.spring4jersey.etc;

import es.jander.launchpad.spring4jersey.Spring4Jersey;
import lombok.extern.slf4j.Slf4j;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@Slf4j
@ApplicationPath("/")
public class ConfigureJersey extends ResourceConfig {

  public ConfigureJersey() {
    log.info("Configuring Jersey");
    packages(Spring4Jersey.class.getPackage().getName());
  }
}

