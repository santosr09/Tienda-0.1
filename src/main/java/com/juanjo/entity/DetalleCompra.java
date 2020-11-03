package com.juanjo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="detalle_compra")
public class DetalleCompra implements Serializable {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_nota_compra")
	private NotaCompra notaCompra;
	
	@Column(name="id_producto")
	private ProductoAlmacenado productoAlmacenado;
	
	@Column(name="id_presentacion_compra")
	private Presentacion presentacionCompra;
	
	@Column(name="unidades")
	private Double unidades;
	
	@Column(name="monto_total")
	private Double montoTotal;
	
	@Column(name="iva")
	private Double iva;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public NotaCompra getNotaCompra() {
		return notaCompra;
	}
	
	public void setNotaCompra(NotaCompra notaCompra) {
		this.notaCompra = notaCompra;
	}
	
	public ProductoAlmacenado getProductoAlmacenado() {
		return productoAlmacenado;
	}
	
	public void setProductoAlmacenado(ProductoAlmacenado productoAlmacenado) {
		this.productoAlmacenado = productoAlmacenado;
	}
	
	public Presentacion getPresentacionCompra() {
		return presentacionCompra;
	}
	
	public void setPresentacionCompra(Presentacion presentacionCompra) {
		this.presentacionCompra = presentacionCompra;
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
	
	public Double getIva() {
		return iva;
	}
	
	public void setIva(Double iva) {
		this.iva = iva;
	}
}
