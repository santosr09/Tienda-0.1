package com.juanjo.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.juanjo.entity.DetalleVenta;
import com.juanjo.entity.ProductoAlmacenado;
import com.juanjo.entity.view.DetalleVentaView;
import com.juanjo.entity.view.NotaVentaView;
import com.juanjo.entity.view.ProductoView;
import com.juanjo.utils.DateUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juanjo.dao.NotaVentaDAO;
import com.juanjo.dao.ProductoAlmacenadoDAO;
import com.juanjo.entity.NotaVenta;
import com.juanjo.entity.Producto;

@Service
public class NotaVentaServiceImpl implements NotaVentaService {
	@Autowired
	private NotaVentaDAO notaVentaDAO;
	private ProductoAlmacenadoDAO daoAlmacen;
	private List<Producto> listado;
	
	private long idNota;
	
	@Transactional
	public NotaVenta crearNota(NotaVentaView nota){
		nota.setFechaHora(DateUtilities.getStrCurrentDate());
		nota.setDetalleVenta(new ArrayList<DetalleVenta>());
		NotaVenta newNota = notaVentaDAO.crearNotaVenta(nota);
		System.out.println("Service NotaVenta creada exitosamente, serial: {}"+ newNota);
		return newNota;
	}
	
	@Transactional
	public NotaVenta getNotaVenta(long id){
		return notaVentaDAO.getNotaVenta(id);
	}

	@Transactional
	public void vender(NotaVenta nota) {
		notaVentaDAO.vender(nota);
	}

	@Transactional
	public void devolver(NotaVenta nota) {
		notaVentaDAO.devolver(nota);
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
	public NotaVentaView agregarProductoaNota(String claveProducto, DetalleVentaView detalleVentaView) {
		ProductoAlmacenado producto = daoAlmacen.getProductoPorBarcode(claveProducto);
		detalleVentaView.setProductoVenta(producto);
		return actualizaListadoNota(detalleVentaView);
	}
	
	public void actualizaLineaNota(DetalleVentaView detalleVentaView){
		//detalleVentaView.
	}
	
	private NotaVentaView actualizaListadoNota(DetalleVentaView detalleVentaView) {
		detalleVentaView.getNotaVentaView().getDetalleVenta().set(detalleVentaView.getRowNum(), detalleVentaView.getEntity());
		return detalleVentaView.getNotaVentaView();
	}
	
	public void setNotaVentaDAO(NotaVentaDAO dao) {
		this.notaVentaDAO = dao;
	}
	public NotaVentaDAO getNotaVentaDao() {
		return notaVentaDAO;
	}
	public ProductoAlmacenadoDAO getDaoAlmacen() {
		return daoAlmacen;
	}
	public void setDaoAlmacen(ProductoAlmacenadoDAO daoAlmacen) {
		this.daoAlmacen = daoAlmacen;
	}
	
}
