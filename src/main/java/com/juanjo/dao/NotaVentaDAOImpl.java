package com.juanjo.dao;

import java.io.Serializable;

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
	public Serializable crearNotaVenta(NotaVenta nota) {
		Session session = this.sessionFactory.getCurrentSession();
		Serializable serial = session.save(nota);
		log.info("NotaVenta creada exitosamente, serial: {}", serial);
		System.out.println("NotaVenta creada exitosamente, serial: {}"+ serial);
		return serial;
	}

	@Override
	public NotaVenta getNotaVenta(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		NotaVenta nota = (NotaVenta)session.get(NotaVenta.class, id);
		log.info("Nota encontrada: {}", nota);
		return nota;
		
	}
	

}
