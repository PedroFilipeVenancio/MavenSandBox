package com.everis.academia.java.agenda.web.cidade.jsf;

import javax.faces.bean.ManagedBean;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.business.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.business.impl.CidadeBusiness;

import Entity.Cidade;

@ManagedBean(name = "createJSF")
public class CreateJSF {
//	private String url;
	Cidade cidade = new Cidade();

	ICidadeBusiness<Cidade> cidadebusiness = new CidadeBusiness();

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String addCity() throws BusinessException {
		cidadebusiness.create(cidade);
//		String ok = "/agenda-digital-web/CidadeCreateController2?nome=" + name;
//		System.out.println(ok);
//		url = ok;
		return "read";
	}

	public String limpar() {
		this.cidade = new Cidade();

		return null;
	}

}
