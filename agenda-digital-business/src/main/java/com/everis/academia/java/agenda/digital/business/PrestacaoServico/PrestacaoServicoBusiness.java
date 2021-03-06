package com.everis.academia.java.agenda.digital.business.PrestacaoServico;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.dao.PrestacaoServico.IPrestacaoServicoDAO;
import com.everis.academia.java.agendadigital.entity.PrestacaoServico;

public class PrestacaoServicoBusiness implements IPrestacaoServicoBusiness {

//	IPrestacaoServicoDAO dao = new PrestacaoServicoDAO();
	
	@Autowired
	private IPrestacaoServicoDAO dao;

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


