package com.everis.academia.java.agenda.digital.business.PrestadorServi�os;

import java.util.Collection;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.business.IGeralBusiness;
import com.everis.academia.java.agenda.digital.dao.IGeralDAO;
import com.everis.academia.java.agenda.digital.dao.PrestadorServi�os.PrestadorServi�osDAO;

import Entity.PrestadorServico;

public class PrestadorServi�osBusiness implements IGeralBusiness<PrestadorServico> {

	IGeralDAO<PrestadorServico> dao = new PrestadorServi�osDAO();

	@Override
	public void delete(PrestadorServico prestadorServicoVar) {
		dao.delete(prestadorServicoVar);
	}

	@Override
	public void update(PrestadorServico prestadorServicoVar) throws BusinessException {
		// valida parametros
		if (prestadorServicoVar.getNome() == null || prestadorServicoVar.getNome().trim().isEmpty()) {
			throw new BusinessException("� obrigatorio");
		}

		// verifica se j� existe
		if (dao.jaExiste(prestadorServicoVar)) {
			throw new BusinessException("j� existe");
		}
		
		dao.update(prestadorServicoVar);
	}

	@Override
	public void create(PrestadorServico prestadorServicoVar) throws BusinessException {

		// valida parametros
		if (prestadorServicoVar.getNome() == null || prestadorServicoVar.getNome().trim().isEmpty()) {
			throw new BusinessException("� obrigatorio");
		}

		// verifica se j� existe
		if (dao.jaExiste(prestadorServicoVar)) {
			throw new BusinessException("j� existe");
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

