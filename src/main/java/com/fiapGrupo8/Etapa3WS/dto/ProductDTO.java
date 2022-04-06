package com.fiapGrupo8.Etapa3WS.dto;

import com.fiapGrupo8.Etapa3WS.entity.Product;

public class ProductDTO {
	
	Long id;
	String name;
	String brand;
	Boolean isVegan;
	Boolean isVegetarian;
	Boolean isGlutenFree;
	Double price;
	String description;
	String imageUrl;
	Integer rating;
	Integer countInStock;
	
	public ProductDTO() {}
	
	public ProductDTO(Product product) {
		super();
		this.id = product.getId();
		this.name = product.getName();
		this.brand = product.getBrand();
		this.isVegan = product.getIsVegan();
		this.isVegetarian = product.getIsVegetarian();
		this.isGlutenFree = product.getIsGlutenFree();
		this.price = product.getPrice();
		this.description = product.getDescription();
		this.imageUrl = product.getImageUrl();
		this.rating = product.getRating();
		this.countInStock = product.getCountInStock();
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Boolean getIsVegan() {
		return isVegan;
	}

	public void setIsVegan(Boolean isVegan) {
		this.isVegan = isVegan;
	}

	public Boolean getIsVegetarian() {
		return isVegetarian;
	}

	public void setIsVegetarian(Boolean isVegetarian) {
		this.isVegetarian = isVegetarian;
	}

	public Boolean getIsGlutenFree() {
		return isGlutenFree;
	}

	public void setIsGlutenFree(Boolean isGlutenFree) {
		this.isGlutenFree = isGlutenFree;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Integer getCountInStock() {
		return countInStock;
	}

	public void setCountInStock(Integer countInStock) {
		this.countInStock = countInStock;
	}
	
}
