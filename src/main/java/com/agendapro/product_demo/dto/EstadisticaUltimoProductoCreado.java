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
public class EstadisticaUltimoProductoCreado extends AbstractEstadisticaDto {

	@Autowired private final ProductManager manager;

	public EstadisticaUltimoProductoCreado() {
		super();
		this.manager = null;
	}
	
	public EstadisticaUltimoProductoCreado(Long id, TipoEstadistica tipo, String valor, Categoria categoria,
			LocalDateTime fecha) {
		super(id, tipo, valor, categoria, fecha);
		this.manager = null;
	}	
	
	@Override
	public Object calcular(Object... objects) {
		ProductDTO producto = manager.findProductLastestCreated();
		this.setTipo(new TipoEstadistica(Long.valueOf(TipoEstadistica.ULTIMO_PRODUCTO_CREADO), null, null) );
		this.setValor(producto.getId().toString());
		return null;
	}

}
