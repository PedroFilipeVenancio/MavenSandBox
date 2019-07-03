package com.everis.academia.java.agenda.digital.dao;

import java.util.List;

public interface ICidadeDAO <T> {
	void delete(T cidade);

	void update(T cidade);

	void create(T cidade);
	
//	Set<T> read();
	
	List<T> read();
	
	Boolean jaExiste(String nome);
}
