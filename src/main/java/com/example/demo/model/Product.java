package com.example.demo.model;

import com.example.demo.service.product.ProductValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @NotBlank
    private String name;

    @Min(500)
    @Max(10000)
    private int price;

    private String description;

    @PrePersist
    public void prePersist() {
        ProductValidator.checkProduct(this);
    }

    @PreUpdate
    public void preUpdate() {
        ProductValidator.checkProduct(this);
    }
}
