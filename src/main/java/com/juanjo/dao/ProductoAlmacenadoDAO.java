package com.juanjo.dao;

import java.util.List;

import com.juanjo.entity.ProductoAlmacenado;

public interface ProductoAlmacenadoDAO {
	
	public void addProducto(ProductoAlmacenado p);
	public void updateProducto(ProductoAlmacenado c);
	public List<ProductoAlmacenado> listProducto();
	public ProductoAlmacenado getProducto(long id);
	public void removeProducto(long id);
	
	public void descontarProductoAlmacen(String barcode, Double cantidad);
	public void devolverProductoAlmacen(String barcode, Double cantidad);
	
	public ProductoAlmacenado getProductoPorClaveAlterna(String claveAlterna);
	public ProductoAlmacenado getProductoPorBarcode(String barcode);

}
