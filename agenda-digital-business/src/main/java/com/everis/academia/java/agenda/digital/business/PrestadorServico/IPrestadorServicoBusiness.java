package com.everis.academia.java.agenda.digital.business.PrestadorServico;

import java.util.Collection;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agendadigital.entity.PrestadorServico;

public interface IPrestadorServicoBusiness {
	void delete(PrestadorServico toDelete);

	void update(PrestadorServico toUpdate) throws BusinessException;

	void create(PrestadorServico toCreate) throws BusinessException;
	
	Collection<PrestadorServico> read();
	
	PrestadorServico getById(Integer id);
}
