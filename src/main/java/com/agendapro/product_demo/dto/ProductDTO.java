package com.agendapro.product_demo.dto;

import com.agendapro.product_demo.entities.Categoria;

import lombok.Data;

@Data
public class ProductDTO {

	private Long id;
	private String nombre;
	private Categoria categoria;
	private boolean disponible;
	
}
