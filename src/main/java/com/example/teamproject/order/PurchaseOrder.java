package com.example.teamproject.order;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ColumnDefault;

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

	@Column(columnDefinition = "CHAR(2)")
	@ColumnDefault("'00'")
	private String orderState; // 주문 상태

	@OneToOne // 영속성 전이로 저장
	private Product product;
}
