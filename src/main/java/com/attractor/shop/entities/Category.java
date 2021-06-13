package com.attractor.shop.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
@Entity
@Table(name = "categories")
public class Category extends BaseEntity{
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();
}
