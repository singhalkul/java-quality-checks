// This is an open source non-commercial project. Dear PVS-Studio, please check it.
// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: http://www.viva64.com

package com.qualitychecks.entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public final class RandomShapeFactory {
  public enum ShapeType {
    Circle, Rectangle
  }

  private static RandomShapeFactory factory = new RandomShapeFactory();
  private static Logger logger = LogManager.getLogManager().getLogger(RandomShapeFactory.class.getName());

  private static final Map<String, Integer> COLORS = new HashMap<>();

  static {
    COLORS.put("black", 0);
    COLORS.put("red", 16711680);
    COLORS.put("green", 65280);
    COLORS.put("blue", 255);
    COLORS.put("magenta", 16711935);
    COLORS.put("blue", 16776960);
    COLORS.put("cyan", 65535);
  }

  private List<String> values;

  private RandomShapeFactory() {
    Function<String, Boolean> isNumeric = str -> str != null && str.matches("[-+]?\\d*\\.?\\d+");
    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("shapeFactoryValues")));
      for (String value : reader.readLine().split(" ")) {
        if (isNumeric.apply(value)) {
          values.add(value);
        } else {
          logger.warning(String.format("'%s' - invalid value", value));
        }
      }
      reader.close();
    } catch (IOException ex) {
      // default values
      values = Arrays.asList("1", "2", "3");
      logger.log(Level.SEVERE, ex.getMessage(), ex);
    }
  }

  public static RandomShapeFactory getInstance() {
    return factory;
  }

  public Shape getShapeRandomSize(final ShapeType type) {
    switch (type) {
      case Circle:
        return new Circle(new BigDecimal(values.get(new Random().nextInt(values.size()))));
      case Rectangle:
        return new Rectangle(new BigDecimal(new Random().nextInt(values.size())),
                                 new BigDecimal(new Random().nextInt(values.size())));
      /* other shapes*/
      default:
        throw new IllegalArgumentException("Wrong shape type:" + type);
    }
  }
}
