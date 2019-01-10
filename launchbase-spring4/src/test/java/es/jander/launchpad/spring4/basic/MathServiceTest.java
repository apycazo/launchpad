package es.jander.launchpad.spring4.basic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MathService.class })
public class MathServiceTest {

  @Autowired private MathService mathService;

  @Test
  public void add() {
    assertThat(mathService.add(5,4)).isEqualTo(9);
    assertThat(mathService.add(5,-4)).isEqualTo(1);
    assertThat(mathService.add(-5,-4)).isEqualTo(-9);
    assertThat(mathService.add(-5,4)).isEqualTo(-1);
  }

  @Test
  public void subtract() {
    assertThat(mathService.subtract(5,4)).isEqualTo(1);
    assertThat(mathService.subtract(5,-4)).isEqualTo(9);
    assertThat(mathService.subtract(-5,-4)).isEqualTo(-1);
    assertThat(mathService.subtract(-5,4)).isEqualTo(-9);
  }

  @Test
  public void times() {
    assertThat(mathService.times(5,4)).isEqualTo(20);
    assertThat(mathService.times(5,0)).isEqualTo(0);
    assertThat(mathService.times(0,5)).isEqualTo(0);
    assertThat(mathService.times(0,0)).isEqualTo(0);
    assertThat(mathService.times(-5,4)).isEqualTo(-20);
    assertThat(mathService.times(5,-4)).isEqualTo(-20);
    assertThat(mathService.times(-5,-4)).isEqualTo(20);
  }

  @Test
  public void abs() {
    assertThat(mathService.abs(-5)).isEqualTo(5);
    assertThat(mathService.abs(5)).isEqualTo(5);
    assertThat(mathService.abs(0)).isEqualTo(0);
    assertThat(mathService.abs(-0)).isEqualTo(0);
  }
}