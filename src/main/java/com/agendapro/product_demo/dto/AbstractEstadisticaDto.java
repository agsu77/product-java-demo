package com.agendapro.product_demo.dto;

import java.time.LocalDateTime;

import com.agendapro.product_demo.entities.Categoria;
import com.agendapro.product_demo.entities.TipoEstadistica;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractEstadisticaDto {
	private Long id;
	private TipoEstadistica tipo;
	private String valor;
	private Categoria categoria;
	private LocalDateTime fecha = LocalDateTime.now();

	public abstract Object calcular(Object... objects);

}
