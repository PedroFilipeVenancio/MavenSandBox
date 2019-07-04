package com.everis.academia.java.agenda.digital.business.impl;

import java.util.List;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.business.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.dao.ICidadeDAO;
import com.everis.academia.java.agenda.digital.dao.impl.CidadeDAO;
import com.everis.academia.java.agenda.digital.dao.impl.CidadeDAO2;

import Entity.Cidade;

public class CidadeBusiness implements ICidadeBusiness<Cidade> {

	ICidadeDAO<Cidade> dao = new CidadeDAO2();

	@Override
	public Boolean delete(Cidade cidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Cidade cidade) throws BusinessException {
		// valida parametros
		if (cidade.getNome() == null || cidade.getNome().trim().isEmpty()) {
			throw new BusinessException("É obrigatorio");
		}

		// verifica se já existe
		if (dao.jaExiste(cidade.getNome())) {
			throw new BusinessException("já existe");
		}
		
		dao.update(cidade);
	}

	@Override
	public void create(Cidade cidade) throws BusinessException {

		// valida parametros
		if (cidade.getNome() == null || cidade.getNome().trim().isEmpty()) {
			throw new BusinessException("É obrigatorio");
		}

		// verifica se já existe
		if (dao.jaExiste(cidade.getNome())) {
			throw new BusinessException("já existe");
		}

		if (!cidade.getNome().matches("[a-zA-Z]+")) {
			throw new BusinessException("Formato errado");

		}

		dao.create(cidade);
	}

	@Override
	public List<Cidade> read() {
		// TODO Auto-generated method stub
		return null;
	}

}
