package org.sg.flooring.dtos.cart;

import org.sg.flooring.dtos.Product;

public class ShoppingCartItem {

    private Product product;
    private int quantity;

    ShoppingCartItem(Product product) {
        this.product = product;
        quantity = 1;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void incrementQuantity() {
        quantity++;
    }

    public void decrementQuantity() {
        quantity--;
    }

    public double getTotal() {
        double amount = 0;
        amount = (this.getQuantity() * product.getCostPerSquareFoot().doubleValue() + product.getLaborCostPerSquareFoot().doubleValue());
        return amount;
    }
}
