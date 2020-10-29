package com.juanjo.entity.view;

import com.juanjo.entity.DetalleVenta;
import com.juanjo.entity.NotaVenta;
import com.juanjo.entity.ProductoAlmacenado;

public class DetalleVentaView {
	
	private Long id;
	private NotaVentaView notaVentaView;
	private ProductoAlmacenado productoVenta;
	private Double unidades;
	private Double montoTotal;
	private int rowNum;
	private Double totalLinea;
	
	public DetalleVentaView(DetalleVenta detalleEntity) {
		this.id = detalleEntity.getId();
		this.notaVentaView = new NotaVentaView(detalleEntity.getNotaVenta());
		this.productoVenta = detalleEntity.getProductoVenta();
		this.unidades = detalleEntity.getUnidades();
		this.montoTotal = detalleEntity.getMontoTotal();
		this.rowNum = detalleEntity.getRowNum();
		this.totalLinea = detalleEntity.getTotalLinea();
	}
	
	public DetalleVentaView() {
	}
	
	public DetalleVenta getEntity(){
		DetalleVenta entity = new DetalleVenta();
		entity.setId(this.id);
		entity.setUnidades(this.unidades);
		entity.setMontoTotal(this.montoTotal);
		entity.setRowNum(this.rowNum);
		entity.setTotalLinea(this.totalLinea);
		entity.setProductoVenta(this.productoVenta);
		entity.setNotaVenta(this.notaVentaView.getNotaVentaEntity());
		return entity;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public NotaVentaView getNotaVentaView() {
		return notaVentaView;
	}
	
	public void setNotaVentaView(NotaVentaView notaVenta) {
		this.notaVentaView = notaVenta;
	}
	
	public ProductoAlmacenado getProductoVenta() {
		return productoVenta;
	}
	
	public void setProductoVenta(ProductoAlmacenado productoVenta) {
		this.productoVenta = productoVenta;
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
}
