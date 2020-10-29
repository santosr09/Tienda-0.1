package com.juanjo.pos.service;

import com.juanjo.dao.NotaVentaDAO;
import com.juanjo.dao.ProductoAlmacenadoDAO;

import com.juanjo.entity.NotaVenta;
import com.juanjo.entity.view.NotaVentaView;
import com.juanjo.service.NotaVentaService;
import com.juanjo.service.NotaVentaServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.Serializable;

import static org.mockito.ArgumentMatchers.any;

public class NotaVentaServiceTest {
	
	NotaVentaService notaVentaService = new NotaVentaServiceImpl();
	@Mock
	NotaVentaDAO notaVentaDAO;
	@Mock
	ProductoAlmacenadoDAO almacenDAO;
	
	@BeforeEach
	private void setUpCrearNota(){
		MockitoAnnotations.initMocks(this);
		NotaVenta notaEntityMocked = new NotaVenta();
		notaEntityMocked.setId(1L);
		Mockito.when(notaVentaDAO.crearNotaVenta(any(NotaVentaView.class))).thenReturn(notaEntityMocked);
		Mockito.when(notaVentaDAO.getNotaVenta(any())).thenReturn(notaEntityMocked);
		notaVentaService.setNotaVentaDAO(notaVentaDAO);
	}
	
	@Test
	public void creaNota() {
		NotaVentaView notaView = new NotaVentaView();
		NotaVenta notaEntity = notaVentaService.crearNota(notaView);
		Assertions.assertNotNull(notaEntity);
	}

}
