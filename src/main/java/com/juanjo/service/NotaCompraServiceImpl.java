package com.juanjo.service;

import com.juanjo.dao.NotaCompraDAO;
import com.juanjo.dao.ProductoAlmacenadoDAO;
import com.juanjo.entity.DetalleCompra;
import com.juanjo.entity.NotaCompra;
import com.juanjo.entity.ProductoAlmacenado;
import com.juanjo.utils.DateManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class NotaCompraServiceImpl implements NotaCompraService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NotaCompraServiceImpl.class);
	
	private NotaCompraDAO daoNota;
	private ProductoAlmacenadoDAO daoAlmacen;
	
	@Override
	public NotaCompra crearNota() {
		NotaCompra nota = new NotaCompra();
		nota.setFechaHora(DateManager.getCurrentDateTime());
		nota.setDetalleCompra(new ArrayList<DetalleCompra>());
		return daoNota.crearNotaCompra(nota);
	}
	
	@Override
	public NotaCompra agregarProducto(NotaCompra nota, ProductoAlmacenado producto) {
		LOGGER.debug("agergarProductoaNota(), producto:" + producto);
		double totalAcumulado = 0.0;
		DetalleCompra detalle = new DetalleCompra();
		detalle.setNotaCompra(nota);
		detalle.setUnidades(1.0);
		detalle.setProductoAlmacenado(producto);
		double subTot = detalle.getUnidades() * producto.getPrecioCompraUltimo();
		detalle.setMontoTotal(subTot);
		detalle.setRowNum(nota.getDetalleCompra().size() + 1);
		nota.getDetalleCompra().add(0, detalle);
		totalAcumulado = totalAcumulado + subTot;
		nota.setMontoTotal(totalAcumulado);
		daoNota.update(nota);
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
		for (DetalleCompra detalle: nota.getDetalleCompra()){
			double cantidad = detalle.getUnidades() + detalle.getProductoAlmacenado().getExistencia();
			ProductoAlmacenado item = detalle.getProductoAlmacenado();
			item.setExistencia(cantidad);
			daoAlmacen.addProducto(item);
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
