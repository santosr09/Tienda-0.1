package com.juanjo.service;

import com.juanjo.entity.NotaCompra;
import com.juanjo.entity.ProductoAlmacenado;

public interface NotaCompraService {
	
	public void crearNota(NotaCompra nota);
	public NotaCompra agregarProductoaNota(NotaCompra nota, ProductoAlmacenado item);
	public void update(NotaCompra nota);
	public NotaCompra getNota(String folio);
	
	public void comprar(NotaCompra nota);
	public void devolver(NotaCompra nota);
	
	public void entradaProducto(String barcode, Double cantidad);
	public void devolverProducto(String barcode, Double cantidad);
}
