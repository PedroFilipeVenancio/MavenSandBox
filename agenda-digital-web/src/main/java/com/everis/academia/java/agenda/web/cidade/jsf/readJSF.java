package com.everis.academia.java.agenda.web.cidade.jsf;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.everis.academia.java.agenda.digital.business.IGeralBusiness;
import com.everis.academia.java.agenda.digital.business.Cidade.CidadeBusiness;
import com.everis.academia.java.agenda.digital.business.Cidade.ICidadeBusiness;

import Entity.Cidade;


//@ViewScoped

@Component
@ManagedBean(name = "readJSF")
@RequestScope
public class readJSF {

//	IGeralBusiness<Cidade> cidadebusiness = new CidadeBusiness();
	@Autowired
	private ICidadeBusiness cidadebusiness;

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
		try {
			cidadebusiness.delete(cidade);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Cidade apagada com sucesso",""));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Cidade não apagada",""));

			e.printStackTrace();
		}
		return null;
	}

	public String updateCity(Cidade cidade) {
		return "update";
	}
	


}
