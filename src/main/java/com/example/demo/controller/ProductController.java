package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Iterable<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getOne(@PathVariable String id) {
        return productService.getOneOrCreate(id);
    }

    @GetMapping("/find-by-name")
    public Product findByName(@RequestParam String name) {
        return productService.findByName(name).orElse(null);
    }

    @PostMapping
    public Product createOne(@RequestBody Product product) {
        return productService.create(product);
    }

    @PutMapping
    public Product update(@RequestBody Product product) {
        if (product.getId() == null) {
            throw new IllegalArgumentException("Product's id not provided");
        }
        return productService.update(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        productService.delete(id);
    }
}
