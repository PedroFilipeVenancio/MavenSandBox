package com.everis.academia.java.agenda.web.Telefone.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.business.PrestadorServico.IPrestadorServicoBusiness;
import com.everis.academia.java.agenda.digital.business.PrestadorServico.PrestadorServicosBusiness;
import com.everis.academia.java.agenda.digital.business.Telefone.ITelefoneBusiness;
import com.everis.academia.java.agenda.digital.business.Telefone.TelefoneBusiness;
import com.everis.academia.java.agendadigital.entity.PrestadorServico;
import com.everis.academia.java.agendadigital.entity.Telefone;

@ManagedBean(name = "UpdateTelefoneJSF")

public class UpdateTelefoneJSF {
	Telefone telefone = new Telefone();

	ITelefoneBusiness telefoneBusiness = new TelefoneBusiness();
//	@Autowired
//	private ICidadeBusiness cidadebusiness;
	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}


	public String updateTelefone() throws BusinessException {
		try {
			telefoneBusiness.update(this.telefone);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"telefone actulizada com sucesso",""));
			return "readTelefone";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("algum erro");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"telefone não actulizada com sucesso ",""));

			e.printStackTrace();
			return "updateTelefone";
		}
		
	}

	public String limpar() {
		Telefone cleaner = new Telefone();
		cleaner.setCodigo(telefone.getCodigo());
		this.telefone = cleaner;
		return null;
	}

	public String updateOK(Telefone telefoneVar) {
		System.out.println("entrou");
		this.telefone = telefoneVar;
		return "updateTelefone";
	}

}
