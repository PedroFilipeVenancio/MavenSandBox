package com.everis.academia.java.agenda.digital.dao.TipoServico;

import java.util.Collection;

import com.everis.academia.java.agendadigital.entity.TipoServico;

public interface ITipoServicoDAO {
	void delete(TipoServico var);

	void update(TipoServico var);

	void create(TipoServico var);
	
	Collection<TipoServico> read();
		
	Boolean jaExiste(TipoServico var );

}
