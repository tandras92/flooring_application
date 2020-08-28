package org.sg.flooring.dtos;//package org.sg.flooring.dtos;
//
//
//import org.sg.flooring.validation.DateValidator;
//import org.springframework.format.annotation.DateTimeFormat;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.HashSet;
//import java.util.Objects;
//import java.util.Set;
//
//
//public class OrderEntity {
//
//
//    private long orderId;
//
//
//    private LocalDate date;
//
//
//    private Customer customer;
//
//
//    private String state;
//
//
//    private BigDecimal taxRate;
//
//
//    private String productType;
//
//
//    private double area;
//
//
//    private BigDecimal costPerSquareFt;
//
//
//    private BigDecimal laborCostPerSquareFoot;
//
//
//    private BigDecimal materialCost;
//
//
//    private BigDecimal laborCost;
//
//
//    private BigDecimal tax;
//
//
//    private BigDecimal total;
//
//
//    private Set<ProductEntity> products = new HashSet<>(0);
//}
