package com.lfa.jpa.jsonb.demo.repository;

import com.lfa.jpa.jsonb.demo.entity.ProductParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class ProductParameterRepository extends SimpleJpaRepository<ProductParameter, Long> {

    public ProductParameterRepository(JpaEntityInformation<ProductParameter, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    public ProductParameterRepository(Class<ProductParameter> domainClass, EntityManager em) {
        super(domainClass, em);
    }

    @Autowired
    public ProductParameterRepository(EntityManager em){
        this(ProductParameter.class, em);
    }
}
