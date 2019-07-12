package com.everis.academia.java.agenda.digital.business.PrestadorServicos;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.dao.PrestacaoServico.IPrestacaoServicoDAO;
import com.everis.academia.java.agenda.digital.dao.PrestadorServicos.IPrestadorServicoDAO;
import com.everis.academia.java.agenda.digital.dao.PrestadorServicos.PrestadorServicosDAO;
import com.everis.academia.java.agendadigital.entity.PrestadorServico;
@Service
public class PrestadorServicosBusiness implements IPrestadorServicoBusiness {

//	IPrestadorServicoDAO dao = new PrestadorServicosDAO();
	@Autowired
	private IPrestadorServicoDAO dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(PrestadorServico prestadorServicoVar) {
		dao.delete(prestadorServicoVar);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
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
	@Transactional(propagation = Propagation.REQUIRED)
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
	@Transactional(readOnly = true)
	public Collection<PrestadorServico> read() {
		// TODO Auto-generated method stub
		return dao.read();
	}

	@Override
	@Transactional(readOnly = true)
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

