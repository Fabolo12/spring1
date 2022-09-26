package com.example.demo.mapper;

import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Product;

public final class ProductMapper {
    private ProductMapper() {
    }

    public static ProductDTO mapToNameDateDto(Product product) {
        return new ProductDTO(product.getName(), product.getCreated());
    }
}
