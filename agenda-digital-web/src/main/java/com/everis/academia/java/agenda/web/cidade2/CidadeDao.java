package com.everis.academia.java.agenda.web.cidade2;

import java.util.HashSet;
import java.util.Set;

import Entity.Cidade;

//public final class CidadeDao Extends CidadeRepository {
	public class CidadeDao implements CidadeDaoInterface {
	
	public static Set<Cidade> listaCidades = new HashSet<Cidade>();
	private static Integer id = 0;
	
	@Override
	public static void  delete(Cidade cidade) {	
		listaCidades.remove(cidade);
	}
	
	@Override
	public static void  update(Cidade cidade) {	
	}
	
	@Override
	public static void  create(String name) {
		id++;
		listaCidades.add(new Cidade(id,name));
		System.out.println(listaCidades.size());	
	}
	
	@Override
	public static Set<Cidade>  read() {
	return listaCidades;
	}

}
