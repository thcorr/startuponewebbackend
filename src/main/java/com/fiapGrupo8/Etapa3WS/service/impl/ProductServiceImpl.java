package com.fiapGrupo8.Etapa3WS.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fiapGrupo8.Etapa3WS.dto.ProductDTO;
import com.fiapGrupo8.Etapa3WS.dto.ProductDTOCreateUpdate;
import com.fiapGrupo8.Etapa3WS.entity.Product;
import com.fiapGrupo8.Etapa3WS.repository.ProductRepository;
import com.fiapGrupo8.Etapa3WS.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		
		this.productRepository = productRepository;
		
	}
	
	@Override
	public List<ProductDTO> getAllProducts() {
		List<Product> productList;
		
		productList = productRepository.findAll();
		
		return productList.stream()
				.map(product -> new ProductDTO(product)).collect(Collectors.toList());
		
	}
	
	@Override
	public List<ProductDTO> getProductWithType(Boolean isVegan, Boolean isVegetarian, Boolean isGlutenFree) {
		List<Product> productList;
		
		if (isVegan != null) {
			productList = productRepository.findByIsVegan(isVegan);
		}else if (isVegetarian != null) {
			productList = productRepository.findByIsVegetarian(isVegetarian);			
		}else if (isGlutenFree != null) {
			productList = productRepository.findByIsGlutenFree(isGlutenFree);			
		}else {
			productList = productRepository.findAll();
		}
		
		return productList.stream()
				.map(product -> new ProductDTO(product)).collect(Collectors.toList());
		
	}
	
	@Override
	public List<ProductDTO> getProductByName(String name) {
		List<Product> productList;
        if (name != null) {
        	productList = productRepository.findAllByNameLike("%" + name + "%");
        } else {
        	productList = productRepository.findAll();
        }
        return productList.stream()
                .map(product -> new ProductDTO(product))
                .collect(Collectors.toList());
	}

	@Override
	public ProductDTO getProductById(Long id) {
     
		Product product = productRepository.findById(id)
        		.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        
        return new ProductDTO(product);
	}

	@Override
	public ProductDTO createProduct(ProductDTOCreateUpdate productDTOCreateUpdate) {
		Product product = new Product(productDTOCreateUpdate);
		Product savedProduct = productRepository.save(product);
        return new ProductDTO(savedProduct);
	}

	@Override
	public ProductDTO updateProductById(ProductDTO productDTO, Long id) {

		Product product = productRepository.findById(id)
        		.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

		product.setBrand(productDTO.getBrand());  
		product.setIsGlutenFree(productDTO.getIsGlutenFree());
		product.setIsVegan(productDTO.getIsVegan());
		product.setIsVegetarian(productDTO.getIsVegetarian());
		product.setName(productDTO.getName());
		product.setImageUrl(productDTO.getImageUrl());
		product.setRating(productDTO.getRating());
		product.setCountInStock(productDTO.getCountInStock());
		product.setPrice(productDTO.getPrice());

        Product savedProduct = productRepository.save(product);
        return new ProductDTO(savedProduct);
		
	}

	@Override
	public void deleteProductById(Long id) {
		Product product = productRepository.findById(id)
        		.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		productRepository.delete(product);
	}

}
