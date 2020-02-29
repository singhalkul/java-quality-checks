package com.qualitychecks.service;

import com.qualitychecks.entity.Circle;

import java.math.BigDecimal;

public class CircleCalculatorService {

  public BigDecimal calculateArea(final BigDecimal radius) {
    var shape = new Circle(radius);
    try {
      System.out.println("Calculating area for circle");
      BigDecimal area = shape.calculateArea();
      System.out.println("Calculated area is " + area.toPlainString());
      return area;
    } catch (RuntimeException ex) {
      ex.printStackTrace();
      throw new RuntimeException("Some error occurred");
    }
  }
}
