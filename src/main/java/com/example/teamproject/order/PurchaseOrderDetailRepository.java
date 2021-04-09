package com.example.teamproject.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderDetailRepository extends JpaRepository<PurchaseOrderDetail, Long> {
//product에 목록을 조회
	// List<PurchaseOrderDetail> findByOrderId(long orderId);

}
