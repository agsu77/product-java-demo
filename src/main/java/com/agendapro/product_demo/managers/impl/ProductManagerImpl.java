package com.agendapro.product_demo.managers.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agendapro.product_demo.dto.ProductDTO;
import com.agendapro.product_demo.entities.Product;
import com.agendapro.product_demo.managers.ProductManager;
import com.agendapro.product_demo.repositories.ProductRepository;

@Service
public class ProductManagerImpl implements ProductManager {

	@Autowired private ProductRepository repository;
	@Autowired private ModelMapper mapper;
	
	@Override
	public ProductDTO findProductById(Long id) {
		Optional<Product> opProducto = repository.findById(id);
		if(opProducto.isPresent()) {
			return mapper.map(opProducto.get(), ProductDTO.class);
		}
		return null;
	}

	@Override
	public List<ProductDTO> findAllProducts() {
		return repository.findAll().stream().map(product -> mapper.map(product, ProductDTO.class)).toList();
	}
	
	
	public ProductDTO saveProduct(ProductDTO product) {
		Product entity = mapper.map(product, Product.class);
		entity = repository.save(entity);
		return mapper.map(entity, ProductDTO.class);
	}
	
	public void deleteProduct(ProductDTO product) {
		repository.deleteById(product.getId());
	}

}
