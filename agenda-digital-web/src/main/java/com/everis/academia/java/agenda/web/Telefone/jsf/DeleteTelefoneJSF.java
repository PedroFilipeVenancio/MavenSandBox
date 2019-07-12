package com.everis.academia.java.agenda.web.Telefone.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.everis.academia.java.agenda.digital.business.Telefone.ITelefoneBusiness;
import com.everis.academia.java.agendadigital.entity.Telefone;

@Component("DeleteTelefoneJSF")
@ManagedBean(name = "DeleteTelefoneJSF")
@RequestScope
public class DeleteTelefoneJSF {
	
	Telefone telefone = new Telefone();
//	ITelefoneBusiness telefoneBusiness = new TelefoneBusiness();
	@Autowired
	private ITelefoneBusiness business;


	
	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public String delete() {
		try {
			business.delete(telefone);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, telefone.getNumero().toString() , ": eliminado com sucesso!"));
			return "delete";
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao eliminar!", e.getMessage()));
		}
		return null;
	}
}