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
	@Column(name = "existencia_maxima")
	private Double max;
	@Column(name = "existencia_minima")
	private Double min;
	@Column(name = "existencia_virtual")
	private Double existenciaVirtual;
	@Column(name = "existencia")
	private Double existencia;
	@Column(name = "precio_compra_ultimo")
	private Double precioCompraUltimo;
	@Column(name = "precio_compra_promedio")
	private Double precioCompraPromedio;
	@Column(name = "precio_venta_minimo")
	private Double precioVentaMinimo;
	@Column(name = "precio_venta_calculado")
	private Double precioVentaCalculado;
	@Column(name = "precio_venta")
	private Double precioVenta;
	@Column(name = "id_presentacion_venta")
	private String presentacionVenta;
	@Column(name = "id_presentacion_compra")
	private String presentacionCompra;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
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
	
	public Double getExistenciaVirtual() {
		return existenciaVirtual;
	}
	
	public void setExistenciaVirtual(Double existenciaVirtual) {
		this.existenciaVirtual = existenciaVirtual;
	}
	
	public Double getExistencia() {
		return existencia;
	}
	
	public void setExistencia(Double existencia) {
		this.existencia = existencia;
	}
	
	public Double getPrecioCompraUltimo() {
		return precioCompraUltimo;
	}
	
	public void setPrecioCompraUltimo(Double precioCompraUltimo) {
		this.precioCompraUltimo = precioCompraUltimo;
	}
	
	public Double getPrecioCompraPromedio() {
		return precioCompraPromedio;
	}
	
	public void setPrecioCompraPromedio(Double precioCompraPromedio) {
		this.precioCompraPromedio = precioCompraPromedio;
	}
	
	public Double getPrecioVentaMinimo() {
		return precioVentaMinimo;
	}
	
	public void setPrecioVentaMinimo(Double precioVentaMinimo) {
		this.precioVentaMinimo = precioVentaMinimo;
	}
	
	public Double getPrecioVentaCalculado() {
		return precioVentaCalculado;
	}
	
	public void setPrecioVentaCalculado(Double precioVentaCalculado) {
		this.precioVentaCalculado = precioVentaCalculado;
	}
	
	public Double getPrecioVenta() {
		return precioVenta;
	}
	
	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
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
	
	@Override
	public String toString() {
		return "ProductoAlmacenado{" +
							 "id=" + id +
							 ", producto=" + producto +
							 ", max=" + max +
							 ", min=" + min +
							 ", existenciaVirtual=" + existenciaVirtual +
							 ", existencia=" + existencia +
							 ", precioCompraUltimo=" + precioCompraUltimo +
							 ", precioCompraPromedio=" + precioCompraPromedio +
							 ", precioVentaMinimo=" + precioVentaMinimo +
							 ", precioVentaCalculado=" + precioVentaCalculado +
							 ", precioVenta=" + precioVenta +
							 ", presentacionVenta='" + presentacionVenta + '\'' +
							 ", presentacionCompra='" + presentacionCompra + '\'' +
							 '}';
	}
}
