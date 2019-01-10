package es.jander.launchpad.spring4.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MathService {

  public MathService() {
    log.info("Created math service");
  }

  public int add(int a, int b) {
    return a + b;
  }

  public int subtract(int a, int b) {
    return a - b;
  }

  public int times(int a, int b) {
    return a * b;
  }

  public int abs(int a) {
    return Math.abs(a);
  }
}
