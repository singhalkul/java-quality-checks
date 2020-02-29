package com.qualitychecks.entity;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;

class CircleTest {

  @ParameterizedTest(name = "Radius {0}, Area is {1}")
  @CsvSource( {"5, 78.5398",
    "25, 1963.4938",
    "7.14, 160.1570"})
  public void shouldCalculateAreaOfRectangle(String radiusStr, String expectedAreaStr) {
    var radius = new BigDecimal(radiusStr);
    var expectedArea = new BigDecimal(expectedAreaStr);

    var actualArea = new Circle(radius).calculateArea();

    assertThat(actualArea, comparesEqualTo(expectedArea));
  }


}
