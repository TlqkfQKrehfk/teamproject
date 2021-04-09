package com.example.teamproject.order;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseOrderController {
	private PurchaseOrderRepository orderRepo;
	private PurchaseOrderService service;
	private PurchaseOrderDetailRepository detailRepo;

	@Autowired
	public PurchaseOrderController(PurchaseOrderRepository orderRepo, PurchaseOrderService service) {
		this.orderRepo = orderRepo;
		this.service = service;
		this.detailRepo = detailRepo;
	}

	// 주문서 1건 추가
	@PostMapping(value = "/purchase-orders")
	public PurchaseOrder addOrder(@RequestBody PurchaseOrder order) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c1 = Calendar.getInstance();
		String Today = sdf.format(c1.getTime());
		order.setOrderDate(Today);
		order.setOrderState("00");
		orderRepo.save(order);
		service.sendOrder(order);
		return order;
	}

	// 주문 상품 목록 조회
	@GetMapping(value = "purchase-orders")
	public List<PurchaseOrder> getOrders(HttpServletRequest req) {
		return orderRepo.findAll();
	}

	// 주문 상품 상세보기
	@GetMapping(value = "purchase-orders/{id}/details")
	public PurchaseOrderDetail addDetail(@PathVariable("id") long id, HttpServletResponse res) {
		if (orderRepo.findById(id).orElse(null) == null) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		PurchaseOrderDetail detail = PurchaseOrderDetail.builder().salesOrderId(id).product(null).build();
		return detail;
	}

}
