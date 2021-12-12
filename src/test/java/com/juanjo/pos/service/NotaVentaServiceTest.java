package com.juanjo.pos.service;


import com.juanjo.dao.NotaVentaDAO;
import com.juanjo.entity.DetalleVenta;
import com.juanjo.entity.NotaVenta;
import com.juanjo.entity.ProductoAlmacenado;
import com.juanjo.service.NotaVentaService;
import com.juanjo.service.NotaVentaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NotaVentaServiceTest {
	
	NotaVentaDAO notaVentaDao;
	
	NotaVentaService service = new NotaVentaServiceImpl();
	
	@Captor
	ArgumentCaptor<NotaVenta> notaCaptor;
	
	@BeforeEach
	private void setUp() {
		notaVentaDao = mock(NotaVentaDAO.class);
		NotaVenta newNota = new NotaVenta();
		newNota.setId(1L);
		when(notaVentaDao.crearNotaVenta(newNota)).thenReturn(newNota);
	}
	

	@Test
	public void creaNota() {
		
		
		NotaVenta newNota = new NotaVenta();
		newNota.setId(1L);
		when(notaVentaDao.crearNotaVenta(newNota)).thenReturn(newNota);
		
		NotaVenta nota = new NotaVenta();
		DetalleVenta detalle = new DetalleVenta();
		((NotaVentaServiceImpl) service).setDaoNota(notaVentaDao);
		NotaVenta notaNew = service.crearNota();
		
		
		//ArgumentCaptor< NotaVenta > notaCapture = ArgumentCaptor.forClass( NotaVenta.class );
		
		//NotaVenta notaCreated =  daoMock.crearNotaVenta(notaNew);
		
		System.out.println(notaNew);
		
		//verify( this.daoMock ).crearNotaVenta(notaCapture.capture() );
		//System.out.println(notaCapture.getValue());
	}
	
	public void agregarProductoTest() {
		ProductoAlmacenado producto = new ProductoAlmacenado();
		NotaVenta notaNew = service.crearNota();
		service.agregarProducto(notaNew, producto);
	}

}
