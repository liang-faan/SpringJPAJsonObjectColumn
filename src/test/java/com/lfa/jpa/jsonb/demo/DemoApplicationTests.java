package com.lfa.jpa.jsonb.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lfa.jpa.jsonb.demo.entity.Product;
import com.lfa.jpa.jsonb.demo.entity.ProductParameter;
import com.lfa.jpa.jsonb.demo.repository.ProductParameterRepository;
import com.lfa.jpa.jsonb.demo.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.OffsetDateTime;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);

	@Autowired
	private ProductParameterRepository productParameterRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void contextLoads() throws JsonProcessingException {
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

		logger.info(objectMapper.writeValueAsString(savedProductParameters));

		Product product = Product.builder().productId("TEST1").productDesc("This is testing product 1")
				.productParameterList(savedProductParameters)
				.createdBy("admin1")
				.startDateTime(OffsetDateTime.now())
				.createDt(OffsetDateTime.now())
				.status("AC")
				.build();
		Product savedProduct = productRepository.save(product);
		logger.info(objectMapper.writeValueAsString(savedProduct));


	}

}
