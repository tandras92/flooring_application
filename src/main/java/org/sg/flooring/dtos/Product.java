package org.sg.flooring.dtos;

import org.hibernate.validator.constraints.Currency;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;

	@NotNull(message = "{error.null.producttype}")
	@Column(name = "product_type", nullable = false, length = 255)
	private String productType;

	@NotNull(message = "{error.null.costpersquarefoot}")
	@Column(name = "cost_per_square_foot",nullable = false)
	@Currency("USD")
	private BigDecimal costPerSquareFoot;

	@NotNull(message = "{error.null.laborcostpersquarefoot}")
	@Column(name = "labor_cost_per_square_foot", nullable = false)
	@Currency("USD")
	private BigDecimal laborCostPerSquareFoot;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "products")
	private Set<Order> orders = new HashSet<>();

	public Product(String productType, BigDecimal costPerSquareFoot, BigDecimal laborCostPerSquareFoot) {
		this.productType = productType;
		this.costPerSquareFoot = costPerSquareFoot;
		this.laborCostPerSquareFoot = laborCostPerSquareFoot;
	}

	public Product() {

	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public BigDecimal getCostPerSquareFoot() {
		return costPerSquareFoot;
	}

	public void setCostPerSquareFoot(BigDecimal costPerSquareFoot) {
		this.costPerSquareFoot = costPerSquareFoot;
	}

	public BigDecimal getLaborCostPerSquareFoot() {
		return laborCostPerSquareFoot;
	}

	public void setLaborCostPerSquareFoot(BigDecimal laborCostPerSquareFoot) {
		this.laborCostPerSquareFoot = laborCostPerSquareFoot;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Product)) return false;
		Product product = (Product) o;
		return getProductId() == product.getProductId() &&
				getProductType().equals(product.getProductType()) &&
				getCostPerSquareFoot().equals(product.getCostPerSquareFoot()) &&
				getLaborCostPerSquareFoot().equals(product.getLaborCostPerSquareFoot());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getProductId(), getProductType(), getCostPerSquareFoot(), getLaborCostPerSquareFoot());
	}

	@Override
	public String toString() {
		return "Product{" +
				"productId=" + productId +
				", productType='" + productType + '\'' +
				", costPerSquareFoot=" + costPerSquareFoot +
				", laborCostPerSquareFoot=" + laborCostPerSquareFoot +
				'}';
	}
}
