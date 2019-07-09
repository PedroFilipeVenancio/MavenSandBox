package com.everis.academia.java.agenda.digital.business.Telefone;


import java.util.Collection;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.business.IGeralBusiness;
import com.everis.academia.java.agenda.digital.dao.IGeralDAO;
import com.everis.academia.java.agenda.digital.dao.Cidade.CidadeDAO;

import Entity.Cidade;

public class TelefoneBusiness implements IGeralBusiness<Cidade> {

	IGeralDAO<Cidade> dao = new CidadeDAO();

	@Override
	public void delete(Cidade cidade) {
		dao.delete(cidade);
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
	public Collection<Cidade> read() {
		// TODO Auto-generated method stub
		return dao.read();
	}

	@Override
	public Cidade getById(Integer codigo) {
		Cidade cidadeFound = null;
		for (Cidade cidade : dao.read()) {
			if (cidade.equals(new Cidade(codigo))) {
				cidadeFound = cidade;
			}
		}
		return cidadeFound;
	}

}



