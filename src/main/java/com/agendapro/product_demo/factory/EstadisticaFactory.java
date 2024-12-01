package com.agendapro.product_demo.factory;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.agendapro.product_demo.dto.AbstractEstadisticaDto;
import com.agendapro.product_demo.dto.EstadisticaProductoConMasStock;
import com.agendapro.product_demo.dto.EstadisticaProductosPorCategoria;
import com.agendapro.product_demo.dto.EstadisticaUltimoProductoCreado;
import com.agendapro.product_demo.entities.Estadistica;
import com.agendapro.product_demo.entities.TipoEstadistica;
import com.agendapro.product_demo.managers.ProductManager;

@Component
public class EstadisticaFactory {

	@Autowired private ProductManager manager;
	@Autowired private ModelMapper mapper;
	
	private EstadisticaFactory() {}

	/**
	 * Este metodo recibe un tipo de estadistica y crea el objeto correcto para ese caso.
	 * @param tipoEstadistica
	 * @return
	 */
	public AbstractEstadisticaDto fromTipoEstadistica(Integer tipoEstadistica) {
		switch(tipoEstadistica) {
			case TipoEstadistica.PRODUCTO_CON_MAS_STOCK:
				return new EstadisticaProductoConMasStock(manager);
			case TipoEstadistica.PRODUCTOS_ACTIVOS_POR_CATEGORIA:
				return new EstadisticaProductosPorCategoria(manager);
			case TipoEstadistica.ULTIMO_PRODUCTO_CREADO:
				return new EstadisticaUltimoProductoCreado(manager);
			default:
				throw new IllegalAccessError("No existe el tipo de estadistica "+ tipoEstadistica);
		}
	}
	
	/**
	 * Este metodo recibe una entidad Estadistica y crea su representacion en DTO.
	 * @param entity
	 * @return
	 */
	public AbstractEstadisticaDto fromEntity(Estadistica entity) {
		
		switch(entity.getTipo().getId().intValue()) {
			case TipoEstadistica.PRODUCTO_CON_MAS_STOCK:
				return mapper.map(entity, EstadisticaProductoConMasStock.class);
			case TipoEstadistica.PRODUCTOS_ACTIVOS_POR_CATEGORIA:
				return mapper.map(entity, EstadisticaProductosPorCategoria.class);
			case TipoEstadistica.ULTIMO_PRODUCTO_CREADO:
				return mapper.map(entity, EstadisticaUltimoProductoCreado.class);
			default:
				throw new IllegalAccessError("No existe el tipo de estadistica para: "+ entity);
		}
	}
	
}
