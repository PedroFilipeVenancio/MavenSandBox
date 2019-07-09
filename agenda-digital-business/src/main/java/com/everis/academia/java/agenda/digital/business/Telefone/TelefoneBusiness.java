package com.everis.academia.java.agenda.digital.business.Telefone;


import java.util.Collection;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.business.IGeralBusiness;
import com.everis.academia.java.agenda.digital.dao.IGeralDAO;
import com.everis.academia.java.agenda.digital.dao.Telefone.TelefoneDAO;

import Entity.Telefone;

public class TelefoneBusiness implements IGeralBusiness<Telefone> {

	IGeralDAO<Telefone> dao = new TelefoneDAO();

	@Override
	public void delete(Telefone TelefoneVar) {
		dao.delete(TelefoneVar);
	}

	@Override
	public void update(Telefone TelefoneVar) throws BusinessException {
		// valida parametros
		if (TelefoneVar.getCodigo() == null) {
			throw new BusinessException("É obrigatorio");
		}

		// verifica se já existe
		if (dao.jaExiste(TelefoneVar)) {
			throw new BusinessException("já existe");
		}
		
		dao.update(TelefoneVar);
	}

	@Override
	public void create(Telefone TelefoneVar) throws BusinessException {

		// valida parametros
		if (TelefoneVar.getCodigo() == null) {
			throw new BusinessException("É obrigatorio");
		}

		// verifica se já existe
		if (dao.jaExiste(TelefoneVar)) {
			throw new BusinessException("já existe");
		}

		dao.create(TelefoneVar);
	}

	@Override
	public Collection<Telefone> read() {
		// TODO Auto-generated method stub
		return dao.read();
	}

	@Override
	public Telefone getById(Integer codigo) {
		Telefone TelefoneFound = null;
		for (Telefone telefone : dao.read()) {
			if (telefone.equals(new Telefone(codigo))) {
				TelefoneFound = telefone;
			}
		}
		return TelefoneFound;
	}

}



