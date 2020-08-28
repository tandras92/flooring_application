package org.sg.flooring.dtos.products;

import java.math.BigDecimal;

public interface IProduct {
    String productType();
    BigDecimal costPerSquareFt();
    BigDecimal laborCostPerSquareFt();
    String color();
    String pattern();
    String texture();
}
