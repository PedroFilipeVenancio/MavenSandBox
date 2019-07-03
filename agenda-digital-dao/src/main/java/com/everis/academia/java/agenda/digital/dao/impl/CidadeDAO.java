package com.everis.academia.java.agenda.digital.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.everis.academia.java.agenda.digital.dao.ICidadeDAO;

import Entity.Cidade;

public class CidadeDAO implements ICidadeDAO<Cidade> {
	
	public static List<Cidade> cidades = new ArrayList<Cidade>();

	private static int id = 0;

	@Override
	public void delete(Cidade cidade) {
		cidades.remove(cidade);
	}

	@Override
	public void update(Cidade cidade) {
		int indexOf = cidades.indexOf(cidade);
		cidades.set(indexOf, cidade);
	}

	@Override
	public void create(Cidade cidade) {
		id++;
		cidade.setCodigo(id);
		cidades.add(cidade);
		
	}

	@Override
	public List<Cidade> read() {
		// TODO Auto-generated method stub
		return cidades;
	}

	@Override
	public Boolean jaExiste(String nome) {
		
		for (Cidade cidade : CidadeDAO.cidades) {
			if (cidade.getNome().trim().equalsIgnoreCase(nome)) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

}
