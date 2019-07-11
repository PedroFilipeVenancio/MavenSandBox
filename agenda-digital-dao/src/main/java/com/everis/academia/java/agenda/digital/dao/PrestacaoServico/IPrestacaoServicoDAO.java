package com.everis.academia.java.agenda.digital.dao.PrestacaoServico;

import java.util.Collection;

import com.everis.academia.java.agendadigital.entity.Cidade;
import com.everis.academia.java.agendadigital.entity.PrestacaoServico;

public interface IPrestacaoServicoDAO {
	void delete(PrestacaoServico var);

	void update(PrestacaoServico var);

	void create(PrestacaoServico var);
	
	Collection<PrestacaoServico> read();
		
	Boolean jaExiste(PrestacaoServico var );
}
