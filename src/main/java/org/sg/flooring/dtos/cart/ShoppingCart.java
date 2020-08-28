package org.sg.flooring.dtos.cart;

import org.sg.flooring.dtos.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    List<ShoppingCartItem> items;
    int quantityOfItems;
    double total;

    public ShoppingCart() {
        items = new ArrayList<>();
        quantityOfItems = 0;
        total = 0;
    }

    public void addItem(Product product) {
        boolean newItem = true;

        for (ShoppingCartItem item : items) {
            if (item.getProduct().getProductId() == product.getProductId()) {
                newItem = false;
                item.incrementQuantity();
            }
        }

        if (newItem) {
            ShoppingCartItem item = new ShoppingCartItem(product);
            items.add(item);
        }
    }

    public void update(Product product, String quantity) {
        int qty = -1;

        qty = Integer.parseInt(quantity);

        if (qty >= 0) {
            ShoppingCartItem item = null;

            for (ShoppingCartItem cartItem : items) {
                if (cartItem.getProduct().getProductId() == product.getProductId()) {
                    if (qty != 0) {
                        cartItem.setQuantity(qty);
                    } else {
                        item = cartItem;
                        break;
                    }

                    if (item != null) {
                        items.remove(item);
                    }
                }
            }
        }
    }

    public List<ShoppingCartItem> getItems() {
        return items;
    }

    public int getQuantityOfItems() {
        quantityOfItems = 0;

        for (ShoppingCartItem cartItem : items) {
            quantityOfItems += cartItem.getQuantity();
        }

        return quantityOfItems;
    }

    public double getSubtotal() {
        double amount = 0;

        for (ShoppingCartItem cartItem : items) {
            Product product = (Product) cartItem.getProduct();
            amount += (cartItem.getQuantity() * product.getLaborCostPerSquareFoot().doubleValue() +
                    product.getCostPerSquareFoot().doubleValue());
        }

        return amount;
    }

    public void calculateTotal(String surcharge) {
        double amount = 0;

        double s = Double.parseDouble(surcharge);
        amount = this.getSubtotal();
        amount += s;

        total = amount;
    }

    public double getTotal() {
        return total;
    }

    public void clear() {
        items.clear();
        quantityOfItems = 0;
        total = 0;
    }
}
