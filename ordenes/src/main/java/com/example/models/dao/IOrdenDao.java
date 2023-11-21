package com.example.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.models.entities.Orden;


public interface IOrdenDao extends CrudRepository<Orden, Long>{

}
