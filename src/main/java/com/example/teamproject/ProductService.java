package com.example.teamproject;

import java.util.ArrayList;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.teamproject.event.Product;
import com.example.teamproject.repository.ProductFileRepository;
import com.example.teamproject.repository.ProductRepository;

@Service
public class ProductService {

	private ProductRepository productRepo;
	private ProductFileRepository fileRepo;

	@Autowired
	public ProductService(ProductRepository productRepo, ProductFileRepository fileRepo) {
		this.productRepo = productRepo;
		this.fileRepo = fileRepo;
	}

// 메시지 받기
	@RabbitListener(queues = "commerce.product")
	public void receiveBill(Product product) {
		Product products = Product.builder().productName(product.getProductName()).description(product.getDescription())
				.price(product.getPrice()).category(product.getCategory()).reDate(product.getReDate())
				.stock(product.getStock()).build();

		System.out.println(products);
		productRepo.save(products);
		System.out.println("--Proudct--");
		System.out.println(product);

	}
}
