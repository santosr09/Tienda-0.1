package com.juanjo.dao;

import com.juanjo.entity.Proveedor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ProveedorDAOImpl implements ProveedorDAO {
	
	private static final Logger log = LoggerFactory.getLogger(ProveedorDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addProveedor(Proveedor p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(p);
		log.info("Proveedor guardado correctamente, Proveedor: {}", p);
	}
	
	@Override
	public void updateProveedor(Proveedor p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		log.info("Proveedor Actualizado correctamente, Proveedor: {}", p);
	}
	
	@Override
	public List<Proveedor> listProveedor() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Proveedor> listadoProveedores =  session.createQuery("from Proveedor").list();
		return listadoProveedores;
	}
	
	@Override
	public Proveedor getProveedor(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Proveedor p = (Proveedor)session.get(Proveedor.class, id);
		log.info("Proveedor encontrado: {}", p);
		return p;
	}
	
	@Override
	public void removeProveedor(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Proveedor p = (Proveedor) session.load(Proveedor.class, id);
		if(null != p){
			session.delete(p);
		}
	}
}
