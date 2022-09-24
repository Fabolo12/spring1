package com.example.demo.service.product;

import com.example.demo.model.Product;

public abstract class ProductValidator {
    private ProductValidator() {
    }

    public static void checkProduct(final Product product) {
        final String description = product.getDescription();
        if (description != null && Character.isLowerCase(description.charAt(0))) {
            throw new IllegalArgumentException("Invalid description: " + description);
        }
    }
}
