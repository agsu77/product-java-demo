package com.agendapro.product_demo.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agendapro.product_demo.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	
	Set<Product> findByNombreContaining(String nombre);
	
}
