package com.attractor.shop.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
@Entity
@Table(name = "categories")
public class Category extends BaseEntity{
    @Size(min = 2,max = 20)
    @NotBlank
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();
}
