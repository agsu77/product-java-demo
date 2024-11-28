package com.agendapro.product_demo.managers;

import java.util.List;

import com.agendapro.product_demo.dto.ProductDTO;

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
