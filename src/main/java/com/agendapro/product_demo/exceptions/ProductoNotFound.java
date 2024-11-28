package com.agendapro.product_demo.exceptions;

public class ProductoNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProductoNotFound() {
		super();
	}

	public ProductoNotFound(Long idProducto) {
		super("No se encontro un producto con id: " + idProducto);
	}
	
}
