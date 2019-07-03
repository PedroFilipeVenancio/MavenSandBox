package com.everis.academia.java.agenda.web.cidade;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Entity.Cidade;

//public final class CidadeDao Extends CidadeRepository {
public class CidadeDao implements CidadeDaoInterface <Cidade> {

//	public static Set<Cidade> listaCidades = new HashSet<Cidade>();
	public static List<Cidade> listaCidades = new ArrayList<Cidade>();
	private static Integer id = 0;
	
	static CidadeDao SingleCidade = new CidadeDao();

	public void delete(Cidade cidade) {
		listaCidades.remove(cidade);
	}

	public void create(String name) {
		id++;
		listaCidades.add(new Cidade(id, name));
	}

//	public Set<Cidade> read() {
//		return listaCidades;
//	}
	
	public List<Cidade> read(){
		return listaCidades;
	}

	public void update(Cidade cidade) {
		// TODO Auto-generated method stub
		
	}
}
