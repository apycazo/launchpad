package es.jander.launchpad.spring4conditional.app;

import es.jander.launchpad.spring4conditional.RequiredProperty;
import org.springframework.stereotype.Component;

// requires the property to exist and be set to 'true'.
@Component
@RequiredProperty(key = "enabled.no", value = "true")
public class Bean2 extends GenericBean {
  // content on generic bean
}
