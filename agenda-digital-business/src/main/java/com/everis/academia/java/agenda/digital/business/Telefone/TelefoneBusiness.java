package com.everis.academia.java.agenda.digital.business.Telefone;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.dao.Telefone.ITelefoneDAO;
import com.everis.academia.java.agendadigital.entity.Telefone;
@Service
public class TelefoneBusiness implements ITelefoneBusiness {

//	ITelefoneDAO dao = new TelefoneDAO();
	
	@Autowired
	private ITelefoneDAO dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Telefone TelefoneVar) {
		dao.delete(TelefoneVar);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
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
	@Transactional(propagation = Propagation.REQUIRED)
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
	@Transactional(readOnly = true)
	public Collection<Telefone> read() {
		// TODO Auto-generated method stub
		return dao.read();
	}

	@Override
	@Transactional(readOnly = true)
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



