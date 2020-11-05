package com.juanjo.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.juanjo.entity.DetalleVenta;
import com.juanjo.entity.ProductoAlmacenado;
import com.juanjo.utils.DateManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juanjo.dao.NotaVentaDAO;
import com.juanjo.dao.ProductoAlmacenadoDAO;
import com.juanjo.entity.NotaVenta;
import com.juanjo.entity.Producto;
import com.juanjo.entity.view.ProductoView;

@Service
public class NotaVentaServiceImpl implements NotaVentaService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NotaVentaServiceImpl.class);
	
	private NotaVentaDAO dao;
	private ProductoAlmacenadoDAO daoAlmacen;
	
	private long idNota;
	
	public void crearNota(NotaVenta nota){
		nota.setFechaHora(DateManager.getCurrentDateTime());
		Serializable serial = dao.crearNotaVenta(nota);
		LOGGER.debug("NotaVenta creada exitosamente, serial: {}"+ serial);
	}
	
	public NotaVenta getNotaVenta(long id){
		return dao.getNotaVenta(id);
	}
	
	public void vender(NotaVenta nota) {
		dao.vender(nota);
	}
	
	public void devolver(NotaVenta nota) {
		dao.devolver(nota);
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
		dao.update(nota);
		return nota;
	}
	
	@Override
	public void update(NotaVenta nota) {
		dao.update(nota);
	}
	
	public void setDao(NotaVentaDAO dao) {
		this.dao = dao;
	}

	public NotaVentaDAO getDao() {
		return dao;
	}

	public ProductoAlmacenadoDAO getDaoAlmacen() {
		return daoAlmacen;
	}

	public void setDaoAlmacen(ProductoAlmacenadoDAO daoAlmacen) {
		this.daoAlmacen = daoAlmacen;
	}


}
