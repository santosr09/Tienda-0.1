package com.juanjo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.juanjo.entity.ProductoAlmacenado;


public class ProductoAlmacenadoDAOImpl implements ProductoAlmacenadoDAO {
	
	private static final Logger log = LoggerFactory.getLogger(ProductoAlmacenadoDAOImpl.class);
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addProducto(ProductoAlmacenado p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(p);
		log.info("Producto guardado correctamente, producto: {}", p);
	}

	@Override
	public void updateProducto(ProductoAlmacenado p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		log.info("Producto Actualizado correctamente, producto: {}", p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductoAlmacenado> listProducto() {
		Session session = this.sessionFactory.getCurrentSession();
		List<ProductoAlmacenado> listadoProductos =  session.createQuery("from ProductoAlmacenado").list();
		return listadoProductos;
	}

	@Override
	public ProductoAlmacenado getProducto(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		ProductoAlmacenado p = (ProductoAlmacenado)session.get(ProductoAlmacenado.class, id);
		log.info("Producto encontrado: {}", p);
		return p;
	}

	@Override
	public void removeProducto(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		ProductoAlmacenado p = (ProductoAlmacenado) session.load(ProductoAlmacenado.class, id);
		if(null != p){
			session.delete(p);
		}
	}

	@Override
	public ProductoAlmacenado getProductoPorClaveAlterna(String claveAlterna) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("From ProductoAlmacenado where producto.claveAlterna like :claveAlt");
		query.setParameter("claveAlt", '%'+claveAlterna+'%');
		return (ProductoAlmacenado) query.uniqueResult();
	}

	@Override
	public ProductoAlmacenado getProductoPorBarcode(String barcode) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("From ProductoAlmacenado where producto.clave = :cve");
		query.setParameter("cve", barcode);
		//query.setParameter("cve", '%'+barcode+'%');
		return (ProductoAlmacenado) query.uniqueResult();
	}

	@Override
	public void descontarProductoAlmacen(String barcode, Double cantidad) {
		Session session = this.sessionFactory.getCurrentSession();
		ProductoAlmacenado producto = this.getProductoPorBarcode(barcode);
		producto.setExistencia(producto.getExistencia() - cantidad);
		session.update(producto);
	}

	@Override
	public void devolverProductoAlmacen(String barcode, Double cantidad) {
		Session session = this.sessionFactory.getCurrentSession();
		ProductoAlmacenado producto = this.getProductoPorBarcode(barcode);
		producto.setExistencia(producto.getExistencia() - cantidad);
		session.update(producto);
		
	}

}
