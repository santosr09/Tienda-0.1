package com.juanjo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="nota_venta")
public class NotaVenta implements Serializable{

	private static final long serialVersionUID = 7993089341801405296L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
/*	@Id
	@GeneratedValue(generator="nota_seq")
	@SequenceGenerator(name="nota_seq", sequenceName="nota_id_seq")*/
	private Long id;
	
	@Column(name = "fecha_hora")
	private String fechaHora;
	
	@Column(name = "monto_total")
	private Double montoTotal;
	
	@Column(name = "total_articulos")
	private Double totalArticulos;
	
	@OneToMany(mappedBy = "notaVenta", cascade = {CascadeType.ALL})
	//@JoinColumn(name="id_detalle")
	private List<DetalleVenta> detalleVenta;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}
	public Double getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(Double montoTotal) {
		this.montoTotal = montoTotal;
	}
	@JsonIgnore
	public List<DetalleVenta> getDetalleVenta() {
		return detalleVenta;
	}
	public void setDetalleVenta(List<DetalleVenta> detalleVenta) {
		this.detalleVenta = detalleVenta;
	}
	
	@Override
	public String toString() {
		return "NotaVenta [id=" + id + ", fechaHora=" + fechaHora +", montoTotal=" + montoTotal
				+ ", detalleVenta=" + detalleVenta + "]";
	}

}
