package com.agendapro.product_demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDto {
	private Integer codigo;
	private String descripcion;
}
