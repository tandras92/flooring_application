package org.sg.flooring.service;

import org.sg.flooring.dtos.Product;
import org.sg.flooring.exceptions.MasteryPersistenceException;

import java.util.List;

public interface ProductService {

    boolean addProduct(Product product);

    List<Product> getProducts() throws MasteryPersistenceException;

}
