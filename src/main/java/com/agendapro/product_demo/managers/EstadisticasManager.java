package com.agendapro.product_demo.managers;

import java.util.List;

import com.agendapro.product_demo.dto.AbstractEstadisticaDto;

public interface EstadisticasManager {
	
	/**
	 * Este metodo consulta las ultimas estadisticas de cada tipo.
	 * @return
	 */
	public List<AbstractEstadisticaDto> getEstadisticas();
	
	/**
	 * Este metodo guarda una estadistica.
	 * @param dto
	 */
	public void saveEstadistica(AbstractEstadisticaDto dto);
	
}
