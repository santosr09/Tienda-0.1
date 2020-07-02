package com.juanjo.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class Producto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4448367904344702300L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//Use this for PostgreSQL:
	//@GeneratedValue(generator="producto_seq")
	//@SequenceGenerator(name="producto_seq", sequenceName="productos_id_seq")
	private long id = 0;
	@Column(name = "clave")
	private String clave = null;
	@Column(name = "clave_alterna")
	private String claveAlterna = null;
	@Column(name = "descripcion")
	private String descripcion = null;
	@ManyToOne
	@JoinColumn(name="id_marca")
	private Marca marca = null;
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private Categoria categoria = null;
	@Column(name="status")
	private Integer status = 0;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return clave +" "+ descripcion;
	}
	
}
