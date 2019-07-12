package com.everis.academia.java.agenda.web.PrestadorServico.jsf;



import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.business.PrestadorServicos.IPrestadorServicoBusiness;
import com.everis.academia.java.agendadigital.entity.PrestadorServico;

@Component("prestadorServicoCreate")
@ManagedBean(name = "prestadorServicoCreate")
@RequestScope
public class PrestadorServicoCreateBean {

	@Autowired
	private IPrestadorServicoBusiness business;
	
	private PrestadorServico prestadorServico = new PrestadorServico();
	
	public PrestadorServico getPrestadorServico() {
		
		return prestadorServico;
	}
	
	public void setPrestadorServico(PrestadorServico prestadorServico) {

		this.prestadorServico = prestadorServico;
	}
	
	public String createPrestadorServico() {
		try {
			business.create(prestadorServico);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, prestadorServico.getNome(), ": registado com sucesso!"));
			return "read";
		} catch (BusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao registar!", e.getMessage()));
		}
		return null;
	}
	
	public String cleanPrestadorServico() {
		this.prestadorServico = new PrestadorServico();
		return null;
	}
	
}