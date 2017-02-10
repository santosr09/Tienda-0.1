package com.juanjo.service;

import java.util.List;

import com.juanjo.entity.Producto;
import com.juanjo.entity.ProductoAlmacenado;
import com.juanjo.entity.view.ProductoView;

public interface ProductoService {
	
	public void addProducto(Producto p);
	public void updateProducto(Producto c);
	public List<Producto> listProducto();
	public Producto getProducto(long id);
	public void removeProducto(long id);
	
	public ProductoView getProductoAlmacenPorClaveAlterna(String claveAlterna);
	public ProductoAlmacenado getProductoAlmacenPorBarcode(String barcode);
	public ProductoView getProductoViewPorBarcode(String barcode);

}
