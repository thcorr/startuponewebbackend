package com.fiapGrupo8.Etapa3WS.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiapGrupo8.Etapa3WS.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findByIsVegan(Boolean isVegan);

	List<Product> findByIsVegetarian(Boolean isVegetarian);
	
	List<Product> findByIsGlutenFree(Boolean isGlutenFree);
	
	List<Product> findAllByNameLike(String name);

	Optional<Product> findById(Long id);

}
