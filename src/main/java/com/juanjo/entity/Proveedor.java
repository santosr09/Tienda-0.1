package com.juanjo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="proveedor")
public class Proveedor implements Serializable {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="telefono1")
	private String telefono1;
	
	@Column(name="telefono2")
	private String telefono2;
	
	@Column(name="email")
	private String email;
	
	@Column(name="status")
	private int Status;
	
}
