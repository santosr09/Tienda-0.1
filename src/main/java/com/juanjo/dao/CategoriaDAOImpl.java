package com.juanjo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.juanjo.entity.Categoria;

@Repository
public class CategoriaDAOImpl implements CategoriaDAO{
	
	private static final Logger log = LoggerFactory.getLogger(CategoriaDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public void addCategoria(Categoria c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(c);
		log.info("Categoria guardada correctamente, detalle: {}", c);
	}

	public void updateCategoria(Categoria c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(c);
		log.info("Categoría actualizada correctamente, detalle: {}", c);
	}

	@SuppressWarnings("unchecked")
	public List<Categoria> listCategoria() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Categoria> listadoCategorias = session.createQuery("from Categoria").list();
		for(Categoria item: listadoCategorias){
			log.info("Categoria en lista::{}", item);
		}
		return listadoCategorias;
	}

	public Categoria getCategoria(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Categoria c = (Categoria) session.load(Categoria.class, new Long(id));
		log.info("Categoria encontrada, detalles: {}", c);
		return c;	
	}

	public void removeCategoria(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Categoria c = (Categoria) session.load(Categoria.class, new Long(id));
		if(null != c){
			session.delete(c);
		}
		log.info("Categoria eliminada exitosamente, detalles: {}", c);
	}

}
