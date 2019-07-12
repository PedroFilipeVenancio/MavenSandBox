package com.everis.academia.java.agenda.web.TipoServico.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.business.TipoServico.ITipoServicoBusiness;
import com.everis.academia.java.agendadigital.entity.TipoServico;

@Component("tipoServicoUpdate")
@ManagedBean(name = "tipoServicoUpdate")
@RequestScope
public class TipoServicoUpdateBean {
	
	@Autowired
	private ITipoServicoBusiness business;
	private TipoServico tipoServico = new TipoServico();
	
	public TipoServico getTipoServico() {
		
		return tipoServico;
	}
	
	public void setTipoServico(TipoServico tipoServico) {

		this.tipoServico = tipoServico;
	}
	
public String edit(TipoServico tipoServico){
		
		this.tipoServico = tipoServico;
		
		return "update";
	}
public String update() throws BusinessException {
	
	
	try {
		business.update(tipoServico);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, tipoServico.getDescricao(), ": modificado com sucesso!"));
		return "read";
	} catch (BusinessException e) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao editar!", e.getMessage()));
	}
	
	return null;
}
}