package com.juanjo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.juanjo.entity.NotaVenta;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class NotaVentaDAOImpl implements NotaVentaDAO{
	
private static final Logger LOGGER = LoggerFactory.getLogger(NotaVentaDAOImpl.class);
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	@Override
	public void vender(NotaVenta nota) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(nota);
		LOGGER.info("nota Actualizado correctamente, nota: {}", nota);
	}

	@Override
	public void devolver(NotaVenta nota) {
		// TODO Auto-generated method stub
		
	}
	
	@Transactional
	@Override
	public void update(NotaVenta nota) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(nota);
		LOGGER.info("nota Actualizada correctamente, nota: {}", nota);
	}
	
	@Transactional
	@Override
	public NotaVenta crearNotaVenta(NotaVenta nota) {
		Session session = this.sessionFactory.getCurrentSession();
		Long id = (Long) session.save(nota);
		NotaVenta newNota = (NotaVenta) session.get(NotaVenta.class, id);
		LOGGER.info("NotaVenta creada: {}", newNota);
		return newNota;
	}
	
	@Transactional
	@Override
	public NotaVenta getNotaVenta(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		NotaVenta nota = (NotaVenta)session.get(NotaVenta.class, id);
		LOGGER.info("Nota encontrada: {}", nota);
		return nota;
	}
	

}
