package com.juanjo.dao;

import com.juanjo.entity.NotaCompra;

import java.io.Serializable;

public interface NotaCompraDAO {
	
	public Serializable crearNotaCompra(NotaCompra nota);
	public NotaCompra getNotaCompra(long id);
	public void comprar(NotaCompra nota);
	public void devolver(NotaCompra nota);
	public void update(NotaCompra nota);
}
