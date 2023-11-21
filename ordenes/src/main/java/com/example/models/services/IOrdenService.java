package com.example.models.services;

import com.example.models.entities.Orden;

public interface IOrdenService {
	
	public Orden findById(Long id);
	
	public Orden save(Orden orden);

}
