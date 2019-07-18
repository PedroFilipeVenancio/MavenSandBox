package com.everis.academia.java.agenda.digital.dao.PrestadorServicos;

import java.util.Collection;
import java.util.Set;

import com.everis.academia.java.agendadigital.entity.PrestadorServico;
import com.everis.academia.java.agendadigital.entity.Telefone;

public interface IPrestadorServicoDAO {
	void delete(PrestadorServico var);

	void update(PrestadorServico var);

	void create(PrestadorServico var);
	
	Collection<PrestadorServico> read();
		
	Boolean jaExiste(PrestadorServico var );
	
	Boolean jaExisteTelefone(Telefone var);

}
