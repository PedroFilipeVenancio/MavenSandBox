package com.everis.academia.java.agenda.web.PrestacaoServico.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.business.PrestacaoServico.IPrestacaoServicoBusiness;
import com.everis.academia.java.agenda.digital.business.PrestacaoServico.PrestacaoServicoBusiness;
import com.everis.academia.java.agendadigital.entity.PrestacaoServico;

@ManagedBean(name = "CreatePrestacaoServicoJSF")

public class CreatePrestacaoServicoJSF {

	PrestacaoServico prestacaoServico = new PrestacaoServico();
	
//	@Autowired
//	private IPrestadorServicoBusiness cidadebusiness;

	IPrestacaoServicoBusiness prestacaoServicoBusiness = new PrestacaoServicoBusiness();

	public PrestacaoServico getPrestacaoServico() {
		return prestacaoServico;
	}

	public void setPrestacaoServico(PrestacaoServico prestacaoServico) {
		this.prestacaoServico = prestacaoServico;
	}

	public String addPrestacaoServico() throws BusinessException {
		try {
			prestacaoServicoBusiness.create(prestacaoServico);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"prestacaoServico adicionada com sucesso","Detalhe...?"));
			return "readPrestacaoServico";
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Deu erro",e.getLocalizedMessage()));
			e.printStackTrace();
			return "createPrestacaoServico";
		}
		
	}

	public String limpar() {
		this.prestacaoServico = new PrestacaoServico();
		return null;
	}

}

