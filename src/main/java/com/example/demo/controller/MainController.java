package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping
    public String main() {
        return """
                DemoApplication<br>
                <a href="http://localhost:8080/products">Get all products</a><br>
                <a href="http://localhost:8080/products/">Get one product</a><br>
                <a href="http://localhost:8080/products/create?">Create product via params</a><br>
                <a href="http://localhost:8080/products/created-date">Get product & created date</a><br>
                <p>V2 endpoints</p>
                <a href="http://localhost:8080/v2/products">Get all products</a><br>
                <a href="http://localhost:8080/v2/products/create">Create a product</a><br>
                """;
    }
}
