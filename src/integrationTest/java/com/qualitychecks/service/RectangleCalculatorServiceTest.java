package com.qualitychecks.service;

import com.qualitychecks.entity.Rectangle;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.TEN;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;

public class RectangleCalculatorServiceTest {

  @Test
  public void calculateAreaOfRectangle() {
    var shape = new Rectangle(TEN, TEN);
    var service = new RectangleCalculatorService();

    var area = service.calculateArea(shape);

    assertThat(area, comparesEqualTo(new BigDecimal("100")));
  }

}
