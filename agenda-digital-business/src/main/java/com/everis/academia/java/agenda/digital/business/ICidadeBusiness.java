package com.everis.academia.java.agenda.digital.business;

import java.util.Collection;
import java.util.List;

import Entity.Cidade;

public interface ICidadeBusiness<T> {
	Boolean delete(T cidade);

	void update(T cidade) throws BusinessException;

	void create(T name) throws BusinessException;
	
//	Set<T> read();
	
	Collection<T> read();
	
	Cidade getById(Integer id);
}
