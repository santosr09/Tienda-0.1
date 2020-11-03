package com.juanjo.dao;

import com.juanjo.entity.Presentacion;

import java.util.List;

public interface PresentacionDAO {
	
	public void addPresentacion(Presentacion p);
	public void updatePresentacion(Presentacion p);
	public List<Presentacion> listPresentacion();
	public Presentacion getPresentacion(long id);
	public void removePresentacion(long id);
}
