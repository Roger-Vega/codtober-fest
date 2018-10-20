package com.pizzeria.online.PizzeriaOnline2.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pizzeria.online.PizzeriaOnline2.models.Ingredient;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Integer>{

}