package com.fiapGrupo8.Etapa3WS.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fiapGrupo8.Etapa3WS.dto.CartDTO;
import com.fiapGrupo8.Etapa3WS.dto.CartDTOCreateUpdate;
import com.fiapGrupo8.Etapa3WS.service.CartService;

@RestController
@RequestMapping("carts")
public class CartController {
	
	private CartService cartService;
	
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	
	@GetMapping
	public List<CartDTO> getAllCarts(){
		return cartService.getAllCarts();
	}
	
	@GetMapping("/{id}")
	public List<CartDTO> getCartById(@PathVariable(name = "id") Long id){
		return cartService.getCartById(id);
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CartDTO createCart(@RequestBody CartDTOCreateUpdate newCart) {
		return cartService.createCart(newCart);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public CartDTO updateCartById(@RequestBody CartDTO cartUpdated,
										@PathVariable Long id) {
		return cartService.updateCartById(cartUpdated, id);
	}

	@PutMapping("/{id}/addproducts/{productId}")
	@ResponseStatus(HttpStatus.CREATED)
	CartDTO addProductListToCartById(@PathVariable Long id, @PathVariable Long productId) {
		return cartService.addProductListToCartById(productId, id);
	}


	
}
