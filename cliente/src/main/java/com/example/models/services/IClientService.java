package com.example.models.services;

import java.util.List;

import com.example.models.entities.Client;

public interface IClientService {
	
	public Client findById(Long id);
	
	public Client save(Client client);

}
