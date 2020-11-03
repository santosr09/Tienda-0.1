package com.juanjo.dao;

import com.juanjo.entity.Presentacion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PresentacionDAOImpl implements PresentacionDAO {
	
	private static final Logger log = LoggerFactory.getLogger(PresentacionDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addPresentacion(Presentacion p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(p);
		log.info("Presentacion guardado correctamente, Presentacion: {}", p);
	}
	
	@Override
	public void updatePresentacion(Presentacion p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		log.info("Presentacion Actualizado correctamente, Presentacion: {}", p);
	}
	
	@Override
	public List<Presentacion> listPresentacion() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Presentacion> listadoPresentaciones =  session.createQuery("from Presentacion").list();
		return listadoPresentaciones;
	}
	
	@Override
	public Presentacion getPresentacion(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Presentacion p = (Presentacion)session.get(Presentacion.class, id);
		log.info("Presentacion encontrado: {}", p);
		return p;
	}
	
	@Override
	public void removePresentacion(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Presentacion p = (Presentacion) session.load(Presentacion.class, id);
		if(null != p){
			session.delete(p);
		}
	}
}
