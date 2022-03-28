package com.lfa.jpa.jsonb.demo.entity;

import com.lfa.jpa.jsonb.demo.converter.ProductParameterConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "Product")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity{
    private String productId;
    private String productDesc;


    @Column(columnDefinition = "json", name = "product_parameter")
    @Convert(converter = ProductParameterConverter.class)
    private List<ProductParameter> productParameterList;

}
