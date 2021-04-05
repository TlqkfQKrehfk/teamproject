package com.example.teamproject.order;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseOrderController {
	private PurchaseOrderRepository orderRepo;
	private PurchaseOrderService service;

	@Autowired
	public PurchaseOrderController(PurchaseOrderRepository orderRepo, PurchaseOrderService service) {
		this.orderRepo = orderRepo;
		this.service = service;
	}

	// 주문서 1건 추가
	@PostMapping(value = "/purchase-orders")
	public PurchaseOrder addOrder(@RequestBody PurchaseOrder order) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c1 = Calendar.getInstance();
		String Today = sdf.format(c1.getTime());
		order.setOrderDate(Today);
		orderRepo.save(order);
		service.sendOrder(order);
		return order;
	}
	// 장바구니 리스트 조회
//	@GetMapping(value = "carts")
//	public List<PurchaseOrder> getCart(HttpServletRequest req) {
//		return null;
//	}

	// 주문 상품 목록 조회
	@GetMapping(value = "purchase-orders")
	public List<PurchaseOrder> getOrders(HttpServletRequest req) {
		return orderRepo.findAll();
	}

	// 주문 상품 상세보기
	@GetMapping(value = "purchase-orders/{id}")
	public List<PurchaseOrderDetail> getOrderDetail(HttpServletRequest req) {
		return null;
	}
}
