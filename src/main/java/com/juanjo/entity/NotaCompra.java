package com.juanjo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="nota_compra")
public class NotaCompra implements Serializable {

	private static final long serialVersionUID = 7993089341801405296L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_proveedor")
	private Proveedor proveedor;
	
	@Column(name = "fecha_hora")
	private String fechaHora;
	
	@Column(name = "folio_nota")
	private String folioNota;
	
	@Column(name = "total_articulos")
	private Double totalArticulos;
	
	@Column(name = "monto_total")
	private Double montoTotal;
	
	@OneToMany(mappedBy = "notaCompra",  cascade = {CascadeType.ALL})
	private List<DetalleCompra> detalleCompra;
	
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Proveedor getProveedor() {
		return proveedor;
	}
	
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	public String getFechaHora() {
		return fechaHora;
	}
	
	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}
	
	public String getFolioNota() {
		return folioNota;
	}
	
	public void setFolioNota(String folioNota) {
		this.folioNota = folioNota;
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
	
	public List<DetalleCompra> getDetalleCompra() {
		return detalleCompra;
	}
	
	public void setDetalleCompra(List<DetalleCompra> detalleCompraList) {
		this.detalleCompra = detalleCompraList;
	}
}
