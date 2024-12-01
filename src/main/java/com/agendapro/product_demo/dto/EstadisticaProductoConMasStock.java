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
public class EstadisticaProductoConMasStock extends AbstractEstadisticaDto {

	@Autowired private final ProductManager manager;

	public EstadisticaProductoConMasStock() {
		super();
		this.manager = null;
	}
	
	
	public EstadisticaProductoConMasStock(Long id, TipoEstadistica tipo, String valor, Categoria categoria,
			LocalDateTime fecha) {
		super(id, tipo, valor, categoria, fecha);
		this.manager = null;
	}
	
	
	@Override
	public Object calcular(Object... objects) {
		ProductDTO producto = manager.findProductWithBiggestStock();
		this.setTipo(new TipoEstadistica(Long.valueOf(TipoEstadistica.PRODUCTO_CON_MAS_STOCK),null, null) );
		this.setValor(producto.getId().toString());
		return null;
	}




}
