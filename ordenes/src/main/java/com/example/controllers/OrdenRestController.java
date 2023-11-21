package com.example.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.models.entities.Orden;
import com.example.models.services.IOrdenService;

@RestController
@RequestMapping("/application")
public class OrdenRestController {
	
	@Autowired
	private IOrdenService ordenService;

	@PostMapping("/orden")
	@ResponseStatus(HttpStatus.CREATED)
	public Orden create(@RequestBody Orden orden) {
		if (ordenService.findById(orden.getId()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
		return ordenService.save(orden);	
	}
	
	@GetMapping("orden/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        Optional<Orden> userOptionl = Optional.ofNullable(ordenService.findById(id));

        if (userOptionl.isPresent()) {
            return ResponseEntity.ok(userOptionl.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
	
	@PutMapping("/orden/pagar/{id}")
	public Orden update(@PathVariable Long id) {
		Optional<Orden> optionalOrden = Optional.ofNullable(ordenService.findById(id));
        
        if (optionalOrden.isPresent()) {
            Orden orden = optionalOrden.get();
            orden.setPagada(true); 
            return ordenService.save(orden); 
        } else {
            throw new RuntimeException("Orden no encontrada con ID: " + id);
        }
    }
}

