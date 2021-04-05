package com.example.teamproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.teamproject.event.ProductFile;

public interface ProductFileRepository extends JpaRepository<ProductFile, Long> {

}
