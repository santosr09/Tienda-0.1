package com.juanjo.dao;

import com.juanjo.entity.NotaCompra;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class NotaCompraDAOImpl implements NotaCompraDAO {
	
	private static final Logger log = LoggerFactory.getLogger(NotaCompraDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Serializable crearNotaCompra(NotaCompra nota) {
		Session session = this.sessionFactory.getCurrentSession();
		Serializable serial = session.save(nota);
		log.info("NotaCompra creada exitosamente, serial: {}", serial);
		System.out.println("NotaCompra creada exitosamente, serial: {}"+ serial);
		return serial;
	}
	
	@Override
	public NotaCompra getNotaCompra(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		NotaCompra nota = (NotaCompra)session.get(NotaCompra.class, id);
		log.info("Nota encontrada: {}", nota);
		return nota;
	}
	
	@Override
	public void comprar(NotaCompra nota) {
	
	}
	
	@Override
	public void devolver(NotaCompra nota) {
	
	}
}
