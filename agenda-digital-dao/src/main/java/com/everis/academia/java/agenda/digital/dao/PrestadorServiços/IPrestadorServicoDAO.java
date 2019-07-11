package com.everis.academia.java.agenda.digital.dao.PrestadorServišos;

import java.util.Collection;

import Entity.PrestadorServico;

public interface IPrestadorServicoDAO {
	void delete(PrestadorServico var);

	void update(PrestadorServico var);

	void create(PrestadorServico var);
	
	Collection<PrestadorServico> read();
		
	Boolean jaExiste(PrestadorServico var );

}
