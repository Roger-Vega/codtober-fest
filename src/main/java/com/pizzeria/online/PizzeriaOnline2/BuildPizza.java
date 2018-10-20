package com.pizzeria.online.PizzeriaOnline2;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.pizzeria.online.PizzeriaOnline2.dto.response.GenericResponse;
import com.pizzeria.online.PizzeriaOnline2.dto.response.OrdersResponse;
import com.pizzeria.online.PizzeriaOnline2.dto.response.PizzaOrderResponse;
import com.pizzeria.online.PizzeriaOnline2.request.OrderRequest;
import com.pizzeria.online.PizzeriaOnline2.request.ViewOrderRequest;
import com.pizzeria.online.PizzeriaOnline2.services.OrderService;

@Controller
public class BuildPizza {
	
	private OrderService orderService;
	
	BuildPizza(OrderService orderService){
		this.orderService = orderService;
	}

	@PostMapping("/buildPizza")	
	public ResponseEntity<GenericResponse> order(@RequestBody OrderRequest orderRequest) {
        return new ResponseEntity<GenericResponse>(orderService.saveOrder(orderRequest), HttpStatus.OK);
    }
	
	@GetMapping("/viewOrders")	
	public ResponseEntity<List<OrdersResponse>> viewOrders() {
        return new ResponseEntity<List<OrdersResponse>>(orderService.getOrders(), HttpStatus.OK);
    }
	
	@GetMapping("/viewOrder")	
	public ResponseEntity<PizzaOrderResponse> viewOrder(@RequestParam(value = "orderId") Integer orderId ) {
        return new ResponseEntity<PizzaOrderResponse>(orderService.getOrder(orderId), HttpStatus.OK);
    }
}
