package com.juanjo.service;

import java.util.List;

import com.juanjo.entity.Marca;

public interface MarcaService {
	
	public void addMarca(Marca c);
	public void updateMarca(Marca c);
	public List<Marca> listMarca();
	public Marca getMarca(long id);
	public void removeMarca(long id);
}
