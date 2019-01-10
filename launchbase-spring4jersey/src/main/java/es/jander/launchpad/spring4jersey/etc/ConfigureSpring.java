package es.jander.launchpad.spring4jersey.etc;

import es.jander.launchpad.spring4jersey.Spring4Jersey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Slf4j
@Configuration
@ComponentScan(basePackageClasses = Spring4Jersey.class)
public class ConfigureSpring {

  public static final Resource[] resourceLocations = {
    new ClassPathResource("app.properties"),
    new ClassPathResource("app.yml"),
    new ClassPathResource("application.properties"),
    new ClassPathResource("application.yml"),
    new ClassPathResource("application-prod.properties"),
    new ClassPathResource("application-prod.yml"),
    new ClassPathResource("application-dev.properties"),
    new ClassPathResource("application-dev.yml"),
  };

  @Bean
  public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer () {
    PropertySourcesPlaceholderConfigurer ppc = new PropertySourcesPlaceholderConfigurer();
    ppc.setLocations(resourceLocations);
    ppc.setIgnoreResourceNotFound(true);
    return ppc;
  }
}

