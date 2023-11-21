package com.example.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.dao.IOrdenDao;
import com.example.models.entities.Orden;

@Service
public class IOrdenServiceImpl implements IOrdenService{

	@Autowired
	private IOrdenDao ordenDao;
	
	@Override
	public Orden findById(Long id) {
		return ordenDao.findById(id).orElse(null);
	}

	@Override
	public Orden save(Orden orden) {
		return ordenDao.save(orden);
	}

}
