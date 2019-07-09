package com.everis.academia.java.agenda.digital.business;

import java.util.Collection;
import com.everis.academia.java.agenda.digital.business.BusinessException;

public interface IGeralBusiness<T> {
	void delete(T toDelete);

	void update(T toUpdate) throws BusinessException;

	void create(T toCreate) throws BusinessException;
	
	Collection<T> read();
	
	T getById(Integer id);
}

