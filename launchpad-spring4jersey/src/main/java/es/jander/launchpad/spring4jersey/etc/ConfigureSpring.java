package es.jander.launchpad.spring4jersey.etc;

import es.jander.launchpad.spring4jersey.Spring4Jersey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.YamlProcessor;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.Arrays;

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
    Resource firstMatch = Arrays.stream(resourceLocations).filter(Resource::exists).findFirst().orElse(null);
    if (firstMatch != null ) {
      Resource [] resources = Arrays.stream(resourceLocations).filter(Resource::exists).toArray(Resource[]::new);
      if (firstMatch.getFilename().endsWith(".properties")) {
        // load resources as properties
        ppc.setIgnoreResourceNotFound(true);
        ppc.setLocations(resourceLocations);
        ppc.setIgnoreResourceNotFound(true);
      } else {
        // load resources as yaml
        YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
        factory.setResolutionMethod(YamlProcessor.ResolutionMethod.OVERRIDE);
        factory.setResources(resources);
        factory.setSingleton(true);
        factory.afterPropertiesSet();
        ppc.setProperties(factory.getObject());
      }
    }

    return ppc;
  }
}

