package com.example.teamproject.order;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class PurchaseOrderService {

	private RabbitTemplate rabbit;
	private KafkaTemplate<String, String> kafka;

	@Autowired
	public PurchaseOrderService(RabbitTemplate rabbit, KafkaTemplate<String, String> kafka) {
		this.rabbit = rabbit;
		// this.kafka = kafka;
	}

	// 메시지큐 보내기
	public void sendOrder(PurchaseOrder order) {
		System.out.println(order);
		try {
			rabbit.convertAndSend("commerce.purchaseorder", order);
			// kafka.send("commerce.purchaseorder", new Gson().toJson(order));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}