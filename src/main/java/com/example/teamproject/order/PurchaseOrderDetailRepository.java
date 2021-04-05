package com.example.teamproject.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderDetailRepository extends JpaRepository<PurchaseOrderDetail, Long> {
}
