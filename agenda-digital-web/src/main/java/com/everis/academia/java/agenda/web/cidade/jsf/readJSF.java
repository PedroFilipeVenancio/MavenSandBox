package com.everis.academia.java.agenda.web.cidade.jsf;

import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.business.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.business.impl.CidadeBusiness;

import Entity.Cidade;

@ManagedBean(name = "readJSF")
//@ViewScoped
public class readJSF {

	ICidadeBusiness<Cidade> cidadebusiness = new CidadeBusiness();

	private Collection<Cidade> cidades = null;

	//TODO: the name is not important , but the PostConstruct executes after this class starts,
	@PostConstruct
	public void init() {
		this.cidades = cidadebusiness.read();
	}

	public Collection<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(Collection<Cidade> cidades) {
		this.cidades = cidades;
	}

	public String delete(Cidade cidade) {
		cidadebusiness.delete(cidade);
		return null;
	}

	public String updateCity(Cidade cidade) {
		return "update";
	}
	
//	public String deleteSemParam() {
//		cidadebusiness.delete(cidade);
//		return null;
//	}

}
