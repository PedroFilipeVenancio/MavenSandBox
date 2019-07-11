package com.everis.academia.java.agenda.digital.business.TipoServico;

import java.util.Collection;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agendadigital.entity.Telefone;
import com.everis.academia.java.agendadigital.entity.TipoServico;

public interface ITipoServicoBusiness {
	void delete(TipoServico toDelete);

	void update(TipoServico toUpdate) throws BusinessException;

	void create(TipoServico toCreate) throws BusinessException;
	
	Collection<TipoServico> read();
	
	TipoServico getById(Integer id);
}
