package com.qualitychecks.service;

import com.qualitychecks.entity.Shape;

import java.math.BigDecimal;

public class RectangleCalculatorService {

  public BigDecimal calculateArea(final Shape shape) {
    try {
      System.out.println("Calculating area for rectangle");
      BigDecimal area = shape.calculateArea();
      System.out.println("Calculated area is " + area.toPlainString());
      return area;
    } catch (RuntimeException ex) {
      ex.printStackTrace();
      throw new RuntimeException("Some error occurred");
    }
  }
}
