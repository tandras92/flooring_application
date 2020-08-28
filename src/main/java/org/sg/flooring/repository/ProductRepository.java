package org.sg.flooring.repository;

import org.sg.flooring.dtos.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    void findProductByProductId(long productId);
}
