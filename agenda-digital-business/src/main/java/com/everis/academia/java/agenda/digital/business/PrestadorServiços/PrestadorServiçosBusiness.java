package com.everis.academia.java.agenda.digital.business.PrestadorServiços;

import java.util.Collection;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.business.IGeralBusiness;
import com.everis.academia.java.agenda.digital.dao.IGeralDAO;
import com.everis.academia.java.agenda.digital.dao.PrestadorServiços.PrestadorServiçosDAO;

import Entity.PrestadorServico;

public class PrestadorServiçosBusiness implements IGeralBusiness<PrestadorServico> {

	IGeralDAO<PrestadorServico> dao = new PrestadorServiçosDAO();

	@Override
	public void delete(PrestadorServico prestadorServicoVar) {
		dao.delete(prestadorServicoVar);
	}

	@Override
	public void update(PrestadorServico prestadorServicoVar) throws BusinessException {
		// valida parametros
		if (prestadorServicoVar.getNome() == null || prestadorServicoVar.getNome().trim().isEmpty()) {
			throw new BusinessException("É obrigatorio");
		}

		// verifica se já existe
		if (dao.jaExiste(prestadorServicoVar)) {
			throw new BusinessException("já existe");
		}
		
		dao.update(prestadorServicoVar);
	}

	@Override
	public void create(PrestadorServico prestadorServicoVar) throws BusinessException {

		// valida parametros
		if (prestadorServicoVar.getNome() == null || prestadorServicoVar.getNome().trim().isEmpty()) {
			throw new BusinessException("É obrigatorio");
		}

		// verifica se já existe
		if (dao.jaExiste(prestadorServicoVar)) {
			throw new BusinessException("já existe");
		}

		if (!prestadorServicoVar.getNome().matches("[a-zA-Z]+")) {
			throw new BusinessException("Formato errado");

		}

		dao.create(prestadorServicoVar);
	}

	@Override
	public Collection<PrestadorServico> read() {
		// TODO Auto-generated method stub
		return dao.read();
	}

	@Override
	public PrestadorServico getById(Integer codigo) {
		PrestadorServico PrestadorServicoFound = null;
		for (PrestadorServico prestadorServico : dao.read()) {
			if (prestadorServico.equals(new PrestadorServico(codigo))) {
				PrestadorServicoFound = prestadorServico;
			}
		}
		return PrestadorServicoFound;
	}

}

