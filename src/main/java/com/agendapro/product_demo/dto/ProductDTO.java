package com.agendapro.product_demo.dto;

import java.time.LocalDateTime;

import com.agendapro.product_demo.entities.Categoria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

	private Long id;
	private String nombre;
	private Categoria categoria;
	private boolean disponible = true;
	private Double precio;
	private Integer stock;
	private LocalDateTime fechaCreacion;
}
