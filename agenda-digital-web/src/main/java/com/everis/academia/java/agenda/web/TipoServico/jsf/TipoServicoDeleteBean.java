package com.everis.academia.java.agenda.web.TipoServico.jsf;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.everis.academia.java.agenda.digital.business.TipoServico.ITipoServicoBusiness;
import com.everis.academia.java.agendadigital.entity.TipoServico;

@Component("tipoServicoDelete")
@ManagedBean(name = "tipoServicoDelete")
@RequestScope
public class TipoServicoDeleteBean {
	
	@Autowired
	private ITipoServicoBusiness business;
	private TipoServico tipoServico = new TipoServico();

	public TipoServico getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(TipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}
	
	public String delete() {
		try {
			business.delete(tipoServico);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, tipoServico.getDescricao(), ": eliminado com sucesso!"));
			return "delete";
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao eliminar!", e.getMessage()));
		}
		return null;
	}
}