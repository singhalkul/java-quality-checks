package com.qualitychecks.entity;

import java.math.BigDecimal;

public class Rectangle implements Shape {

  public final BigDecimal length;
  public final BigDecimal breadth;

  public Rectangle(BigDecimal length, BigDecimal breadth) {
    this.length = length;
    this.breadth = breadth;
  }

  @Override
  public BigDecimal calculateArea() {
    return length.multiply(breadth);
  }
}
