package com.pizzeria.online.PizzeriaOnline2.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pizzeria.online.PizzeriaOnline2.models.PizzaOrder;

@Repository
public interface OrderRepository extends CrudRepository<PizzaOrder, Integer>{

}
