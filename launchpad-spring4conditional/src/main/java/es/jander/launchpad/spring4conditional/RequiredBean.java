package es.jander.launchpad.spring4conditional;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Conditional(RequiredPropertyCondition.class)
public @interface RequiredBean {
  Class<?> beanClass();
  boolean isFound() default true;
}
