package com.juanjo.dao;

import java.io.Serializable;

import com.juanjo.entity.NotaVenta;

public interface NotaVentaDAO {
	
	public Serializable crearNotaVenta(NotaVenta nota);
	public NotaVenta getNotaVenta(long id);
	public void vender(NotaVenta nota);
	public void devolver(NotaVenta nota);
	public void update(NotaVenta nota);

}
