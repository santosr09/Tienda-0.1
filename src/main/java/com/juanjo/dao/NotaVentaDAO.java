package com.juanjo.dao;

import java.io.Serializable;

import com.juanjo.entity.NotaVenta;
import com.juanjo.entity.view.NotaVentaView;

public interface NotaVentaDAO {
	
	public NotaVenta crearNotaVenta(NotaVentaView nota);
	public NotaVenta getNotaVenta(Long id);
	public void vender(NotaVenta nota);
	public void devolver(NotaVenta nota);

}
