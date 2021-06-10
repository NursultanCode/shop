package com.attractor.shop.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
@Entity
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
