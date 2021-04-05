package com.example.teamproject.order;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrderService {

	private RabbitTemplate rabbit;

	@Autowired
	public PurchaseOrderService(RabbitTemplate rabbit) {
		this.rabbit = rabbit;
	}

	// 메시지큐 보내기
	public void sendOrder(PurchaseOrder order) {
		System.out.println(order);
		try {
			rabbit.convertAndSend("commerce.purchaseorder", order);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}