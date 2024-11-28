package com.agendapro.product_demo.params;

import com.agendapro.product_demo.entities.Categoria;

import lombok.Data;

@Data
public class ParamProduct {
	
	private String nombre;
	private Categoria categoria;
	private boolean disponible;

}
