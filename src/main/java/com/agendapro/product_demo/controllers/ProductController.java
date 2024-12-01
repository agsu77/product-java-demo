package com.agendapro.product_demo.controllers;

import java.util.List;
import java.util.logging.Logger;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.agendapro.product_demo.dto.ProductDTO;
import com.agendapro.product_demo.exceptions.ProductoNotFound;
import com.agendapro.product_demo.jms.EventQueue;
import com.agendapro.product_demo.managers.ProductManager;
import com.agendapro.product_demo.params.ParamModificarProduct;
import com.agendapro.product_demo.params.ParamProduct;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/producto")
@RequiredArgsConstructor
@Validated
public class ProductController {

	private Logger logger = Logger.getLogger(this.getClass().getName());
	private final ProductManager manager;
	private final ModelMapper mapper;
	private final EventQueue events;
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ProductDTO obtenerProductoPorId(@PathVariable Long id) {
		logger.info("Recibo request obtenerProductoPorId para el id "+ id);
		ProductDTO productoEncontrado = manager.findProductById(id);
		if(productoEncontrado != null) {
			logger.info("Devuelvo el producto "+ productoEncontrado);
			return productoEncontrado;
		}else {
			throw new ProductoNotFound(id);
		}
	}
	
	@GetMapping(value = {"/",""})
	@ResponseStatus(value = HttpStatus.OK)
	public List<ProductDTO> obtenerTodosLosProducto() {
		logger.info("Recibo request obtenerTodosLosProducto");
		List<ProductDTO> products = manager.findAllProducts();
		logger.info("Devuelvo "+products.size()+ " productos");
		return products;
	}
	
	@GetMapping(value = "/porNombre/{nombre}")
	public List<ProductDTO> obtenerProductosPorNombre(@PathVariable String nombre) {
		logger.info("Recibo request obtenerProductosPorNombre - buscando por nombre: "+ nombre);
		List<ProductDTO> products = manager.findProductsByNombre(nombre);
		logger.info("Devuelvo "+ products.size() + " productos por el nombre "+ nombre);
		return products;
	}
	
	@PostMapping(value = {"","/"})
	@ResponseStatus(value = HttpStatus.CREATED)
	public ProductDTO crearProducto(@Valid @RequestBody ParamProduct param) {
		logger.info("Recibo request crearProducto para "+ param);
		ProductDTO dto = mapper.map(param, ProductDTO.class);
		dto = manager.saveProduct(dto);
		logger.info("Retorno el producto creado "+ dto);
		events.sendMessage();
		return dto;
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public ProductDTO actualizarProducto(@PathVariable Long id, @Valid @RequestBody ParamModificarProduct param) {
		logger.info("Recibo un request de actualizarProducto para el id "+ id);
		ProductDTO productFound = manager.findProductById(id);
		if(productFound == null) {
			throw new ProductoNotFound(id);
		}
		if(param != null) {
			productFound.setNombre(param.getNombre());
			productFound.setCategoria(param.getCategoria());
			productFound.setDisponible(param.isDisponible());
		}
		productFound = manager.saveProduct(productFound);
		logger.info("Se modifico el registro con id "+id+" con los datos: "+ productFound);
		return productFound;
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void eliminarProducto(@PathVariable Long id) {
		logger.info("Recibo un request de eliminarProducto para el id "+ id);
		ProductDTO productFound = manager.findProductById(id);
		if(productFound == null) {
			throw new ProductoNotFound(id);
		}
		manager.deleteProduct(productFound);
		logger.info("se ha eliminado el producto con id "+ id);
	}
}
