package com.example.services;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.models.entities.Producto;

@Component
public class ProductoAPIClient {

	
	 private final String BASE_URL = "https://fakestoreapi.com/products/";
	    private final RestTemplate restTemplate;

	    public ProductoAPIClient() {
	        this.restTemplate = new RestTemplate();
	    }

	    public Producto obtenerProductoPorId(int productId) {
	        String apiUrl = BASE_URL + productId;
	        return restTemplate.getForObject(apiUrl, Producto.class);
	    }
}
