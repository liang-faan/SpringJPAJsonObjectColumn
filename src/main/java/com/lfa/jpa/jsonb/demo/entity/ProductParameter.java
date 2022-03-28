package com.lfa.jpa.jsonb.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Parameter")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ProductParameter extends BaseEntity{
    private String paramName;
    private String paramValue;
}
