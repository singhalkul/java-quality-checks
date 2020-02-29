package com.qualitychecks.entity;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;

class RectangleTest {

  @ParameterizedTest(name = "Length {0} * Breadth  {1} = Area {2}")
  @CsvSource( {"5, 4, 20",
    "25, 20, 500",
    "7.14, 9.35, 66.7590"})
  public void shouldCalculateAreaOfRectangle(String lengthStr, String breadthStr, String expectedAreaStr) {
    var length = new BigDecimal(lengthStr);
    var breadth = new BigDecimal(breadthStr);
    var expectedArea = new BigDecimal(expectedAreaStr);

    var actualArea = new Rectangle(length, breadth).calculateArea();

    assertThat(actualArea, comparesEqualTo(expectedArea));
  }

}
