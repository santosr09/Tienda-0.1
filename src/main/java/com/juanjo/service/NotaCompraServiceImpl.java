package com.juanjo.service;

import com.juanjo.dao.NotaCompraDAO;
import com.juanjo.dao.ProductoAlmacenadoDAO;
import com.juanjo.entity.DetalleCompra;
import com.juanjo.entity.NotaCompra;
import com.juanjo.entity.ProductoAlmacenado;
import com.juanjo.utils.DateManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class NotaCompraServiceImpl implements NotaCompraService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NotaCompraServiceImpl.class);
	
	private NotaCompraDAO daoNota;
	private ProductoAlmacenadoDAO daoAlmacen;
	
	@Override
	public void crearNota(NotaCompra nota) {
		nota.setFechaHora(DateManager.getCurrentDateTime());
		Serializable serial = daoNota.crearNotaCompra(nota);
		LOGGER.debug("NotaCompra creada exitosamente, serial: {}"+ serial);
	}
	
	@Override
	public NotaCompra agregarProductoaNota(NotaCompra nota, ProductoAlmacenado item) {
	   return nota;
	}
	
	@Override
	public void update(NotaCompra nota) {
		daoNota.update(nota);
	}
	
	@Override
	public NotaCompra getNota(String folio) {
		return daoNota.getNotaCompra(Long.valueOf(folio));
	}
	
	@Override
	public void comprar(NotaCompra nota) {
		for (DetalleCompra detalle: nota.getDetalleCompraList()){
					daoAlmacen.addProducto(detalle.getProductoAlmacenado());
		}
		daoNota.comprar(nota);
	}
	
	@Override
	public void devolver(NotaCompra nota) {
	
	}
	
	@Override
	public void entradaProducto(String barcode, Double cantidad) {
	
	}
	
	@Override
	public void devolverProducto(String barcode, Double cantidad) {
	
	}
	
	public NotaCompraDAO getDaoNota() {
		return daoNota;
	}
	
	public void setDaoNota(NotaCompraDAO daoNota) {
		this.daoNota = daoNota;
	}
	
	public ProductoAlmacenadoDAO getDaoAlmacen() {
		return daoAlmacen;
	}
	
	public void setDaoAlmacen(ProductoAlmacenadoDAO daoAlmacen) {
		this.daoAlmacen = daoAlmacen;
	}
}
