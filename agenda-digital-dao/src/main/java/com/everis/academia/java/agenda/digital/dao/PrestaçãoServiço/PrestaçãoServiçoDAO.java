package com.everis.academia.java.agenda.digital.dao.PrestaçãoServiço;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.everis.academia.java.agenda.digital.dao.IGeralDAO;

import Entity.PrestacaoServico;

public class PrestaçãoServiçoDAO implements IGeralDAO<PrestacaoServico> {
	
//	public static List<PrestacaoServico> PrestacaoServicos = new ArrayList<PrestacaoServico>();
	public static Collection<PrestacaoServico> PrestacaoServicos = new HashSet<PrestacaoServico>();

	private static int id = 0;

	@Override
	public void delete(PrestacaoServico PrestacaoServico) {
		PrestacaoServicos.remove(PrestacaoServico);
	}

	@Override
	public void update(PrestacaoServico PrestacaoServico) {
		
		
		int indexOf = PrestacaoServico.getCodigo();
		PrestacaoServicos.remove(PrestacaoServico);
		PrestacaoServicos.add(PrestacaoServico);
//		int indexOf = PrestacaoServicos. indexOf(PrestacaoServico);
//		PrestacaoServicos.set(indexOf, PrestacaoServico);
	}

	@Override
	public void create(PrestacaoServico PrestacaoServico) {
		id++;
		PrestacaoServico.setCodigo(id);
		PrestacaoServicos.add(PrestacaoServico);
		
	}


	@Override
	public Boolean jaExiste(PrestacaoServico prestacaoServico) {
		
		for (PrestacaoServico PrestacaoServico : PrestacaoServicos) {
			if (PrestacaoServico.getCodigo().equals(prestacaoServico.getCodigo())) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

	@Override
	public Collection<PrestacaoServico> read() {
		return PrestacaoServicos;
	}

}

