package com.everis.academia.java.agenda.web.Telefone.jsf;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.everis.academia.java.agenda.digital.business.Telefone.ITelefoneBusiness;
import com.everis.academia.java.agenda.digital.business.Telefone.TelefoneBusiness;
import com.everis.academia.java.agendadigital.entity.Telefone;


//@ViewScoped


@ManagedBean(name = "ReadTelefoneJSF")

public class ReadTelefoneJSF {

	ITelefoneBusiness telefoneBusiness = new TelefoneBusiness();
//	@Autowired
//	private ICidadeBusiness cidadebusiness;
	
	Telefone telefone = new Telefone();

	private Collection<Telefone> Telefones = null;

	//TODO: the name is not important , but the PostConstruct executes after this class starts,
	@PostConstruct
	public void init() {
		this.Telefones = telefoneBusiness.read();
	}
	
	
	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}


	public Collection<Telefone> getTelefones() {
		return Telefones;
	}


	public void setTelefones(Collection<Telefone> telefones) {
		Telefones = telefones;
	}


	public String delete(){	
		
		try {
			telefoneBusiness.delete(telefone);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, telefone.getNumero().toString(), ": eliminado com sucesso!"));
			return null;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao eliminar!", e.getMessage()));
		}
		
		return null;
	}

	public String updateTelefone(Telefone telefoneVar) {
		return "updateTelefone";
	}
	


}
