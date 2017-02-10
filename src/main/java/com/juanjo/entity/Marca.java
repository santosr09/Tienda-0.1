package com.juanjo.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="marca")
public class Marca implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7729861377211744238L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	/* Use this for PostgreSql
	@GeneratedValue(generator="marca_seq")
	@SequenceGenerator(name="marca_seq", sequenceName="marca_id_seq")
	*/
	private long id = 0;
	@Column(name="descripcion")
	private String descripcion = null;
	@Column(name="status")
	private int status = 0;
	@OneToMany(mappedBy="marca")
	private Set<Producto> productos;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return  descripcion;
	}

}
