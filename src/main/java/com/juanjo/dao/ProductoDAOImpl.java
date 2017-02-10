package com.juanjo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.juanjo.entity.Producto;

public class ProductoDAOImpl implements ProductoDAO {
	
	private static final Logger log = LoggerFactory.getLogger(ProductoDAOImpl.class);
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addProducto(Producto p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(p);
		log.info("Producto guardado correctamente, producto: {}", p);
	}

	@Override
	public void updateProducto(Producto p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		log.info("Producto Actualizado correctamente, producto: {}", p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> listProducto() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Producto> listadoProductos =  session.createQuery("from Producto").list();
		return listadoProductos;
	}

	@Override
	public Producto getProducto(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Producto p = (Producto)session.get(Producto.class, id);
		log.info("Producto encontrado: {}", p);
		return p;
	}

	@Override
	public void removeProducto(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Producto p = (Producto) session.load(Producto.class, id);
		if(null != p){
			session.delete(p);
		}
	}

	@Override
	public Producto getPrecioPorClaveAlterna(String claveAlterna) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("From Producto where claveAlterna like :claveAlt");
		query.setParameter("claveAlt", '%'+claveAlterna+'%');
		return (Producto) query.uniqueResult();
	}

	@Override
	public Producto getPrecioPorBarcode(String barcode) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("From Producto where clave like :cve");
		query.setParameter("cve", '%'+barcode+'%');
		return (Producto) query.uniqueResult();
	}

}
