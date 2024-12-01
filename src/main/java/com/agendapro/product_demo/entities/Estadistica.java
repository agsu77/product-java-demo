package com.agendapro.product_demo.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Estadistica")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estadistica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne()
	@JoinColumn(referencedColumnName = "id", name = "tipo")
	private TipoEstadistica tipo;
	private String valor;
	@Enumerated(EnumType.STRING)
	@Null
	private Categoria categoria;
	@NotNull
	@CreatedDate
	private LocalDateTime fecha;
	
}
