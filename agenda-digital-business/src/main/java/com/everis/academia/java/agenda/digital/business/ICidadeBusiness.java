package com.everis.academia.java.agenda.digital.business;

import java.util.List;

public interface ICidadeBusiness<T> {
	Boolean delete(T cidade);

	void update(T cidade) throws BusinessException;

	void create(T name) throws BusinessException;
	
//	Set<T> read();
	
	List<T> read();
}
