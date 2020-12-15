package com.juanjo.service;

import com.juanjo.entity.NotaVenta;
import com.juanjo.entity.ProductoAlmacenado;

public interface NotaVentaService {
	public NotaVenta crearNota();
	public NotaVenta agregarProductoaNota(NotaVenta nota, ProductoAlmacenado item);
	public void update(NotaVenta nota);
	
	public void vender(NotaVenta nota);
	public void devolver(NotaVenta nota);
	
	public void salidaProducto(String barcode, Double cantidad);
	public void devolverProducto(String barcode, Double cantidad);

}
