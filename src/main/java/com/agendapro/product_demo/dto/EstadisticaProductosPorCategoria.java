package com.agendapro.product_demo.dto;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.agendapro.product_demo.entities.Categoria;
import com.agendapro.product_demo.entities.TipoEstadistica;
import com.agendapro.product_demo.managers.ProductManager;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
public class EstadisticaProductosPorCategoria extends AbstractEstadisticaDto {

	@Autowired private final ProductManager manager;	
	
	public EstadisticaProductosPorCategoria() {
		super();
		this.manager = null;
	}
	
	public EstadisticaProductosPorCategoria(Long id, TipoEstadistica tipo, String valor, Categoria categoria,
			LocalDateTime fecha) {
		super(id, tipo, valor, categoria, fecha);
		this.manager = null;
	}
	
	
	@Override
	public Object calcular(Object... objects) {
		Categoria categoria = (Categoria) objects[0];
		Integer cantidadProductos = manager.countByCategoria(categoria);
		this.setCategoria(categoria);
		this.setTipo(new TipoEstadistica(Long.valueOf(TipoEstadistica.PRODUCTOS_ACTIVOS_POR_CATEGORIA),
				null, null));
		this.setValor(cantidadProductos.toString());
		return null;
	}

}
