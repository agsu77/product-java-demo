package com.agendapro.product_demo.params;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class ParamModificarProduct extends ParamProduct {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	private boolean disponible;
}
