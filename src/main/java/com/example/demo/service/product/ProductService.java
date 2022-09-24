package com.example.demo.service.product;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductCreator productCreator;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductCreator productCreator) {
        this.productRepository = productRepository;
        this.productCreator = productCreator;
    }

    public Iterable<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getOneOrCreate(String id) {
        return productRepository.findById(id).orElseGet(() -> {
            final Product product = productCreator.create("Default name", 1000, "Default description");
            productRepository.save(product);
            return product;
        });
    }

    public Product create(Product product) {
        final Product newProduct = productCreator.create(product.getName(), product.getPrice(),
                product.getDescription());
        productRepository.save(newProduct);
        return newProduct;
    }

    public Optional<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    public Product update(Product product) {
        product.setName(String.format("[NEW]%s", product.getName()));
        return productRepository.save(product);
    }

    public void delete(String id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        }
    }
}
