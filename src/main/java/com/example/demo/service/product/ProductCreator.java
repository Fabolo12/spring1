package com.example.demo.service.product;

import com.example.demo.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductCreator {
    public Product create(String name, int price, String description) {
        final Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        return product;
    }
}
