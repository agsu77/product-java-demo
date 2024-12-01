package com.agendapro.product_demo.managers;

import java.util.List;

import com.agendapro.product_demo.dto.ProductDTO;
import com.agendapro.product_demo.entities.Categoria;

public interface ProductManager {

	/**
	 * Busca un producto por el ID recibido por parametros, en caso de no existir se
	 * devuelve null.
	 * 
	 * @param id
	 * @return
	 */
	ProductDTO findProductById(Long id);
	
	/**
	 * Consulta en base todos los productos y los devuelve como DTO.
	 * 
	 * @return
	 */
	List<ProductDTO> findAllProducts();
	
	/**
	 * Consulta en base todos los productos que contengan en el nombre la cadena
	 * recibida por parametro.
	 * 
	 * @return
	 */
	List<ProductDTO> findProductsByNombre(String nombre);
	
	
	/**
	 * Consulta el producto con mayor stock en base, si tenemos varios productos con
	 * el mismo valor nos quedamos con uno de ellos.
	 * 
	 * @return
	 */
	ProductDTO findProductWithBiggestStock();
	
	/**
	 * Consulta el producto con fecha creacion mas nueva.
	 * 
	 * @return
	 */
	ProductDTO findProductLastestCreated();
	
	Integer countByCategoria(Categoria categoria);
	
	/**
	 * Crea un registro en base partiendo del DTO recibido por parametros.
	 * @param product
	 * @return
	 */
	ProductDTO saveProduct(ProductDTO product);
	
	/**
	 * Recibe un DTO y borra el registro asociado en base.
	 * @param product
	 */
	void deleteProduct(ProductDTO product);
}
