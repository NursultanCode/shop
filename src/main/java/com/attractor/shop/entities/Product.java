package com.attractor.shop.entities;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "products")
public class Product extends BaseEntity{
    @NotBlank
    @Size(min = 2,max = 20)
    private String name;
    @Min(0)
    private float cost;
    private byte[] image;
    @Min(0)
    private int count;
    @NotBlank
    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;
}
