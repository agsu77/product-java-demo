package com.agendapro.product_demo.managers.impl;

import java.util.List;
import java.util.logging.Logger;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.agendapro.product_demo.dto.AbstractEstadisticaDto;
import com.agendapro.product_demo.entities.Estadistica;
import com.agendapro.product_demo.factory.EstadisticaFactory;
import com.agendapro.product_demo.managers.EstadisticasManager;
import com.agendapro.product_demo.repositories.EstadisticaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EstadisticasManagerImpl implements EstadisticasManager {

	private final EstadisticaRepository repository;
	private final ModelMapper mapper;
	private final EstadisticaFactory factory;
	
	private final Logger logger = Logger.getLogger(this.getClass().getName()); 

	public List<AbstractEstadisticaDto> getEstadisticas() {
		List<Estadistica> estadisticas = repository.findAll();
		return estadisticas.stream().map(factory::fromEntity)
				.toList();
	}

	public void saveEstadistica(AbstractEstadisticaDto dto) {
		Estadistica entity = mapper.map(dto, Estadistica.class);
		try {
			repository.save(entity);			
		} catch (Exception e) {
			logger.severe("error al guardar estadistica "+e);
			throw e;
		}
	}

}
