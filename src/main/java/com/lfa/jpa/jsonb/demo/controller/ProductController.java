package com.lfa.jpa.jsonb.demo.controller;

import com.lfa.jpa.jsonb.demo.entity.Product;
import com.lfa.jpa.jsonb.demo.entity.ProductParameter;
import com.lfa.jpa.jsonb.demo.repository.ProductParameterRepository;
import com.lfa.jpa.jsonb.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductParameterRepository productParameterRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired

    @GetMapping("/createParameter")
    public List<ProductParameter> createProductParameter(){

        ProductParameter productParameter = ProductParameter.builder()
                .paramName("test1")
                .paramValue("test1")
                .createDt(OffsetDateTime.now())
                .updateDt(OffsetDateTime.now())
                .startDateTime(OffsetDateTime.now())
                .createdBy("admin")
                .updatedBy("admin")
                .status("AC")
                .build();

        ProductParameter productParameter2 = ProductParameter.builder()
                .paramName("test2")
                .paramValue("test2")
                .createDt(OffsetDateTime.now())
                .updateDt(OffsetDateTime.now())
                .startDateTime(OffsetDateTime.now())
                .createdBy("admin1")
                .updatedBy("admin1")
                .status("AC")
                .build();

        List<ProductParameter> savedProductParameters = productParameterRepository.saveAll(List.of(productParameter, productParameter2));


        return savedProductParameters;
    }

    @GetMapping("/createProduct")
    public Product createProduct(){

        List<ProductParameter> productParameterList = productParameterRepository.findAll();

        Product product = Product.builder().productId("TEST1").productDesc("This is testing product 1")
                .productParameterList(productParameterList)
                .createdBy("admin1")
                .startDateTime(OffsetDateTime.now())
                .createDt(OffsetDateTime.now())
                .status("AC")
                .build();
        Product savedProduct = productRepository.save(product);

        return savedProduct;
    }
}
