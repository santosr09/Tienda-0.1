package com.juanjo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juanjo.dao.CategoriaDAO;
import com.juanjo.entity.Categoria;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	private CategoriaDAO dao = null;
	
	public void setDao(CategoriaDAO categoriaDAO){
		this.dao = categoriaDAO;
	}

	@Transactional
	public void addCategoria(Categoria c) {
		this.dao.addCategoria(c);
	}

	@Transactional
	public void updateCategoria(Categoria c) {
		this.dao.updateCategoria(c);
	}

	@Transactional
	public List<Categoria> listCategoria() {
		return this.dao.listCategoria();
	}

	@Transactional
	public Categoria getCategoria(long id) {
		return this.dao.getCategoria(id);
	}

	@Transactional
	public void removeCategoria(long id) {
		this.dao.removeCategoria(id);
	}

}
