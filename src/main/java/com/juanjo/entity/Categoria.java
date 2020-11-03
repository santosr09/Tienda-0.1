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
@Table(name="categoria")
public class Categoria implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	/*For Use with PostgreSQL
	@GeneratedValue(generator="categoria_seq")
	@SequenceGenerator(name="categoria_seq", sequenceName="categoria_id_seq")
	*/
	private long id = 0;
	
	@Column(name="nombre")
	private String nombre = null;
	
	@OneToMany(mappedBy="categoria")
	private Set<Producto> productos;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Set<Producto> getProductos() {
		return productos;
	}
	
	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}
	
	@Override
	public String toString() {
		return "Categoria{" +
							 "id=" + id +
							 ", nombre='" + nombre + '\'' +
							 ", productos=" + productos +
							 '}';
	}
}
