package com.juanjo.dao;

import java.util.List;

import com.juanjo.entity.Producto;

public interface ProductoDAO {
	
	public void addProducto(Producto p);
	public void updateProducto(Producto c);
	public List<Producto> listProducto();
	public Producto getProducto(long id);
	public void removeProducto(long id);
	
	public Producto getPrecioPorClaveAlterna(String claveAlterna);
	public Producto getPrecioPorBarcode(String barcode);

}
