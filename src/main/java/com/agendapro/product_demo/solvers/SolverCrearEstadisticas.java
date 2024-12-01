package com.agendapro.product_demo.solvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.agendapro.product_demo.dto.AbstractEstadisticaDto;
import com.agendapro.product_demo.entities.Categoria;
import com.agendapro.product_demo.entities.TipoEstadistica;
import com.agendapro.product_demo.factory.EstadisticaFactory;
import com.agendapro.product_demo.managers.EstadisticasManager;

@Controller
public class SolverCrearEstadisticas {

	@Autowired private EstadisticasManager manager;
	@Autowired private EstadisticaFactory estadisticaFactory;
	
	/**
	 * Este metodo va a calcular todos los tipos de estadisticas y guardarlas en
	 * base.
	 */
	public void solve() {
		AbstractEstadisticaDto estadistica;
		 for(int tipoEstadistica : TipoEstadistica.TODAS_LAS_ESTADISTICAS) {
			 if(tipoEstadistica == TipoEstadistica.PRODUCTOS_ACTIVOS_POR_CATEGORIA) {
				 for (Categoria categoria : Categoria.values()) {
					 // Genero una estadistica por cada Categoria...
					 estadistica = estadisticaFactory.fromTipoEstadistica(tipoEstadistica);
					 estadistica.calcular(categoria);
					 guardarEstadistica(estadistica);				 
				 }
			 }else {
				 estadistica = estadisticaFactory.fromTipoEstadistica(tipoEstadistica);
				 estadistica.calcular();
				 guardarEstadistica(estadistica);				 
			 }
		 }
	}

	private void guardarEstadistica(AbstractEstadisticaDto estadistica) {
		 manager.saveEstadistica(estadistica);
	}
	
}
