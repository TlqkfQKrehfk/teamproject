package com.example.teamproject.order;

import javax.transaction.Transactional;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.teamproject.event.Product;
import com.google.gson.Gson;

@Service
public class PurchaseOrderService {

	private RabbitTemplate rabbit;
	private KafkaTemplate<String, String> kafka;
	private PurchaseOrderRepository orderRepo;
	private PurchaseOrderDetailRepository detailRepo;

	@Autowired
	public PurchaseOrderService(RabbitTemplate rabbit, KafkaTemplate<String, String> kafka,
			PurchaseOrderRepository orderRepo, PurchaseOrderDetailRepository detailRepo) {
		this.rabbit = rabbit;
		this.kafka = kafka;
		this.orderRepo = orderRepo;
		this.detailRepo = detailRepo;
	}

	// 메시지큐 보내기
	public void sendOrder(PurchaseOrder order) {
		System.out.println(order);

		try {
			rabbit.convertAndSend("commerce.purchaseorder", order);
			kafka.send("commerce.purchaseorder", new Gson().toJson(order));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

//	public void sendDetail(PurchaseOrderDetail detail) {
//		System.out.println(detail);
//
//		try {
//			rabbit.convertAndSend("commerce.purchaseorder", detail);
//			kafka.send("commerce.purchaseorder", new Gson().toJson(detail));
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}
}
