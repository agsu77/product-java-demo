package com.agendapro.product_demo.managers.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agendapro.product_demo.dto.ProductDTO;
import com.agendapro.product_demo.entities.Categoria;
import com.agendapro.product_demo.entities.Product;
import com.agendapro.product_demo.managers.ProductManager;
import com.agendapro.product_demo.repositories.ProductRepository;

@Service
public class ProductsManagerImpl implements ProductManager {

	@Autowired
	private ProductRepository repository;
	@Autowired
	private ModelMapper mapper;

	@Override
	public ProductDTO findProductById(Long id) {
		Optional<Product> opProducto = repository.findById(id);
		if (opProducto.isPresent()) {
			return mapper.map(opProducto.get(), ProductDTO.class);
		}
		return null;
	}

	@Override
	public List<ProductDTO> findAllProducts() {
		return repository.findAllByDisponibleTrue().stream().map(product -> mapper.map(product, ProductDTO.class))
				.toList();
	}

	public ProductDTO saveProduct(ProductDTO product) {
		Product entity = mapper.map(product, Product.class);
		entity = repository.save(entity);
		return mapper.map(entity, ProductDTO.class);
	}

	public void deleteProduct(ProductDTO product) {
		repository.deleteById(product.getId());
	}

	@Override
	public List<ProductDTO> findProductsByNombre(String nombre) {
		Set<Product> products = repository.findByNombreContaining(nombre);
		return products.stream().map(product -> mapper.map(product, ProductDTO.class)).toList();
	}

	@Override
	public ProductDTO findProductWithBiggestStock() {
		Product product = repository.findTopByDisponibleTrueOrderByStockDesc();
		return mapper.map(product, ProductDTO.class);
	}

	@Override
	public ProductDTO findProductLastestCreated() {
		Product product = repository.findTopByDisponibleTrueOrderByFechaCreacionDesc();
		return mapper.map(product, ProductDTO.class);
	}

	@Override
	public Integer countByCategoria(Categoria categoria) {
		return repository.countByCategoriaAndDisponibleTrue(categoria);
	}

}
