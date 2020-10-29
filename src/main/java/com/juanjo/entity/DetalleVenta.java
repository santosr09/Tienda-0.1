package com.juanjo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="detalle_venta")
public class DetalleVenta implements Serializable{

	private static final long serialVersionUID = 6509739476145987181L;
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int rowNum;
	private Double totalLinea;
	
	@Id
	@GeneratedValue(generator="nota_detalle_seq")
	@SequenceGenerator(name="nota_detalle_seq", sequenceName="nota_detalle_id_seq")
	private Long id;
	@ManyToOne
	@JoinColumn(name="id_nota_venta")
	private NotaVenta notaVenta;
	@OneToOne
	@JoinColumn(name="id_producto")
	private ProductoAlmacenado productoVenta;
	@Column(name="unidades")
	private Double unidades;
	@Column(name="monto_total")
	private Double montoTotal;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public NotaVenta getNotaVenta() {
		return notaVenta;
	}
	public void setNotaVenta(NotaVenta notaVenta) {
		this.notaVenta = notaVenta;
	}
	public ProductoAlmacenado getProductoVenta() {
		return productoVenta;
	}
	public void setProductoVenta(ProductoAlmacenado productoVenta) {
		this.productoVenta = productoVenta;
	}
	public int getRowNum() {
		return rowNum;
	}
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
	public Double getTotalLinea() {
		return totalLinea;
	}
	public void setTotalLinea(Double totalLinea) {
		this.totalLinea = totalLinea;
	}
	
	public Double getUnidades() {
		return unidades;
	}
	
	public void setUnidades(Double unidades) {
		this.unidades = unidades;
	}
	
	public Double getMontoTotal() {
		return montoTotal;
	}
	
	public void setMontoTotal(Double montoTotal) {
		this.montoTotal = montoTotal;
	}
	
}
