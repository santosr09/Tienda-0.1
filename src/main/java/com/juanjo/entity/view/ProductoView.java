package com.juanjo.entity.view;

import com.juanjo.entity.Categoria;
import com.juanjo.entity.Marca;
import com.juanjo.entity.ProductoAlmacenado;

public class ProductoView {
	
	private String clave = null;
	private String claveAlterna = null;
	private float cantidadVenta = 0.0f;
	private String descripcion = null;
	private Marca marca = null;
	private Categoria categoria = null;
	private Integer status = 0;
	private String imagen = null;
	private Double max;
	private Double min;
	private Double existencia;
	private Double precioVenta;
	private Double precioCompra;
	private Double utilidadPorcentaje;
	private Double utilidadMonetaria;
	private String presentacionVenta;
	private String presentacionCompra;
	
	//Constructor utilizando una entidad de ProductoAlmacenado
	public ProductoView(ProductoAlmacenado producto){
		this.clave = producto.getProducto().getClave();
		this.claveAlterna = producto.getProducto().getClaveAlterna();
		this.descripcion = producto.getProducto().getDescripcion();
		this.marca = producto.getProducto().getMarca();
		this.categoria = producto.getProducto().getCategoria();
		this.status = producto.getProducto().getStatus();
		this.imagen = producto.getProducto().getImagen();
		this.max = producto.getMax();
		this.min = producto.getMin();
		this.existencia = producto.getExistencia();
		this.precioVenta = producto.getPrecioVenta();
		this.precioCompra = producto.getPrecioCompra();
		this.utilidadPorcentaje = producto.getUtilidadPorcentaje();
		this.utilidadMonetaria = producto.getUtilidadMonetaria();
		this.presentacionVenta = producto.getPresentacionVenta();
		this.presentacionCompra = producto.getPresentacionCompra();
	}
	
	//Constructor Default
	public ProductoView(){
		this(new ProductoAlmacenado());
	}
	
	
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getClaveAlterna() {
		return claveAlterna;
	}
	public void setClaveAlterna(String claveAlterna) {
		this.claveAlterna = claveAlterna;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Double getMax() {
		return max;
	}
	public void setMax(Double max) {
		this.max = max;
	}
	public Double getMin() {
		return min;
	}
	public void setMin(Double min) {
		this.min = min;
	}
	public Double getExistencia() {
		return existencia;
	}
	public void setExistencia(Double existencia) {
		this.existencia = existencia;
	}
	public Double getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
	}
	public Double getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(Double precioCompra) {
		this.precioCompra = precioCompra;
	}
	public Double getUtilidadPorcentaje() {
		return utilidadPorcentaje;
	}
	public void setUtilidadPorcentaje(Double utilidadPorcentaje) {
		this.utilidadPorcentaje = utilidadPorcentaje;
	}
	public Double getUtilidadMonetaria() {
		return utilidadMonetaria;
	}
	public void setUtilidadMonetaria(Double utilidadMonetaria) {
		this.utilidadMonetaria = utilidadMonetaria;
	}
	public String getPresentacionVenta() {
		return presentacionVenta;
	}
	public void setPresentacionVenta(String presentacionVenta) {
		this.presentacionVenta = presentacionVenta;
	}
	public String getPresentacionCompra() {
		return presentacionCompra;
	}
	public void setPresentacionCompra(String presentacionCompra) {
		this.presentacionCompra = presentacionCompra;
	}
	public float getCantidadVenta() {
		return cantidadVenta;
	}

	public void setCantidadVenta(float cantidadVenta) {
		this.cantidadVenta = cantidadVenta;
	}

}
