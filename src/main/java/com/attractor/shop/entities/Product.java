package com.attractor.shop.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "products")
public class Product extends BaseEntity{
    private String name;
    private float cost;
    private byte[] image;
    private int count;
    private String description;
    private Category category;
}
