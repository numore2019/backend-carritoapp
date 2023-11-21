package com.example.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.models.entities.Client;


public interface IClientDao extends CrudRepository<Client, Long>{

}
