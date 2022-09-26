package com.example.demo.dto;

import lombok.Value;

import java.time.LocalDate;

@Value
public class ProductDTO {
    String name;
    LocalDate created;
}
