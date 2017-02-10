package com.juanjo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="producto_almacen")
public class ProductoAlmacenado implements Serializable{

	private static final long serialVersionUID = -723854516359569969L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	@JoinColumn(name="id_producto")
	private Producto producto;
	@Column(name = "max")
	private Double max;
	@Column(name = "min")
	private Double min;
	@Column(name = "existencia")
	private Double existencia;
	@Column(name = "precio_venta")
	private Double precioVenta;
	@Column(name = "precio_compra")
	private Double precioCompra;
	@Column(name = "utilidad_porcentaje")
	private Double utilidadPorcentaje;
	@Column(name = "utilidad_monetaria")
	private Double utilidadMonetaria;
	@Column(name = "presentacion_venta")
	private String presentacionVenta;
	@Column(name = "presentacion_compra")
	private String presentacionCompra;
	
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
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

}
