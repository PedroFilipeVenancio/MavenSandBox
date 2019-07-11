package com.everis.academia.java.agenda.digital.dao.PrestadorServicos;

import java.util.Collection;

import com.everis.academia.java.agendadigital.entity.PrestadorServico;

public interface IPrestadorServicoDAO {
	void delete(PrestadorServico var);

	void update(PrestadorServico var);

	void create(PrestadorServico var);
	
	Collection<PrestadorServico> read();
		
	Boolean jaExiste(PrestadorServico var );

}
