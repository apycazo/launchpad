package es.jander.launchpad.spring4.behavior;

import es.jander.launchpad.spring4.Spring4;
import es.jander.launchpad.spring4.basic.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = { Spring4.class })
public class SpringTestConfig {

  @Autowired MathService mathService;
}
