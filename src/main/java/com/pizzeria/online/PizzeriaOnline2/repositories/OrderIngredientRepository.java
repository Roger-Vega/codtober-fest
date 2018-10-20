package com.pizzeria.online.PizzeriaOnline2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pizzeria.online.PizzeriaOnline2.models.OrderIngredient;

@Repository
public interface OrderIngredientRepository extends CrudRepository<OrderIngredient, Integer>{
	List<OrderIngredient> findByOrderId(Integer orderId);

}
