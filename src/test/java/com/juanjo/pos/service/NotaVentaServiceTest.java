package com.juanjo.pos.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.juanjo.entity.DetalleVenta;
import com.juanjo.entity.NotaVenta;
import com.juanjo.entity.Producto;
import com.juanjo.service.NotaVentaService;
import com.juanjo.service.NotaVentaServiceImpl;

public class NotaVentaServiceTest {

	@Test
	public void creaNota() {
		NotaVenta nota = new NotaVenta();
		DetalleVenta detalle = new DetalleVenta();
		nota.setDetalleVenta(detalle);
		NotaVentaService service = new NotaVentaServiceImpl(); 
		service.crearNota(nota);
	}

}
