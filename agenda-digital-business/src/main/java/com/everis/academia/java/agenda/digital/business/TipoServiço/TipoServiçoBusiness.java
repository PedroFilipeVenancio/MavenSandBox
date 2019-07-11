package com.everis.academia.java.agenda.digital.business.TipoServi�o;

import java.util.Collection;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.business.IGeralBusiness;
import com.everis.academia.java.agenda.digital.dao.IGeralDAO;
import com.everis.academia.java.agenda.digital.dao.TipoServi�o.TipoServi�oDAO;
import com.everis.academia.java.agendadigital.entity.TipoServico;

public class TipoServi�oBusiness implements IGeralBusiness<TipoServico> {

	IGeralDAO<TipoServico> dao = new TipoServi�oDAO();

	@Override
	public void delete(TipoServico tipoServicoVar) {
		dao.delete(tipoServicoVar);
	}

	@Override
	public void update(TipoServico tipoServicoVar) throws BusinessException {
		// valida parametros
		if (tipoServicoVar.getCodigo() == null) {
			throw new BusinessException("� obrigatorio");
		}

		// verifica se j� existe
		if (dao.jaExiste(tipoServicoVar)) {
			throw new BusinessException("j� existe");
		}
		
		dao.update(tipoServicoVar);
	}

	@Override
	public void create(TipoServico tipoServicoVar) throws BusinessException {

		// valida parametros
		if (tipoServicoVar.getCodigo() == null ) {
			throw new BusinessException("� obrigatorio");
		}

		// verifica se j� existe
		if (dao.jaExiste(tipoServicoVar)) {
			throw new BusinessException("j� existe");
		}

		dao.create(tipoServicoVar);
	}

	@Override
	public Collection<TipoServico> read() {
		// TODO Auto-generated method stub
		return dao.read();
	}

	@Override
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




