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

import com.example.models.entities.Client;
import com.example.models.services.IClientService;

@RestController
@RequestMapping("/application")
public class ClientRestController {
	
	@Autowired
	private IClientService clientService;

	@PostMapping("/client")
	@ResponseStatus(HttpStatus.CREATED)
	public Client create(@RequestBody Client client) {
		if (clientService.findById(client.getClientId()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
		return clientService.save(client);	
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        Optional<Client> userOptionl = Optional.ofNullable(clientService.findById(id));

        if (userOptionl.isPresent()) {
            return ResponseEntity.ok(userOptionl.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
