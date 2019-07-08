package com.everis.academia.java.agenda.web.cidade.jsf;

import javax.faces.bean.ManagedBean;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.business.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.business.impl.CidadeBusiness;

import Entity.Cidade;

@ManagedBean(name = "updateJSF")
public class updateJSF {
	Cidade cidade = new Cidade();

	ICidadeBusiness<Cidade> cidadebusiness = new CidadeBusiness();

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String updateCity() throws BusinessException {
		cidadebusiness.update(this.cidade);
		return "read";
	}

	public String limpar() {
		Cidade cleaner = new Cidade();
		cleaner.setCodigo(cidade.getCodigo());
		this.cidade = cleaner;
		return null;
	}

	public String updateOK(Cidade cidade) {
		this.cidade = cidade;
		return "update";
	}

}
