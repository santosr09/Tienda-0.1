package com.juanjo.entity.view;

import com.juanjo.entity.DetalleVenta;
import com.juanjo.entity.NotaVenta;

import java.util.List;

public class NotaVentaView {
	private String folio="0";
	private String fechaHora;
	private String cliente;
	private String vendedor;
	private Double totalArticulos=0.0;
	private Double montoTotal=0.0;
	private List<DetalleVenta> detalleVenta;
	
	public NotaVentaView(NotaVenta notaEntity) {
		this.folio = String.valueOf(notaEntity.getId());
		this.fechaHora = notaEntity.getFechaHora();
		this.cliente = notaEntity.getCliente();
		this.vendedor = notaEntity.getVendedor();
		this.totalArticulos = notaEntity.getTotalArticulos();
		this.montoTotal = notaEntity.getMontoTotal();
		this.detalleVenta = notaEntity.getDetalleVenta();
	}
	
	public NotaVentaView() { }
	
	public NotaVenta getNotaVentaEntity(){
		NotaVenta notaEntity = new NotaVenta();
		notaEntity.setId(Long.valueOf(this.folio));
		notaEntity.setFechaHora(this.fechaHora );
		notaEntity.setCliente(this.cliente);
		notaEntity.setVendedor(this.vendedor);
		notaEntity.setTotalArticulos(this.totalArticulos);
		notaEntity.setMontoTotal(this.montoTotal);
		notaEntity.setDetalleVenta(this.detalleVenta);
		return notaEntity;
	}
	
	public String getFolio() {
		return folio;
	}
	
	public void setFolio(String folio) {
		this.folio = folio;
	}
	
	public String getFechaHora() {
		return fechaHora;
	}
	
	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}
	
	public String getCliente() {
		return cliente;
	}
	
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	public String getVendedor() {
		return vendedor;
	}
	
	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
	
	public Double getTotalArticulos() {
		return totalArticulos;
	}
	
	public void setTotalArticulos(Double totalArticulos) {
		this.totalArticulos = totalArticulos;
	}
	
	public Double getMontoTotal() {
		return montoTotal;
	}
	
	public void setMontoTotal(Double montoTotal) {
		this.montoTotal = montoTotal;
	}
	
	public List<DetalleVenta> getDetalleVenta() {
		return detalleVenta;
	}
	
	public void setDetalleVenta(List<DetalleVenta> detalleVenta) {
		this.detalleVenta = detalleVenta;
	}
	
	@Override
	public String toString() {
		return "NotaVentaView{" +
							 "folio='" + folio + '\'' +
							 ", fechaHora='" + fechaHora + '\'' +
							 ", cliente='" + cliente + '\'' +
							 ", vendedor='" + vendedor + '\'' +
							 ", totalArticulos=" + totalArticulos +
							 ", montoTotal=" + montoTotal +
							 ", detalleVenta=" + detalleVenta +
							 '}';
	}
}
