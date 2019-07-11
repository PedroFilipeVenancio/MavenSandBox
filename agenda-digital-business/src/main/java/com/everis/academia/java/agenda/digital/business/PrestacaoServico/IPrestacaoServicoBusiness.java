package com.everis.academia.java.agenda.digital.business.PrestacaoServico;

import java.util.Collection;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agendadigital.entity.PrestacaoServico;

public interface IPrestacaoServicoBusiness {
	void delete(PrestacaoServico toDelete);

	void update(PrestacaoServico toUpdate) throws BusinessException;

	void create(PrestacaoServico toCreate) throws BusinessException;
	
	Collection<PrestacaoServico> read();
	
	PrestacaoServico getById(Integer id);
}
