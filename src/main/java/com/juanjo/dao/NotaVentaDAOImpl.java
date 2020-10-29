package com.juanjo.dao;

import java.io.Serializable;

import com.juanjo.entity.view.NotaVentaView;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.juanjo.entity.NotaVenta;
import com.juanjo.entity.Producto;

public class NotaVentaDAOImpl implements NotaVentaDAO{
	
private static final Logger log = LoggerFactory.getLogger(NotaVentaDAOImpl.class);
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void vender(NotaVenta nota) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void devolver(NotaVenta nota) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public NotaVenta crearNotaVenta(NotaVentaView nota) {
		Session session = this.sessionFactory.getCurrentSession();
		Serializable serial = session.save(nota.getNotaVentaEntity());
		log.info("DAO NotaVenta creada exitosamente, serial: {}", serial);
		return (NotaVenta) session.get(NotaVenta.class, serial);
	}

	@Override
	public NotaVenta getNotaVenta(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		NotaVenta nota = (NotaVenta)session.get(NotaVenta.class, id);
		log.info("Nota encontrada: {}", nota);
		return nota;
		
	}
	

}
