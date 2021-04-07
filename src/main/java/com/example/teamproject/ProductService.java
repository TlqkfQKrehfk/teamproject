package com.example.teamproject;

import java.util.ArrayList;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.teamproject.command.CreateRequest;
import com.example.teamproject.event.Product;
import com.example.teamproject.repository.ProductFileRepository;
import com.example.teamproject.repository.ProductRepository;
import com.example.teamproject.view.CreateResponse;

@Service
public class ProductService {

	private ProductRepository productRepo;
	private ProductFileRepository fileRepo;

	@Autowired
	public ProductService(ProductRepository productRepo, ProductFileRepository fileRepo) {
		this.productRepo = productRepo;
		this.fileRepo = fileRepo;
	}

//	@Transactional
//	public CreateResponse createProduct(CreateRequest request) {
//		// 요청 객체를 새로운 엔티티 객체로 변환
//		Product newOrder = Product.builder().name(request.getName()).price(request.get())
//				.name(request.getName()).created_by(request.getName()).status("00").build();
//		// 부모 레코드 저장
//		productRepo.save(newOrder); // repo.save(entity)->entity객체에 id갑이 생성이 됨
//		// 데이터베이스에서 실제로 저장된 객체를 다시 조회하여 응답으로 돌려줄거임
//		Product savedOrder = productRepo.getOne(newOrder.getId());
//
//		// 자식 엔티티 객체 목록 초기화
//		savedOrder.setProductFile(new ArrayList<ProductFile>());
//		// 요청받은 자식 객체 목록을 엔티티 객체로 변환 및 저장
//		for (CreateRequest.Detail detail : request.getFile()) {
//			ProductFile newDetail = ProductFile.builder().ProductId(savedOrder.getId())
//					.product(Product.builder().id(detail.getProductId()).build()).quantity(detail.getQuantity())
//					.unitPrice(detail.getUnitPrice()).build();
//
//			// 저장하고 조회한 부모 entity 객체의 자식에 추가
//			savedOrder.getProductFile().add(fileRepo.save(newDetail));
//		}
//
//		return new CreateResponse(savedOrder);
//	}
//
//	}
// 메시지 받기
	@RabbitListener(queues = "commerce.product")
	public void receiveBill(Product product) {
		Product products = Product.builder().name(product.getName()).description(product.getDescription())
				.price(product.getPrice()).category(product.getCategory()).reDate(product.getReDate())
				.stock(product.getStock()).build();

		System.out.println(products);
		productRepo.save(products);
		System.out.println("--Proudct--");
		System.out.println(product);

	}
}
