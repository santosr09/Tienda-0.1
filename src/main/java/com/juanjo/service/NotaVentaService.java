package com.juanjo.service;

import com.juanjo.entity.NotaVenta;
import com.juanjo.entity.Producto;

public interface NotaVentaService {
	public void crearNota(NotaVenta nota);
	public void agregarProductoaNota(Producto item);
	
	public void vender(NotaVenta nota);
	public void devolver(NotaVenta nota);
	
	public void salidaProducto(String barcode, Double cantidad);
	public void devolverProducto(String barcode, Double cantidad);

}
