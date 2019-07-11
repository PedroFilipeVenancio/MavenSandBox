package com.everis.academia.java.agenda.digital.business.Telefone;

import java.util.Collection;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agendadigital.entity.Telefone;

public interface ITelefoneBusiness {
	void delete(Telefone toDelete);

	void update(Telefone toUpdate) throws BusinessException;

	void create(Telefone toCreate) throws BusinessException;
	
	Collection<Telefone> read();
	
	Telefone getById(Integer id);
}
