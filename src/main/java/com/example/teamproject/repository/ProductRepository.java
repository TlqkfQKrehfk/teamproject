package com.example.teamproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.teamproject.event.Product;
import com.example.teamproject.view.FileCnt;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
//	final String query = "SELECT o.id, cnt.count" + "FROM product o" + "INNER JOIN"
//			+ "(SELECT product_id, COUNT(*) as count" + "FROM product_file" + "GROUP BY product_id) cnt"
//			+ "ON o.id = cnt.product_id;";
//
//	@Query(value = query, nativeQuery = true) // nativeQuery - SQL
//	public List<FileCnt> getFileCnt();
//
//	// 정적 쿼리(static query)
//	// 매개변수만 치환
//	final String paramQuery = "SELECT o.id, cnt.count" + "FROM product o" + "INNER JOIN"
//			+ "(SELECT product_id, COUNT(*) as count" + "FROM product_file" + "WHERE product_id = :id " + // 매개변수 입력
//			"GROUP BY product_id) cnt" + "ON o.id = cnt.product_id;";
//
//	@Query(value = paramQuery, nativeQuery = true) // nativeQuery - SQL
//	public List<FileCnt> getFileCnt(@Param("id") long id);

}
