package com.juanjo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juanjo.dao.MarcaDAO;
import com.juanjo.entity.Marca;

@Service
public class MarcaServiceImpl implements MarcaService {
	
	private MarcaDAO dao = null;
	
	public void setDao(MarcaDAO dao){
		this.dao = dao;
	}

	@Transactional
	public void addMarca(Marca c) {
		dao.addMarca(c);
	}

	@Transactional
	public void updateMarca(Marca c) {
		dao.updateMarca(c);
	}

	@Transactional
	public List<Marca> listMarca() {
		return dao.listMarca();
	}

	@Transactional
	public Marca getMarca(long id) {
		return dao.getMarca(id);
	}

	@Transactional
	public void removeMarca(long id) {
		dao.removeMarca(id);
	}

}
