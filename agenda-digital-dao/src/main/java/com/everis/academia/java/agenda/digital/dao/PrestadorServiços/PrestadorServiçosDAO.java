package com.everis.academia.java.agenda.digital.dao.PrestadorServiços;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.everis.academia.java.agenda.digital.dao.IGeralDAO;

import Entity.PrestadorServico;

public class PrestadorServiçosDAO implements IGeralDAO<PrestadorServico> {
	
	public static Collection<PrestadorServico> PrestadorServicos = new HashSet<PrestadorServico>();

	private static int id = 0;

	@Override
	public void delete(PrestadorServico PrestadorServico) {
		PrestadorServicos.remove(PrestadorServico);
	}

	@Override
	public void update(PrestadorServico PrestadorServico) {
		PrestadorServicos.remove(PrestadorServico);
		PrestadorServicos.add(PrestadorServico);
//		int indexOf = PrestadorServicos. indexOf(PrestadorServico);
//		PrestadorServicos.set(indexOf, PrestadorServico);
	}

	@Override
	public void create(PrestadorServico PrestadorServico) {
		id++;
		PrestadorServico.setCodigo(id);
		PrestadorServicos.add(PrestadorServico);
		
	}

	@Override
	public Boolean jaExiste(String nome) {
		
		for (PrestadorServico PrestadorServico : PrestadorServicos) {
			if (PrestadorServico.getNome().trim().equalsIgnoreCase(nome)) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

	@Override
	public Collection<PrestadorServico> read() {
		return PrestadorServicos;
	}

}
