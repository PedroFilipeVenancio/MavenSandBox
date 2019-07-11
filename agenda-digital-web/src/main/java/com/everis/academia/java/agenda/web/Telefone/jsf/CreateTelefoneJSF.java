package com.everis.academia.java.agenda.web.Telefone.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.business.PrestadorServicos.IPrestadorServicoBusiness;
import com.everis.academia.java.agenda.digital.business.PrestadorServicos.PrestadorServicosBusiness;
import com.everis.academia.java.agenda.digital.business.Telefone.ITelefoneBusiness;
import com.everis.academia.java.agenda.digital.business.Telefone.TelefoneBusiness;
import com.everis.academia.java.agendadigital.entity.PrestadorServico;
import com.everis.academia.java.agendadigital.entity.Telefone;

@ManagedBean(name = "CreateTelefoneJSF")

public class CreateTelefoneJSF {

	Telefone telefone = new Telefone();
	
//	@Autowired
//	private IPrestadorServicoBusiness cidadebusiness;

	ITelefoneBusiness telefoneBusiness = new TelefoneBusiness();


	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public String addPrestadorServico() throws BusinessException {
		try {
			telefoneBusiness.create(telefone);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"telefone adicionada com sucesso","Detalhe...?"));
			return "readPrestadorServico";
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Deu erro",e.getLocalizedMessage()));
			e.printStackTrace();
			return "createPrestadorServico";
		}
		
	}

	public String limpar() {
		this.telefone = new Telefone();

		return null;
	}

}

