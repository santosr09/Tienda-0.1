package com.juanjo.dao;

import com.juanjo.entity.Proveedor;

import java.util.List;

public interface ProveedorDAO {
	
	public void addProveedor(Proveedor p);
	public void updateProveedor(Proveedor c);
	public List<Proveedor> listProveedor();
	public Proveedor getProveedor(long id);
	public void removeProveedor(long id);
}
