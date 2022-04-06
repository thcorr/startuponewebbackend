package com.fiapGrupo8.Etapa3WS.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fiapGrupo8.Etapa3WS.dto.CartDTO;
import com.fiapGrupo8.Etapa3WS.dto.CartDTOCreateUpdate;
import com.fiapGrupo8.Etapa3WS.entity.Cart;
import com.fiapGrupo8.Etapa3WS.entity.Product;
import com.fiapGrupo8.Etapa3WS.repository.CartRepository;
import com.fiapGrupo8.Etapa3WS.repository.ProductRepository;
import com.fiapGrupo8.Etapa3WS.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	CartRepository cartRepository;
	ProductRepository productRepository;

	public CartServiceImpl(CartRepository cartRepository, ProductRepository productRepository) {

		this.cartRepository = cartRepository;
		this.productRepository = productRepository;

	}

	@Override
	public List<CartDTO> getAllCarts() {
		List<Cart> cartList;

		cartList = cartRepository.findAll();

		return cartList.stream().map(cart -> new CartDTO(cart)).collect(Collectors.toList());
	}

	@Override
	public List<CartDTO> getCartById(Long id) {
		List<Cart> cartList;
        if (id != null) {
        	cartList = cartRepository.findAllById(id);
        } else {
        	cartList = cartRepository.findAll();
        }
        return cartList.stream()
                .map(cart -> new CartDTO(cart))
                .collect(Collectors.toList());
	}

	@Override
	public CartDTO createCart(CartDTOCreateUpdate cartDTOCreateUpdate) {
		Cart cart = new Cart(cartDTOCreateUpdate);
		Cart savedCart = cartRepository.save(cart);
        return new CartDTO(savedCart);
	}

	@Override
	public CartDTO updateCartById(CartDTO cartDTO, Long id) {
		Cart cart = cartRepository.findById(id)
			.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
		cart.setProductsInCart(cartDTO.getProductsInCart());

        Cart savedCart = cartRepository.save(cart);
        return new CartDTO(savedCart);
	}

	@Override
	public CartDTO addProductListToCartById(Long productId, Long id) {
		Cart cart = cartRepository.findById(id)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

		Product product = productRepository.findById(productId)
        		.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

		cart.getProductsInCart().add(product);
		
		cartRepository.save(cart);
		
		return new CartDTO(cart);
		
	}




}
