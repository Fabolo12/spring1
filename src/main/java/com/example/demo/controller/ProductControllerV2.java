package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping("/v2/products")
public class ProductControllerV2 {

    private final ProductService productService;

    @Autowired
    public ProductControllerV2(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ModelAndView getArticle(ModelAndView modelAndView) {
        addAllProducts(modelAndView);
        modelAndView.setViewName("allProducts");
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView getFormArticle(ModelAndView modelAndView) {
        final Product product = new Product();
        product.setPrice(500);
        modelAndView.addObject("product", product);
        modelAndView.setViewName("createProduct");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView createOne(@ModelAttribute @Valid Product product, ModelAndView modelAndView) {
        productService.create(product);
        addAllProducts(modelAndView);
        modelAndView.setViewName("allProducts");
        return modelAndView;
    }

    @GetMapping("/delete")
    public ModelAndView getFormDelete(ModelAndView modelAndView) {
        addAllProducts(modelAndView);
        modelAndView.setViewName("deleteProduct");
        return modelAndView;
    }

    @DeleteMapping
    public ModelAndView delete(@ModelAttribute Product product, ModelAndView modelAndView) {
        System.out.println(product.getId() + " is deleted");
        productService.delete(product.getId());
        addAllProducts(modelAndView);
        modelAndView.setViewName("allProducts");
        return modelAndView;
    }

    private void addAllProducts(ModelAndView modelAndView) {
        final List<Product> products = StreamSupport.stream(productService.getAll().spliterator(), false)
                .collect(Collectors.toList());
        modelAndView.addObject("products", products);
    }
}
