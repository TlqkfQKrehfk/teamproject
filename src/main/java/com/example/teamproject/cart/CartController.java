package com.example.teamproject.cart;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

	private CartRepository cartRepo;

	@Autowired
	public CartController(CartRepository cartRepo) {
		this.cartRepo = cartRepo;
	}

	// 카트 목록 조회
	@GetMapping(value = "/carts")
	public List<Cart> getCarts() {
		return cartRepo.findAll();
	}

	// 카트 목록 추가
	@PostMapping(value = "/carts")
	public Cart addCart(@RequestBody Cart cart) {
		cartRepo.save(cart);
		return cart;
	}

	// 카트목록 1건 삭제
	@DeleteMapping(value = "/carts/{id}")
	public boolean removeCart(@PathVariable("id") long id, HttpServletResponse res) {

		Cart cart = cartRepo.findById(id).orElse(null);
		if (cart == null) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return false;
		}
		cartRepo.deleteById(id);
		return true;
	}
}
