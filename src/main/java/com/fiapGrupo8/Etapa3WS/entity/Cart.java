package com.fiapGrupo8.Etapa3WS.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fiapGrupo8.Etapa3WS.dto.CartDTOCreateUpdate;

@Entity
@Table(name = "TB_CART")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long cartId;
	
	@Column
	private Date createdDate;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="TB_CART_PRODUCT",
	joinColumns={@JoinColumn(name="cart_id")},
	inverseJoinColumns={@JoinColumn(name="product_id")})
	List<Product> productsInCart;

	public Cart() {

	}

	public Cart(CartDTOCreateUpdate cart) {
		this.productsInCart = cart.getProductsInCart();
	}
	
	public Long getId() {
		return cartId;
	}

	public void setId(Long cartId) {
		this.cartId = cartId;
	}

	public List<Product> getProductsInCart() {

		return productsInCart;
	}

	public void setProductsInCart(List<Product> productsInCart) {
		this.productsInCart = productsInCart;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
