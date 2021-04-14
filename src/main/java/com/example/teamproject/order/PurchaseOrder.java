package com.example.teamproject.order;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import org.hibernate.annotations.ColumnDefault;

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
	private String name; // 구매자 이름
	private String address; // 주소
	private String tel; // 번호
	private long pmt; // 결제 총 금액
	private String orderDate; // 주문일
	private String pay; // 결제 방법
	private String note; // 요청사항
	private String description; // 상품설명
	private Long salesOrderId;
	private String productName;
	private String code;
	private String category;

	@Column(columnDefinition = "CHAR(2)")
	@ColumnDefault("'00'")
	private String orderState; // 주문 상태
	private long price;

//	@OneToMany(cascade = CascadeType.PERSIST)
//	@JoinColumn(name = "purchaseOrderId")
//	private List<PurchaseOrderDetail> purchaseOrderDetails;
}
