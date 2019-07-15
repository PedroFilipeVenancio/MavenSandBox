package com.everis.academia.java.agenda.digital.business.TipoServico;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.business.IGeralBusiness;
import com.everis.academia.java.agenda.digital.dao.IGeralDAO;
import com.everis.academia.java.agenda.digital.dao.Telefone.ITelefoneDAO;
import com.everis.academia.java.agenda.digital.dao.TipoServico.ITipoServicoDAO;
import com.everis.academia.java.agenda.digital.dao.TipoServico.TipoServicoDAO;
import com.everis.academia.java.agendadigital.entity.TipoServico;
@Service
public class TipoServicoBusiness implements ITipoServicoBusiness {

//	TipoServicoDAO dao = new TipoServicoDAO();
	@Autowired
	private ITipoServicoDAO dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(TipoServico tipoServicoVar) {
		dao.delete(tipoServicoVar);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(TipoServico tipoServicoVar) throws BusinessException {
		// valida parametros
		if (tipoServicoVar.getCodigo() == null) {
			throw new BusinessException("É obrigatorio");
		}
		
		if (tipoServicoVar.getDescricao().length()>=100) {
			throw new BusinessException("Não é permitido mais de 100 Caracteres");
		}
		
		dao.update(tipoServicoVar);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(TipoServico tipoServicoVar) throws BusinessException {
		// verifica se já existe
		if (dao.jaExiste(tipoServicoVar)) {
			throw new BusinessException("já existe");
		}
		
		if (tipoServicoVar.getDescricao().length()>=100) {
			throw new BusinessException("Não é permitido mais de 100 Caracteres");
		}

		dao.create(tipoServicoVar);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<TipoServico> read() {
		// TODO Auto-generated method stub
		return dao.read();
	}

	@Override
	@Transactional(readOnly = true)
	public TipoServico getById(Integer codigo) {
		TipoServico TipoServicoFound = null;
		for (TipoServico TipoServico : dao.read()) {
			if (TipoServico.equals(new TipoServico(codigo))) {
				TipoServicoFound = TipoServico;
			}
		}
		return TipoServicoFound;
	}

}




