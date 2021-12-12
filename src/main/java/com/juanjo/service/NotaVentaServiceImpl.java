package com.juanjo.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
	
	public NotaVenta crearNota() {
		NotaVenta nota = new NotaVenta();
		nota.setDetalleVenta(new ArrayList<DetalleVenta>());
		nota.setFechaHora(DateManager.getCurrentDateTime());
		return daoNota.crearNotaVenta(nota);
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
	
	public void cancelar(NotaVenta nota) {
		daoNota.devolver(nota);
	}
	
	@Override
	public void devolverProducto(ProductoAlmacenado item, Double cantidad) {
	  //daoAlmacen.
	}

	@Override
	public NotaVenta agregarProducto(NotaVenta nota, ProductoAlmacenado producto) {
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
	
/*	public NotaVenta buscaAgregaProducto(NotaVenta nota, String codigo) {
		LOGGER.debug("buscaAgregaProducto(), codigo:" + codigo);
		ProductoAlmacenado item =  daoAlmacen.getProductoPorBarcode(codigo);
		DetalleVenta newDetalle = new DetalleVenta();
		double totalAcumulado = 0.0;
		DetalleVenta detalle = new DetalleVenta();
		detalle.setNotaVenta(nota);
		detalle.setUnidades(1.0);
		//detalle.setProductoVenta(producto);
		double subTot = detalle.getUnidades() * item.getPrecioVenta();
		detalle.setTotalLinea(subTot);
		detalle.setRowNum(nota.getDetalleVenta().size() + 1);
		nota.getDetalleVenta().add(0, detalle);
		totalAcumulado = totalAcumulado + subTot;
		nota.setMontoTotal(totalAcumulado);
		daoNota.update(nota);
		return nota;
	}*/
	
	private DetalleVenta creaDetalle(NotaVenta nota, ProductoAlmacenado item){
		List<DetalleVenta> detalleNota = nota.getDetalleVenta();
		DetalleVenta detalle = new DetalleVenta();
		detalle.setNotaVenta(nota);
		detalle.setProductoVenta(item);
		detalle.setRowNum(detalleNota.size() + 1);
		double totalLinea = detalle.getUnidades() * item.getPrecioVenta();
		detalle.setTotalLinea(totalLinea);
		return detalle;
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
