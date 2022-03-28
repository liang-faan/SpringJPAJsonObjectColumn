package com.lfa.jpa.jsonb.demo.repository;

import com.lfa.jpa.jsonb.demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class ProductRepository extends SimpleJpaRepository<Product, Long> {

    public ProductRepository(JpaEntityInformation<Product, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    public ProductRepository(Class<Product> domainClass, EntityManager em) {
        super(domainClass, em);
    }

    @Autowired
    public ProductRepository(EntityManager em){
        this(Product.class, em);
    }
}
