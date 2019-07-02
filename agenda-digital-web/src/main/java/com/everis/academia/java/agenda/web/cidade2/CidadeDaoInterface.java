package com.everis.academia.java.agenda.web.cidade2;

import java.util.Set;

import Entity.Cidade;

public interface CidadeDaoInterface {

	void delete(Cidade cidade);

	void update(Cidade cidade);

	void create(String name);

	Set<Cidade> read();

}
