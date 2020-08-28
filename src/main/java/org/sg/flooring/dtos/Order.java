package org.sg.flooring.dtos;


import org.sg.flooring.enums.Colors;
import org.sg.flooring.enums.ProductType;
import org.sg.flooring.enums.States;
import org.sg.flooring.validation.DateValidator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long orderId;

    @NotEmpty(message = "{error.empty.date}")
    @NotBlank(message = "{error.blank.date}")
    @NotNull(message = "{error.null.date}")
    @DateValidator
    @DateTimeFormat(pattern = "MM/dd/yyy")
    @Column(name = "created_date")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @NotEmpty(message = "{error.empty.state}")
    @NotBlank(message = "{error.blank.state}")
    @NotNull(message = "{error.null.state}")
    @Column(name = "state")
    private String state;

    @NotEmpty(message = "{error.empty.taxRate}")
    @NotBlank(message = "{error.blank.taxRate}")
    @NotNull(message = "{error.null.taxRate}")
    @Column(name = "tax_rate")
    private BigDecimal taxRate;

    @NotEmpty(message = "{error.empty.productType}")
    @NotBlank(message = "{error.blank.productType}")
    @NotNull(message = "{error.null.productType}")
    @Column(name = "product_type")
    private String productType;

    @NotEmpty(message = "{error.empty.area}")
    @NotBlank(message = "{error.blank.area}")
    @NotNull(message = "{error.null.area}")
    @Column(name = "area")
    private double area;

    @NotEmpty(message = "{error.empty.costPerSquareFoot}")
    @NotBlank(message = "{error.blank.costPerSquareFoot}")
    @NotNull(message = "{error.null.costPerSquareFoot}")
    @Column(name = "cost_per_sqft")
    private BigDecimal costPerSquareFt;

    @NotEmpty(message = "{error.empty.laborCostPerSquareFoot}")
    @NotBlank(message = "{error.blank.laborCostPerSquareFoot}")
    @NotNull(message = "{error.null.laborCostPerSquareFoot}")
    @Column(name = "labor_cost_per_sqft")
    private BigDecimal laborCostPerSquareFoot;

    @NotEmpty(message = "{error.empty.materialCost}")
    @NotBlank(message = "{error.blank.materialCost}")
    @NotNull(message = "{error.null.materialCost}")
    @Column(name = "material_cost")
    private BigDecimal materialCost;

    @NotEmpty(message = "{error.empty.state}")
    @NotBlank(message = "{error.blank.state}")
    @NotNull(message = "{error.null.state}")
    @Column(name = "labor_cost")
    private BigDecimal laborCost;

    @NotEmpty(message = "{error.empty.tax}")
    @NotBlank(message = "{error.blank.tax}")
    @NotNull(message = "{error.null.tax}")
    @Column(name = "tax")
    private BigDecimal tax;

    @NotEmpty(message = "{error.empty.total}")
    @NotBlank(message = "{error.blank.total}")
    @NotNull(message = "{error.null.total}")
    @Column(name = "total")
    private BigDecimal total;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "orders_products",
            joinColumns = { @JoinColumn(name = "order_id", nullable = false, updatable = false)},
            inverseJoinColumns = { @JoinColumn(name = "product_id", nullable = false, updatable = false)}
    )
    private Set<Product> products;

    public Long getOrderId() {
        return orderId;
    }

    public LocalDate getDate() {
        return date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public String getState() {
        return state;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public String getProductType() {
        return productType;
    }

    public double getArea() {
        return area;
    }

    public BigDecimal getCostPerSquareFt() {
        return costPerSquareFt;
    }

    public BigDecimal getLaborCostPerSquareFoot() {
        return laborCostPerSquareFoot;
    }

    public BigDecimal getMaterialCost() {
        return materialCost;
    }

    public BigDecimal getLaborCost() {
        return laborCost;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public BigDecimal getTotal() {
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return getOrderId() == order.getOrderId() &&
                Double.compare(order.getArea(), getArea()) == 0 &&
                Objects.equals(getDate(), order.getDate()) &&
                Objects.equals(getCustomer(), order.getCustomer()) &&
                Objects.equals(getState(), order.getState()) &&
                Objects.equals(getTaxRate(), order.getTaxRate()) &&
                Objects.equals(getProductType(), order.getProductType()) &&
                Objects.equals(getCostPerSquareFt(), order.getCostPerSquareFt()) &&
                Objects.equals(getLaborCostPerSquareFoot(), order.getLaborCostPerSquareFoot()) &&
                Objects.equals(getMaterialCost(), order.getMaterialCost()) &&
                Objects.equals(getLaborCost(), order.getLaborCost()) &&
                Objects.equals(getTax(), order.getTax()) &&
                Objects.equals(getTotal(), order.getTotal()) &&
                Objects.equals(getProducts(), order.getProducts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId(), getDate(), getCustomer(), getState(), getTaxRate(), getProductType(), getArea(), getCostPerSquareFt(), getLaborCostPerSquareFoot(), getMaterialCost(), getLaborCost(), getTax(), getTotal(), getProducts());
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", date=" + date +
                ", customer=" + customer +
                ", state='" + state + '\'' +
                ", taxRate=" + taxRate +
                ", productType='" + productType + '\'' +
                ", area=" + area +
                ", costPerSquareFt=" + costPerSquareFt +
                ", laborCostPerSquareFoot=" + laborCostPerSquareFoot +
                ", materialCost=" + materialCost +
                ", laborCost=" + laborCost +
                ", tax=" + tax +
                ", total=" + total +
                ", products=" + products +
                '}';
    }

    public static class OrderBuilder {
        private Colors color;
        private States stateName;
        private ProductType product;
        private Customer customer;

        private String customerName;

        private long orderId;

        private LocalDate date;

        private String state;

        private BigDecimal taxRate;

        private String productType;

        private double area;

        private BigDecimal costPerSquareFt;

        private BigDecimal laborCostPerSquareFoot;

        private BigDecimal materialCost;

        private BigDecimal laborCost;

        private BigDecimal tax;

        private BigDecimal total;

        private Set<Product> products;

        public OrderBuilder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public OrderBuilder setId(long orderId) {
            this.orderId = orderId;
            return this;
        }

        public OrderBuilder setCustomer(Customer customer, String customerName) {
            this.customer = customer;
            this.customerName = customerName;
            return this;
        }

        public OrderBuilder setState(String state, States stateName) {
            this.stateName = stateName;
            this.state = state;
            return this;
        }

        public OrderBuilder setTaxRate(States stateName, BigDecimal taxRate) {
            this.taxRate = taxRate;
            this.stateName = stateName;
            return this;
        }

        public OrderBuilder setProductType(ProductType product, String productType) {
            this.productType = productType;
            this.product = product;
            return this;
        }

        public OrderBuilder setArea(double area) {
            this.area = area;
            return this;
        }

        public OrderBuilder setCostPerSquareFt(BigDecimal costPerSquareFt) {
            this.costPerSquareFt = costPerSquareFt;
            return this;
        }

        public OrderBuilder setLaborCostPerSquareFt(BigDecimal laborCostPerSquareFoot) {
            this.laborCostPerSquareFoot = laborCostPerSquareFoot;
            return this;
        }

        public OrderBuilder setMaterialCost(BigDecimal materialCost) {
            this.materialCost = materialCost;
            return this;
        }

        public OrderBuilder setLaborCost(BigDecimal laborCost) {
            this.laborCost = laborCost;
            return this;
        }

        public OrderBuilder setTax(BigDecimal tax) {
            this.tax = tax;
            return this;
        }

        public OrderBuilder setTotal(BigDecimal total) {
            this.total = total;
            return this;
        }

        public OrderBuilder setProducts(Set<Product> products) {
            this.products = products;
            return this;
        }

        public Order build() {
            Order order = new Order();
            order.orderId = this.orderId;
            order.date = this.date;
            order.customer = this.customer;
            order.state = this.state;
            order.taxRate = this.taxRate;
            order.productType = this.productType;
            order.area = this.area;
            order.costPerSquareFt = this.costPerSquareFt;
            order.laborCostPerSquareFoot = this.laborCostPerSquareFoot;
            order.materialCost = this.materialCost;
            order.laborCost = this.laborCost;
            order.tax = this.tax;
            order.total = this.total;
            order.products = this.products;

            return order;
        }

    }
}
