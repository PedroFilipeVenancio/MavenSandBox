package com.everis.academia.java.agenda.web.cidade.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.business.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.business.Cidade.CidadeBusiness;

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
		try {
			cidadebusiness.update(this.cidade);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Cidade actulizada com sucesso",""));
			return "read";
		} catch (Exception e) {
//			FacesContext.getCurrentInstance().addMessage("nome", new FacesMessage(FacesMessage.SEVERITY_INFO,"Cidade não actulizada com sucesso por causa do nome",""));
//			FacesContext.getCurrentInstance().addMessage("codigo", new FacesMessage(FacesMessage.SEVERITY_INFO,"Cidade não actulizada com sucesso por causa do codigo",""));
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Cidade não actulizada com sucesso ",""));

			e.printStackTrace();
			return "update";
		}
		
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
