package com.everis.academia.java.agenda.web.PrestadorServico.jsf;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.business.Cidade.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.business.PrestadorServico.IPrestadorServicoBusiness;
import com.everis.academia.java.agendadigital.entity.Cidade;
import com.everis.academia.java.agendadigital.entity.PrestadorServico;

@Component("prestadorServicoUpdate")
@ManagedBean(name = "prestadorServicoUpdate")
@RequestScope
public class PrestadorServicoUpdateBean {

	@Autowired
	private IPrestadorServicoBusiness business;
	
	@Autowired
	private ICidadeBusiness cidadebusiness;
	
	private PrestadorServico prestadorServico = new PrestadorServico();
	
	private Collection<Cidade> cidades = null;
	
	@PostConstruct
	public void init() {
		this.cidades = cidadebusiness.read();
	}

	public PrestadorServico getPrestadorServico() {

		return prestadorServico;
	}

	public void setPrestadorServico(PrestadorServico prestadorServico) {

		this.prestadorServico = prestadorServico;
	}

	public String edit(PrestadorServico prestadorServico){

		this.prestadorServico = prestadorServico;

		return "update";
	}
	
	public String update() throws BusinessException {

		try {
			business.update(prestadorServico);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, prestadorServico.getNome(), ": modificado com sucesso!"));
			return "read";
		} catch (BusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao editar!", e.getMessage()));
		}

		return null;
	}
}