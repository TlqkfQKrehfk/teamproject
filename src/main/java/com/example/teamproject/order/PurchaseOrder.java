package com.example.teamproject.order;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PurchaseOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	private String address;
	// private String status;
	private String tel;
	private String note; // 배송시 요청사항
	private long pmt; // 총 구매가격
	private String pay; // 결제방법
	// private String created_by;
	private String orderDate; // 주문날짜
	// PurchaseOrderDetail 여러개를 가지고 있는 필드
	private String orderState;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "purchaseOrderId") // 하위테이블 필드, FK
	private List<PurchaseOrderDetail> purchaseOrderDetail;
}
