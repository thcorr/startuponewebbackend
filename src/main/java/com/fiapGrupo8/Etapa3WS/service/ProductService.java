package com.fiapGrupo8.Etapa3WS.service;

import java.util.List;

import com.fiapGrupo8.Etapa3WS.dto.ProductDTO;
import com.fiapGrupo8.Etapa3WS.dto.ProductDTOCreateUpdate;

public interface ProductService {

	List<ProductDTO> getAllProducts();
	List<ProductDTO> getProductByName(String name);
	ProductDTO getProductById(Long id);
	ProductDTO createProduct(ProductDTOCreateUpdate product);
	ProductDTO updateProductById(ProductDTO product, Long id);
	void deleteProductById(Long id);
	List<ProductDTO> getProductWithType(Boolean isVegan, Boolean isVegetarian, Boolean isGlutenFree);
}

