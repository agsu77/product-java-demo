package com.agendapro.product_demo.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Tipo_Estadistica")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoEstadistica {
	public static final int PRODUCTO_CON_MAS_STOCK = 1;
	public static final int ULTIMO_PRODUCTO_CREADO = 2; 
	public static final int PRODUCTOS_ACTIVOS_POR_CATEGORIA = 3;
	
	public static final List<Integer> TODAS_LAS_ESTADISTICAS = List.of(PRODUCTO_CON_MAS_STOCK,
			PRODUCTOS_ACTIVOS_POR_CATEGORIA, ULTIMO_PRODUCTO_CREADO);
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String descripcion;
	
}
