package com.everis.academia.java.agenda.digital.business.PrestadorServiços;

import java.util.Collection;

import com.everis.academia.java.agenda.digital.business.BusinessException;

import Entity.PrestadorServico;

public interface IPrestadorServicoBusiness {
	void delete(PrestadorServico toDelete);

	void update(PrestadorServico toUpdate) throws BusinessException;

	void create(PrestadorServico toCreate) throws BusinessException;
	
	Collection<PrestadorServico> read();
	
	PrestadorServico getById(Integer id);
}
