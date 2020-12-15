package com.juanjo.pos.service;


import com.juanjo.dao.NotaVentaDAO;
import com.juanjo.entity.DetalleVenta;
import com.juanjo.entity.NotaVenta;
import com.juanjo.entity.Producto;
import com.juanjo.service.NotaVentaService;
import com.juanjo.service.NotaVentaServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;

import java.util.List;

import static org.mockito.Mockito.*;

public class NotaVentaServiceTest {
	
	static NotaVentaDAO daoMock;
	
	@Captor
	ArgumentCaptor<NotaVenta> notaCaptor;
	
	@BeforeAll
	private static void setUp() {
		daoMock = mock(NotaVentaDAO.class);
		NotaVenta newNota = new NotaVenta();
		newNota.setId(1L);
		when(daoMock.crearNotaVenta(newNota)).thenReturn(newNota);
	}
	

	@Test
	public void creaNota() {
		NotaVenta nota = new NotaVenta();
		DetalleVenta detalle = new DetalleVenta();
		NotaVentaService service = new NotaVentaServiceImpl();
		((NotaVentaServiceImpl) service).setDaoNota(daoMock);
		NotaVenta notaNew = service.crearNota();
		
		
		ArgumentCaptor< NotaVenta > notaCapture = ArgumentCaptor.forClass( NotaVenta.class );
		verify( this.daoMock ).crearNotaVenta(notaCapture.capture() );
		System.out.println(notaCapture.getValue());
	}

}
