package es.jander.launchpad.spring4jersey.etc;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource(value = {"classpath:service.properties", "classpath:service.yml"}, ignoreResourceNotFound = true)
public class AppSettings {

  @Value("${app.name:unknown}")
  private String appName;
  @Value("${app.source:unknown}")
  private String source;
}

