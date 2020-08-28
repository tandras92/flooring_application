package org.sg.flooring.dtos.products.laminate;

import org.sg.flooring.dtos.products.IProduct;

import java.math.BigDecimal;

public abstract class Laminate implements IProduct {

  @Override
  public abstract String color();

  @Override
  public abstract String pattern();

  @Override
  public abstract String texture();

  @Override
  public abstract BigDecimal costPerSquareFt();

  @Override
  public abstract BigDecimal laborCostPerSquareFt();
}
