package com.qualitychecks.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Circle implements Shape {

  public static final BigDecimal PI = new BigDecimal("3.14159");
  public final BigDecimal radius;

  public Circle(BigDecimal radius) {
    this.radius = radius;
  }

  @Override
  public BigDecimal calculateArea() {
    return radius.pow(2).multiply(PI).setScale(4, RoundingMode.HALF_UP);
  }
}
