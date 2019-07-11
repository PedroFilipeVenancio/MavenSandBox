package com.everis.academia.java.agenda.digital.dao.Cidade;

import java.util.Collection;

import Entity.Cidade;

public interface ICidadeDAO {
	void delete(Cidade var);

	void update(Cidade var);

	void create(Cidade var);
	
	Collection<Cidade> read();
		
	Boolean jaExiste(Cidade var );

}
