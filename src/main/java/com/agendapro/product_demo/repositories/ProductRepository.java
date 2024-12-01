package com.agendapro.product_demo.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agendapro.product_demo.entities.Categoria;
import com.agendapro.product_demo.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	
	Set<Product> findByNombreContaining(String nombre);
	
	/**
	 * Nos consulta la tabla products ordena por stock decrecientemente y devuelve
	 * el primero.
	 * 
	 * @return
	 */
	Product findTopByOrderByStockDesc();
	
	/**
	 * Nos consulta la tabla products ordena por fechaCreacion decrecientemente y devuelve
	 * el primero.
	 * 
	 * @return
	 */
	Product findTopByOrderByFechaCreacionDesc();
	
	
	/**
	 * Buscamos cuantos registros tenemos por una categoria dada.
	 * @param Categoria
	 * @return
	 */
	Integer countByCategoria(Categoria categoria);
}
