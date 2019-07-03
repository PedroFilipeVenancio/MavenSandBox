package com.everis.academia.java.agenda.digital.web.servlet.Cidade;


import java.util.ArrayList;
import java.util.List;

import Entity.Cidade;

public class CidadeDAO {

	public static List<Cidade> cidades = new ArrayList<Cidade>();

	static {
		cidades.add(new Cidade(Integer.valueOf("1"), "Lisboa"));
		cidades.add(new Cidade(Integer.valueOf("2"), "Porto"));
	}
}
