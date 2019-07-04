package com.everis.academia.java.agenda.digital.dao;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ICidadeDAO <T> {
	void delete(T cidade);

	void update(T cidade);

	void create(T cidade);
	
	Collection<T> read();
	
//	List<T> read();
		
	Boolean jaExiste(String nome);
}
