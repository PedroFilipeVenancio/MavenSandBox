package com.everis.academia.java.agenda.web.cidade.jsf;

import javax.faces.bean.ManagedBean;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.business.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.business.impl.CidadeBusiness;

import Entity.Cidade;

@ManagedBean(name = "createJSF")
public class CreateJSF {
	private  String name;
	private String url;
	
	ICidadeBusiness<Cidade> cidadebusiness = new CidadeBusiness();


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String addCity() throws BusinessException {
		Cidade cidade = new Cidade();
		cidade.setNome(this.name);
		cidadebusiness.create(cidade);
		String ok = "/agenda-digital-web/CidadeCreateController2?nome=" + name;
		System.out.println(ok);
		url = ok;
		return ok;
	}

}

