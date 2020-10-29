package com.juanjo.service;

import com.juanjo.dao.NotaVentaDAO;
import com.juanjo.dao.ProductoAlmacenadoDAO;
import com.juanjo.entity.NotaVenta;
import com.juanjo.entity.Producto;
import com.juanjo.entity.view.DetalleVentaView;
import com.juanjo.entity.view.NotaVentaView;

public interface NotaVentaService {
	public NotaVenta crearNota(NotaVentaView nota);
	public NotaVentaView agregarProductoaNota(String claveProducto, DetalleVentaView detalleVentaView);
	
	public void vender(NotaVenta nota);
	public void devolver(NotaVenta nota);
	
	public void salidaProducto(String barcode, Double cantidad);
	public void devolverProducto(String barcode, Double cantidad);
	
	public void setNotaVentaDAO(NotaVentaDAO dao);
	public void setDaoAlmacen(ProductoAlmacenadoDAO daoAlmacen);

}
