package com.fiapGrupo8.Etapa3WS.dto;

import java.util.List;

import com.fiapGrupo8.Etapa3WS.entity.Cart;
import com.fiapGrupo8.Etapa3WS.entity.Product;

public class CartDTO {
	
	
	public CartDTO() {}
	
	public CartDTO(Cart cart) {
		super();
		this.id = cart.getId();
		this.productsInCart = cart.getProductsInCart();
	}

	Long id;
	
	List<Product> productsInCart;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Product> getProductsInCart() {
		return productsInCart;
	}

	public void setProductsInCart(List<Product> productsInCart) {
		this.productsInCart = productsInCart;
	}
	
	
}
