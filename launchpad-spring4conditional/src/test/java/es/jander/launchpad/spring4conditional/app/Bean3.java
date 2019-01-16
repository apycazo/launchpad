package es.jander.launchpad.spring4conditional.app;

import es.jander.launchpad.spring4conditional.RequiredBean;
import es.jander.launchpad.spring4conditional.RequiredProperty;
import org.springframework.stereotype.Component;

// requires the property to exist and be set to 'true'.
@Component
@RequiredBean(beanClass = Bean1.class)
public class Bean3 extends GenericBean {
  // content on generic bean
}
