package com.pizzeria.online.PizzeriaOnline2.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pizzeria.online.PizzeriaOnline2.dto.response.GenericResponse;
import com.pizzeria.online.PizzeriaOnline2.dto.response.OrdersResponse;
import com.pizzeria.online.PizzeriaOnline2.dto.response.PizzaOrderResponse;
import com.pizzeria.online.PizzeriaOnline2.models.Ingredient;
import com.pizzeria.online.PizzeriaOnline2.models.PizzaOrder;
import com.pizzeria.online.PizzeriaOnline2.models.Size;
import com.pizzeria.online.PizzeriaOnline2.models.OrderIngredient;
import com.pizzeria.online.PizzeriaOnline2.repositories.IngredientRepository;
import com.pizzeria.online.PizzeriaOnline2.repositories.OrderIngredientRepository;
import com.pizzeria.online.PizzeriaOnline2.repositories.OrderRepository;
import com.pizzeria.online.PizzeriaOnline2.repositories.SizeRepository;
import com.pizzeria.online.PizzeriaOnline2.request.OrderRequest;

@Service
public class OrderService {
	
	private OrderRepository orderRepository;
	private OrderIngredientRepository orderIngredientRepository;
	private IngredientRepository ingredientRepository;
	private SizeRepository sizeRepository;
	
	OrderService( OrderRepository orderRepository, OrderIngredientRepository orderIngredientRepository, 
			IngredientRepository ingredientRepository, SizeRepository sizeRepository){
		this.orderRepository = orderRepository;
		this.orderIngredientRepository = orderIngredientRepository;
		this.ingredientRepository = ingredientRepository;
		this.sizeRepository = sizeRepository;
	}
	
	public GenericResponse saveOrder(OrderRequest orderRequest) {
		GenericResponse orderResponse = new GenericResponse();
		try {
			PizzaOrder order = new PizzaOrder();
			order.setName(orderRequest.getName());
			order.setAddress(orderRequest.getAddress());
			order.setPhone(orderRequest.getPhone());
			order.setSize(orderRequest.getSize());		
			order.setTotal(calcularTotal(orderRequest.getIngredients(), orderRequest.getSize()));
			order = orderRepository.save(order);
					
			for(Integer i : orderRequest.getIngredients()) {
				OrderIngredient orderIngredient = new OrderIngredient();
				orderIngredient.setOrderId(order.getId());
				orderIngredient.setIngredientId(i);
				orderIngredientRepository.save(orderIngredient);
			}
			
			orderResponse.setResult(true);
			orderResponse.setMessage("Successful");
		} catch(Exception e) {
			orderResponse.setResult(false);
			orderResponse.setMessage("Error::"+e);
		}
		return orderResponse;
	}
	
	private BigDecimal calcularTotal(List<Integer> ingredientsId, Integer sizeId) {
		BigDecimal total = BigDecimal.ZERO;
		for(Integer i : ingredientsId) {
			Optional<Ingredient> ingredient =  ingredientRepository.findById(i);
			if(ingredient.get() != null) {
				total = total.add(ingredient.get().getPrice());
			}
		}
		
		Optional<Size> size = sizeRepository.findById(sizeId);
		if(size.get() != null) {
			total = total.add(size.get().getPrice());
		}
		return total;
	}
	
	public List<OrdersResponse> getOrders(){
		List<OrdersResponse> ordersResponseList = new ArrayList<>();
		List<PizzaOrder> pizzaOrderList = (List<PizzaOrder>) orderRepository.findAll();
		for(PizzaOrder p : pizzaOrderList) {
			OrdersResponse ordersResponse = new OrdersResponse();
			ordersResponse.setName(p.getName());
			ordersResponse.setAddress(p.getAddress());
			ordersResponse.setTotal(p.getTotal());
			ordersResponse.setId(p.getId());
			ordersResponseList.add(ordersResponse);
		}
		return ordersResponseList;
	}
	
	public PizzaOrderResponse getOrder(Integer orderId){
		Optional<PizzaOrder> order = orderRepository.findById(orderId);
		if(!order.isPresent()) return null;
		
		PizzaOrderResponse pizzaOrderResponse = new PizzaOrderResponse();
		pizzaOrderResponse.setId(order.get().getId());
		pizzaOrderResponse.setName(order.get().getName());
		pizzaOrderResponse.setPhone(order.get().getPhone());
		Optional<Size> size = sizeRepository.findById((order.get().getSize()));
		pizzaOrderResponse.setSize(size.get());
		List<OrderIngredient> orderIngredients = orderIngredientRepository.findByOrderId(order.get().getId());
		List<Ingredient> ingredients = new ArrayList<>();
		for(OrderIngredient o : orderIngredients) {
			Optional<Ingredient> ingredient = ingredientRepository.findById(o.getIngredientId());
			ingredients.add(ingredient.get());
		}
		pizzaOrderResponse.setIngredients(ingredients);
		pizzaOrderResponse.setTotal(order.get().getTotal());
		
		return pizzaOrderResponse;

	}

}
