package es.jander.launchpad.spring4jersey.etc;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class AppSettings {

  @Value("${app.name:unknown}")
  private String appName;
}

