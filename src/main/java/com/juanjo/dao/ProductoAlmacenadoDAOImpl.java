package com.juanjo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.juanjo.entity.ProductoAlmacenado;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ProductoAlmacenadoDAOImpl implements ProductoAlmacenadoDAO {
	
	private static final Logger log = LoggerFactory.getLogger(ProductoAlmacenadoDAOImpl.class);
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	@Override
	public void addProducto(ProductoAlmacenado p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(p);
		log.info("Producto guardado correctamente, producto: {}", p);
	}
	
	@Transactional
	@Override
	public void updateProducto(ProductoAlmacenado p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		log.info("Producto Actualizado correctamente, producto: {}", p);
	}
	
	@Transactional
	@Override
	public List<ProductoAlmacenado> listProducto() {
		Session session = this.sessionFactory.getCurrentSession();
		List<ProductoAlmacenado> listadoProductos =  session.createQuery("from ProductoAlmacenado").list();
		return listadoProductos;
	}
	
	@Transactional
	@Override
	public ProductoAlmacenado getProducto(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		ProductoAlmacenado p = (ProductoAlmacenado)session.get(ProductoAlmacenado.class, id);
		log.info("Producto encontrado: {}", p);
		return p;
	}
	
	@Transactional
	@Override
	public void removeProducto(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		ProductoAlmacenado p = (ProductoAlmacenado) session.load(ProductoAlmacenado.class, id);
		if(null != p){
			session.delete(p);
		}
	}
	
	@Transactional
	@Override
	public ProductoAlmacenado getProductoPorClaveAlterna(String claveAlterna) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("From ProductoAlmacenado where producto.claveAlterna like :claveAlt");
		query.setParameter("claveAlt", '%'+claveAlterna+'%');
		return (ProductoAlmacenado) query.uniqueResult();
	}
	
	@Transactional
	@Override
	public ProductoAlmacenado getProductoPorBarcode(String barcode) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("From ProductoAlmacenado where producto.clave = :cve");
		query.setParameter("cve", barcode);
		//query.setParameter("cve", '%'+barcode+'%');
		return (ProductoAlmacenado) query.uniqueResult();
	}
	
	@Transactional
	@Override
	public void descontarProductoAlmacen(String barcode, Double cantidad) {
		Session session = this.sessionFactory.getCurrentSession();
		ProductoAlmacenado producto = this.getProductoPorBarcode(barcode);
		producto.setExistencia(producto.getExistencia() - cantidad);
		session.update(producto);
	}
	
	@Transactional
	@Override
	public void devolverProductoAlmacen(String barcode, Double cantidad) {
		Session session = this.sessionFactory.getCurrentSession();
		ProductoAlmacenado producto = this.getProductoPorBarcode(barcode);
		producto.setExistencia(producto.getExistencia() - cantidad);
		session.update(producto);
	}

}
