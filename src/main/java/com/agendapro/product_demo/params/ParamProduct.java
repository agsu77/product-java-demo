package com.agendapro.product_demo.params;

import java.io.Serializable;

import com.agendapro.product_demo.entities.Categoria;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ParamProduct implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "El nombre del producto es obligatorio")
	private String nombre;
	private Categoria categoria;
	@NotNull
	private Double precio;
	@Min(value = 0, message = "El valor menor de stock es cero.")
	private Integer stock;

}
