package com.juanjo.service;

import java.io.Serializable;

import com.juanjo.entity.*;
import com.juanjo.utils.DateManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juanjo.dao.NotaVentaDAO;
import com.juanjo.dao.ProductoAlmacenadoDAO;

@Service
public class NotaVentaServiceImpl implements NotaVentaService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NotaVentaServiceImpl.class);
	
	private NotaVentaDAO daoNota;
	private ProductoAlmacenadoDAO daoAlmacen;
	
	private long idNota;
	
	public void crearNota(NotaVenta nota){
		nota.setFechaHora(DateManager.getCurrentDateTime());
		Serializable serial = daoNota.crearNotaVenta(nota);
		LOGGER.debug("NotaVenta creada exitosamente, serial: {}"+ serial);
	}
	
	public NotaVenta getNotaVenta(long id){
		return daoNota.getNotaVenta(id);
	}
	
	public void vender(NotaVenta nota) {
		for (DetalleVenta detalle: nota.getDetalleVenta()){
			double cantidad = detalle.getUnidades() + detalle.getProductoVenta().getExistencia();
			ProductoAlmacenado item = detalle.getProductoVenta();
			item.setExistencia(cantidad);
			daoAlmacen.addProducto(item);
		}
		daoNota.vender(nota);
	}
	
	public void devolver(NotaVenta nota) {
		daoNota.devolver(nota);
	}

	@Transactional
	public void salidaProducto(String barcode, Double cantidad) {
		daoAlmacen.descontarProductoAlmacen(barcode, cantidad);
	}

	@Transactional
	public void devolverProducto(String barcode, Double cantidad) {
		daoAlmacen.devolverProductoAlmacen(barcode, cantidad);
	}

	@Override
	public NotaVenta agregarProductoaNota(NotaVenta nota, ProductoAlmacenado producto) {
		LOGGER.debug("agergarProductoaNota(), producto:" + producto);
		double totalAcumulado = 0.0;
		DetalleVenta detalle = new DetalleVenta();
		detalle.setNotaVenta(nota);
		detalle.setUnidades(1.0);
		detalle.setProductoVenta(producto);
		double subTot = detalle.getUnidades() * producto.getPrecioVenta();
		detalle.setTotalLinea(subTot);
		detalle.setRowNum(nota.getDetalleVenta().size() + 1);
		nota.getDetalleVenta().add(0, detalle);
		totalAcumulado = totalAcumulado + subTot;
		nota.setMontoTotal(totalAcumulado);
		daoNota.update(nota);
		return nota;
	}
	
	@Override
	public void update(NotaVenta nota) {
		daoNota.update(nota);
	}
	
	public void setDaoNota(NotaVentaDAO daoNota) {
		this.daoNota = daoNota;
	}

	public NotaVentaDAO getDaoNota() {
		return daoNota;
	}

	public ProductoAlmacenadoDAO getDaoAlmacen() {
		return daoAlmacen;
	}

	public void setDaoAlmacen(ProductoAlmacenadoDAO daoAlmacen) {
		this.daoAlmacen = daoAlmacen;
	}
	
}
