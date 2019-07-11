package com.everis.academia.java.agenda.digital.dao.Telefone;

import java.util.Collection;

import com.everis.academia.java.agendadigital.entity.Telefone;

public interface ITelefoneDAO {
	void delete(Telefone var);

	void update(Telefone var);

	void create(Telefone var);

	Collection<Telefone> read();

	Boolean jaExiste(Telefone var);
}
