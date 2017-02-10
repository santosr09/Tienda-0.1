package com.juanjo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juanjo.dao.ProductoAlmacenadoDAO;
import com.juanjo.dao.ProductoDAO;
import com.juanjo.entity.Producto;
import com.juanjo.entity.ProductoAlmacenado;
import com.juanjo.entity.view.ProductoView;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	private ProductoDAO dao;
	private ProductoAlmacenadoDAO daoAlmacen;

	public void setDao(ProductoDAO dao) {
		this.dao = dao;
	}

	@Transactional
	public void addProducto(Producto p) {
		dao.addProducto(p);
	}

	@Transactional
	public void updateProducto(Producto c) {
		dao.updateProducto(c);
	}

	@Transactional
	public List<Producto> listProducto() {
		return dao.listProducto();
	}

	@Transactional
	public Producto getProducto(long id) {
		return dao.getProducto(id);
	}

	@Transactional
	public void removeProducto(long id) {
		dao.removeProducto(id);
	}

	@Transactional
	public ProductoView getProductoAlmacenPorClaveAlterna(String claveAlterna) {
		ProductoAlmacenado productoAlmacen = daoAlmacen.getProductoPorClaveAlterna(claveAlterna);
		if(productoAlmacen != null){
			return new ProductoView(productoAlmacen);
		}
		return new ProductoView();
	}

	@Transactional
	public ProductoView getProductoViewPorBarcode(String barcode) {
		ProductoAlmacenado productoAlmacen = daoAlmacen.getProductoPorBarcode(barcode);
		if(productoAlmacen != null){
			return new ProductoView(productoAlmacen);
		}
		return new ProductoView();
	}
	
	@Transactional
	public ProductoAlmacenado getProductoAlmacenPorBarcode(String barcode) {
		return daoAlmacen.getProductoPorBarcode(barcode);
	}

	public ProductoAlmacenadoDAO getDaoAlmacen() {
		return daoAlmacen;
	}

	public void setDaoAlmacen(ProductoAlmacenadoDAO daoAlmacen) {
		this.daoAlmacen = daoAlmacen;
	}

}
