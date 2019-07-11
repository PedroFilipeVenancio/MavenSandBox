package com.everis.academia.java.agenda.digital.business.Cidade;

import java.util.Collection;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.business.IGeralBusiness;

import Entity.Cidade;

public interface ICidadeBusiness {
	void delete(Cidade toDelete);

	void update(Cidade toUpdate) throws BusinessException;

	void create(Cidade toCreate) throws BusinessException;
	
	Collection<Cidade> read();
	
	Cidade getById(Integer id);

}
