package com.juanjo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.juanjo.entity.Marca;

public class MarcaDAOImpl implements MarcaDAO {
	
	private static final Logger log = LoggerFactory.getLogger(MarcaDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addMarca(Marca c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(c);
		log.info("Marca guardada correctamente, detalle: {}", c);
	}

	@Override
	public void updateMarca(Marca c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(c);
		log.info("Marca actualizada correctamente, detalle: {}", c);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Marca> listMarca() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Marca> listadoMarcas = session.createQuery("from Marca").list();
		return listadoMarcas;
	}

	@Override
	public Marca getMarca(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Marca c = (Marca) session.load(Marca.class, new Long(id));
		log.info("Marca encontrada, detalles: {}", c);
		return c;	
	}

	@Override
	public void removeMarca(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Marca c = (Marca) session.load(Marca.class, new Long(id));
		if(null != c){
			session.delete(c);
		}
		log.info("Marca eliminada exitosamente, detalles: {}", c);

	}

}
