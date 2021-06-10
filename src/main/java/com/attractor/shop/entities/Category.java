package com.attractor.shop.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;
@Data
@Entity
@Table(name = "categories")
public class Category extends BaseEntity{
    private String name;
    private Set<Product> products;
}
