package com.everis.academia.java.agenda.digital.business.Presta��oServi�o;

import java.util.Collection;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.business.IGeralBusiness;
import com.everis.academia.java.agenda.digital.dao.IGeralDAO;
import com.everis.academia.java.agenda.digital.dao.Presta��oServi�o.Presta��oServi�oDAO;

import Entity.PrestacaoServico;

public class Presta��oServi�oBusiness implements IGeralBusiness<PrestacaoServico> {

	IGeralDAO<PrestacaoServico> dao = new Presta��oServi�oDAO();

	@Override
	public void delete(PrestacaoServico prestacaoServicoVar) {
		dao.delete(prestacaoServicoVar);
	}

	@Override
	public void update(PrestacaoServico prestacaoServicoVar) throws BusinessException {
		// valida parametros
		if (prestacaoServicoVar.getCodigo() == null) {
			throw new BusinessException("� obrigatorio");
		}

		// verifica se j� existe
		if (dao.jaExiste(prestacaoServicoVar)) {
			throw new BusinessException("j� existe");
		}
		
		dao.update(prestacaoServicoVar);
	}

	@Override
	public void create(PrestacaoServico prestacaoServicoVar) throws BusinessException {

		// valida parametros
		if (prestacaoServicoVar.getCodigo() == null) {
			throw new BusinessException("� obrigatorio");
		}

		// verifica se j� existe
		if (dao.jaExiste(prestacaoServicoVar)) {
			throw new BusinessException("j� existe");
		}

		dao.create(prestacaoServicoVar);
	}

	@Override
	public Collection<PrestacaoServico> read() {
		// TODO Auto-generated method stub
		return dao.read();
	}

	@Override
	public PrestacaoServico getById(Integer codigo) {
		PrestacaoServico PrestacaoServicoFound = null;
		for (PrestacaoServico PrestacaoServico : dao.read()) {
			if (PrestacaoServico.equals(new PrestacaoServico(codigo))) {
				PrestacaoServicoFound = PrestacaoServico;
			}
		}
		return PrestacaoServicoFound;
	}

}

