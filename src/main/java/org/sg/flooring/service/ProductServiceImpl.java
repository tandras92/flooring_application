package org.sg.flooring.service;

import org.sg.flooring.dtos.Product;
import org.sg.flooring.exceptions.MasteryPersistenceException;
import org.sg.flooring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("productServiceImpl")
@Transactional
public class ProductServiceImpl implements ProductService {

//    @Autowired
//    ProductDao productDao;
    @Autowired
ProductRepository productRepository;

    @Override
    public boolean addProduct(Product product) {
        productRepository.save(product);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getProducts() throws MasteryPersistenceException {
        return productRepository.findAll();
    }
}
