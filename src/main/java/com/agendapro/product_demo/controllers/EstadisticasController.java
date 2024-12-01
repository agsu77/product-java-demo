package com.agendapro.product_demo.controllers;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agendapro.product_demo.managers.EstadisticasManager;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/estadisticas")
@RequiredArgsConstructor
public class EstadisticasController {

	private Logger logger = Logger.getLogger(this.getClass().getName());
	private final EstadisticasManager manager;
	
	@GetMapping(value = {"","/"})
	public Object getEstadisticas() {
		logger.info("Recibo un request de getEstadisticas");
		return manager.getEstadisticas();
	}
	
}
