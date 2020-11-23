package com.prova.repository;

import org.springframework.data.repository.CrudRepository;

import com.prova.model.Utenti;

public interface RecipeRepositoryInterface extends CrudRepository<Utenti, Integer>{}
