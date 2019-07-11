package com.everis.academia.java.agenda.digital.dao.PrestaçãoServiço;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.everis.academia.java.agenda.digital.dao.IGeralDAO;
import com.everis.academia.java.agendadigital.entity.PrestacaoServico;

public class PrestacaoServicoDAO implements IGeralDAO<PrestacaoServico> {
	
	public static List<PrestacaoServico> prestacaoServicosColl = new ArrayList<PrestacaoServico>();
//	public static Collection<PrestacaoServico> prestacaoServicosColl = new HashSet<PrestacaoServico>();

	private static int id = 0;

	@Override
	public void delete(PrestacaoServico prestacaoServicoVar) {
		prestacaoServicosColl.remove(prestacaoServicoVar);
	}

	@Override
	public void update(PrestacaoServico prestacaoServicoVar) {
		
		
		int indexOf = prestacaoServicoVar.getCodigo();
		prestacaoServicosColl.remove(prestacaoServicoVar);
		prestacaoServicosColl.add(prestacaoServicoVar);
//		int indexOf = PrestacaoServicos. indexOf(PrestacaoServico);
//		PrestacaoServicos.set(indexOf, PrestacaoServico);
	}

	@Override
	public void create(PrestacaoServico prestacaoServicoVar) {
		id++;
		prestacaoServicoVar.setCodigo(id);
		prestacaoServicosColl.add(prestacaoServicoVar);
		
	}


	@Override
	public Boolean jaExiste(PrestacaoServico prestacaoServicoVar) {
		
		for (PrestacaoServico prestacaoServico : prestacaoServicosColl) {
			if (prestacaoServico.getCodigo().equals(prestacaoServicoVar.getCodigo())) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

	@Override
	public Collection<PrestacaoServico> read() {
		return prestacaoServicosColl;
	}

}

