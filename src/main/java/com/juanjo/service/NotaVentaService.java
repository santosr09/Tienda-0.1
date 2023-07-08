package com.juanjo.service;

import com.juanjo.entity.NotaVenta;
import com.juanjo.entity.ProductoAlmacenado;

public interface NotaVentaService {
	public NotaVenta crearNota();
	public NotaVenta agregarProducto(NotaVenta nota, ProductoAlmacenado item);
	public void update(NotaVenta nota);
	
	public void vender(NotaVenta nota);
	public void cancelar(NotaVenta nota);
	
	public void devolverProducto(ProductoAlmacenado item, Double cantidad);

    void salidaProducto(String clave, double cantidadDefault);
}
