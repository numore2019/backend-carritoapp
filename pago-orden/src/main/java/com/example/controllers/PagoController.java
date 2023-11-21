package com.example.controllers;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class PagoController { 

	
	private final String ORDENES_URL = "http://localhost:8081/application/orden/pagar/";

    @PostMapping("/pagar/{idOrden}")
    public String pagarOrden(@PathVariable int idOrden) {
        RestTemplate restTemplate = new RestTemplate();
        String url = ORDENES_URL + "/" + idOrden + "/pagar";

        ResponseEntity<String> response = restTemplate.postForEntity(url, null, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return "Orden #" + idOrden + " pagada exitosamente";
        } else {
            return "No se pudo procesar el pago para la orden #" + idOrden;
        }
    }
}
