package com.example.teamproject.order;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.teamproject.event.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PurchaseOrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Long salesOrderId; // nullable
	private long price;
	private long quantity;
//	private String pay; // 결제 방법
//	private String note; // 요청사항

	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;
}
