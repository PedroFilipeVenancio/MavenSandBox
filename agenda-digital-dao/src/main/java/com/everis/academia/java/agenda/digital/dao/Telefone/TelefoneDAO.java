package com.everis.academia.java.agenda.digital.dao.Telefone;

import java.util.Collection;
import java.util.HashSet;

import com.everis.academia.java.agenda.digital.dao.IGeralDAO;

import Entity.Telefone;

public class TelefoneDAO implements IGeralDAO<Telefone> {
	
//	public static List<Telefone> telefoneColl = new ArrayList<Telefone>();
	public static Collection<Telefone> telefoneColl = new HashSet<Telefone>();

	private static int id = 0;

	@Override
	public void delete(Telefone telefoneVar) {
		telefoneColl.remove(telefoneVar);
	}

	@Override
	public void update(Telefone telefoneVar) {
		telefoneColl.remove(telefoneVar);
		telefoneColl.add(telefoneVar);
	}

	@Override
	public void create(Telefone telefoneVar) {
		id++;
		telefoneVar.setCodigo(id);
		telefoneColl.add(telefoneVar);
		
	}


	@Override
	public Boolean jaExiste(Telefone telefoneVar) {
		
		for (Telefone telefone : telefoneColl) {
			if (telefone.getCodigo().equals(telefoneVar.getCodigo())) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

	@Override
	public Collection<Telefone> read() {
		return telefoneColl;
	}

}

