package com.everis.academia.java.agenda.digital.dao.PrestadorServicos;

import java.util.Collection;
import java.util.HashSet;

import com.everis.academia.java.agendadigital.entity.PrestadorServico;
import com.everis.academia.java.agendadigital.entity.Telefone;

public class PrestadorServicosDAO implements IPrestadorServicoDAO {
	
	public static Collection<PrestadorServico> prestadorServicosColl = new HashSet<PrestadorServico>();

	private static int id = 0;

	@Override
	public void delete(PrestadorServico prestadorServicoVar) {
		prestadorServicosColl.remove(prestadorServicoVar);
	}

	@Override
	public void update(PrestadorServico prestadorServicoVar) {
		prestadorServicosColl.remove(prestadorServicoVar);
		prestadorServicosColl.add(prestadorServicoVar);
//		int indexOf = PrestadorServicos. indexOf(PrestadorServico);
//		PrestadorServicos.set(indexOf, PrestadorServico);
	}

	@Override
	public void create(PrestadorServico prestadorServicoVar) {
		id++;
		prestadorServicoVar.setCodigo(id);
		prestadorServicosColl.add(prestadorServicoVar);	
	}

	@Override
	public Boolean jaExiste(PrestadorServico prestadorServicoVar) {
		
		for (PrestadorServico prestadorServico : prestadorServicosColl) {
			if (prestadorServico.getNome().trim().equalsIgnoreCase(prestadorServicoVar.getNome())) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

	@Override
	public Collection<PrestadorServico> read() {
		return prestadorServicosColl;
	}

	@Override
	public Boolean jaExisteTelefone(Telefone var) {
		// TODO Auto-generated method stub
		return null;
	}

}
