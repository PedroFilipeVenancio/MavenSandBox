package com.everis.academia.java.agenda.web.cidade;

import java.util.List;
import java.util.Set;

import Entity.Cidade;

public interface CidadeDaoInterface <T> {

	void delete(T cidade);

	void update(T cidade);

	void create(String name);
	
//	Set<T> read();
	
	List<T> read();

}
