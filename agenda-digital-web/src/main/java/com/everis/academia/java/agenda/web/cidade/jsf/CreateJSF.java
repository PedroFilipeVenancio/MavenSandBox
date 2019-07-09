package com.everis.academia.java.agenda.web.cidade.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.business.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.business.Cidade.CidadeBusiness;

import Entity.Cidade;

@ManagedBean(name = "createJSF")
public class CreateJSF {

	Cidade cidade = new Cidade();

	ICidadeBusiness<Cidade> cidadebusiness = new CidadeBusiness();

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String addCity() throws BusinessException {
		try {
			cidadebusiness.create(cidade);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Cidade adicionada com sucesso","Detalhe...?"));
//			FacesContext.getCurrentInstance().addMessage("nome", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Cidade adicionada com sucesso no nomeeeeee","Detalhe...?"));
//			TODO: troquei o null pelo "nome", que é o id do xhtml a qual este erro se refere, na linhas n:14.
//			FacesContext.getCurrentInstance().addMessage("nome", new FacesMessage(FacesMessage.SEVERITY_INFO,"Cidade adicionada com sucesso","Detalhe...?"));
			return "read";
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Deu erro",e.getLocalizedMessage()));
			e.printStackTrace();
			return "create";
		}
		
	}

	public String limpar() {
		this.cidade = new Cidade();

		return null;
	}

}
