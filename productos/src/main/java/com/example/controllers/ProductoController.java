package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.entities.Producto;
import com.example.services.ProductoAPIClient;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoAPIClient productoAPIClient;

    @Autowired
    public ProductoController(ProductoAPIClient productoAPIClient) {
        this.productoAPIClient = productoAPIClient;
    }

    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable int id) {
        return productoAPIClient.obtenerProductoPorId(id);
    }
}