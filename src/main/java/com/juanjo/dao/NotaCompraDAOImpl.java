package com.juanjo.dao;

import com.juanjo.entity.NotaCompra;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.Serializable;

@Repository
public class NotaCompraDAOImpl implements NotaCompraDAO {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NotaCompraDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	@Override
	public Serializable crearNotaCompra(NotaCompra nota) {
		Session session = this.sessionFactory.getCurrentSession();
		Serializable serial = session.save(nota);
		LOGGER.info("NotaCompra creada exitosamente, serial: {}", serial);
		return serial;
	}
	
	@Transactional
	@Override
	public NotaCompra getNotaCompra(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		NotaCompra nota = (NotaCompra)session.get(NotaCompra.class, id);
		LOGGER.info("Nota encontrada: {}", nota);
		return nota;
	}
	
	@Transactional
	@Override
	public void comprar(NotaCompra nota) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(nota);
		LOGGER.info("nota Actualizada correctamente, nota: {}", nota);
	}
	
	@Override
	public void devolver(NotaCompra nota) {
	
	}
	
	@Transactional
	@Override
	public void update(NotaCompra nota) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(nota);
		LOGGER.info("nota Actualizada correctamente, nota: {}", nota);
	}
}
