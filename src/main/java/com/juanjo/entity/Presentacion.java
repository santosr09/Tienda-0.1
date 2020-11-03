package com.juanjo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="cat_presentacion")
public class Presentacion implements Serializable {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	/*For Use with PostgreSQL
	@GeneratedValue(generator="presentacion_seq")
	@SequenceGenerator(name="presentacion_seq", sequenceName="presentacion_id_seq")
	*/
	private long id = 0;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="unidades_contenidas")
	private int unidadesContenidas;
	
	@Column(name="factor_conversion")
	private int factorConversion;
	
	@Column(name="status")
	private int status;
	
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
	
	public int getUnidadesContenidas() {
		return unidadesContenidas;
	}
	
	public void setUnidadesContenidas(int unidadesContenidas) {
		this.unidadesContenidas = unidadesContenidas;
	}
	
	public int getFactorConversion() {
		return factorConversion;
	}
	
	public void setFactorConversion(int factorConversion) {
		this.factorConversion = factorConversion;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
}
