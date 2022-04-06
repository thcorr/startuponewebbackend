package com.fiapGrupo8.Etapa3WS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fiapGrupo8.Etapa3WS.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
	
	@Query("select c from Cart c where c.id = ?1")
	List<Cart> findAllById(Long id);
}
