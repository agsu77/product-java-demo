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
	 * Busca solo los productos disponibles en base.
	 * 
	 * @return
	 */
	Set<Product> findAllByDisponibleTrue();
	
	/**
	 * Nos consulta la tabla products, ordena por stock decrecientemente y devuelve
	 * el primero.
	 * 
	 * @return
	 */
	Product findTopByDisponibleTrueOrderByStockDesc();
	
	/**
	 * Nos consulta la tabla products, ordena por fechaCreacion decrecientemente y
	 * devuelve el primero.
	 * 
	 * @return
	 */
	Product findTopByDisponibleTrueOrderByFechaCreacionDesc();
	
	
	/**
	 * Buscamos cuantos registros tenemos por una categoria dada y tengan Disponible
	 * true.
	 * 
	 * @param Categoria
	 * @return
	 */
	Integer countByCategoriaAndDisponibleTrue(Categoria categoria);
}
