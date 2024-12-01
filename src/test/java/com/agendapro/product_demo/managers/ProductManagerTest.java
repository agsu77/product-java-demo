package com.agendapro.product_demo.managers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.agendapro.product_demo.dto.ProductDTO;
import com.agendapro.product_demo.entities.Categoria;
import com.agendapro.product_demo.entities.Product;
import com.agendapro.product_demo.managers.impl.ProductsManagerImpl;
import com.agendapro.product_demo.repositories.ProductRepository;

@DataJpaTest
class ProductManagerTest {

	@Mock
	private ProductRepository repository;

	@Mock
	private ModelMapper mapper;

	@InjectMocks
	private ProductsManagerImpl productManager;

	private Product productEntity = null;
	private Product productEntity2 = null;
	private ProductDTO productDTO = null;
	private ProductDTO productDTO2 = null;

	@BeforeEach
	void setUp() {
		// Datos de ejemplo
		productEntity = new Product(1L, "Product1", Categoria.COMIDA, true, null, null, null, null);
		productEntity2 = new Product(1L, "Product2", Categoria.ELECTRODOMESTICO, true, null, null, null, null);
		productDTO = new ProductDTO(1L, "Product1", Categoria.COMIDA, true, null, null, null);
		productDTO2 = new ProductDTO(1L, "Product2", Categoria.ELECTRODOMESTICO, true, null, null, null);
	}

	/**
	 * Caso de producto existente - FindByID
	 */
	@Test
	void testFindProductById() {

		when(repository.findById(1L)).thenReturn(Optional.of(productEntity));
		when(mapper.map(productEntity, ProductDTO.class)).thenReturn(productDTO);

		ProductDTO result = productManager.findProductById(1L);
		assertNotNull(result);
		assertEquals(productDTO.getId(), result.getId());
		assertEquals(productDTO.getNombre(), result.getNombre());
	}

	/**
	 * Caso de producto inexistente - FindByID
	 */
	@Test
	void testFindProductByIdUnexist() {
		when(repository.findById(1L)).thenReturn(Optional.empty());
		ProductDTO result = productManager.findProductById(1L);
		assertNull(result);
	}

	/**
	 * Caso de productos existentes - FindAll
	 */
	@Test
	void testFindAllProducts() {
		List<Product> mockProductos = List.of(productEntity2);
		when(repository.findAll()).thenReturn(mockProductos);
		when(mapper.map(productEntity2, ProductDTO.class)).thenReturn(productDTO2);
		List<ProductDTO> result = productManager.findAllProducts();
		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(productDTO2.getId(), result.get(0).getId());
	}

	/**
	 * Caso de guardar un producto.
	 */
	@Test
	void testSaveProduct() {
		when(mapper.map(productDTO, Product.class)).thenReturn(productEntity);
		when(repository.save(productEntity)).thenReturn(productEntity);
		when(mapper.map(productEntity, ProductDTO.class)).thenReturn(productDTO);

		ProductDTO result = productManager.saveProduct(productDTO);

		assertNotNull(result);
		assertEquals(productEntity.getId(), result.getId());
		assertEquals(productEntity.getNombre(), result.getNombre());
		assertEquals(productEntity.getCategoria(), result.getCategoria());
	}

}