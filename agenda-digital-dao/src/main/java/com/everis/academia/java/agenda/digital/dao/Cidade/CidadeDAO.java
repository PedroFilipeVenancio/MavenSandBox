package com.everis.academia.java.agenda.digital.dao.Cidade;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.stereotype.Repository;

import com.everis.academia.java.agendadigital.entity.Cidade;

//@Repository
public class CidadeDAO implements ICidadeDAO {
	

//	public static List<Cidade> cidades = new ArrayList<Cidade>();
	public static Collection<Cidade> cidades = new HashSet<Cidade>();

	private static int id = 0;

	@Override
	public void delete(Cidade cidade) {
		cidades.remove(cidade);
	}

	@Override
	public void update(Cidade cidade) {
		cidades.remove(cidade);
		cidades.add(cidade);
//		int indexOf = cidades. indexOf(cidade);
//		cidades.set(indexOf, cidade);
	}

	@Override
	public void create(Cidade cidade) {
		id++;
		cidade.setCodigo(id);
		cidades.add(cidade);

	}

	@Override
//	public Boolean jaExiste(String nome) {
	public Boolean jaExiste(Cidade nome) {

		for (Cidade cidade : cidades) {
			if (cidade.getNome().trim().equalsIgnoreCase(nome.getNome())) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

	@Override
	public Collection<Cidade> read() {
		return cidades;
	}

}
