package com.juanjo.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.juanjo.utils.DateManager;
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
	
	private NotaVentaDAO dao;
	private ProductoAlmacenadoDAO daoAlmacen;
	private List<Producto> listado;
	
	private long idNota;
	
	public void crearNota(NotaVenta nota){
		nota.setFechaHora(DateManager.getCurrentDateTime());
		Serializable serial = dao.crearNotaVenta(nota);
		System.out.println("NotaVenta creada exitosamente, serial: {}"+ serial);
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
	public void agregarProductoaNota(Producto item) {
		listado.add(item);
		
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
