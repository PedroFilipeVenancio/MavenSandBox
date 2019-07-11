package com.everis.academia.java.agenda.web.PrestadorServico.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.business.PrestadorServicos.IPrestadorServicoBusiness;
import com.everis.academia.java.agenda.digital.business.PrestadorServicos.PrestadorServicosBusiness;
import com.everis.academia.java.agendadigital.entity.PrestadorServico;

@ManagedBean(name = "CreatePrestadorServicoJSF")

public class CreatePrestadorServicoJSF {

	PrestadorServico prestadorServico = new PrestadorServico();
	
//	@Autowired
//	private IPrestadorServicoBusiness cidadebusiness;

	IPrestadorServicoBusiness prestadorServicoBusiness = new PrestadorServicosBusiness();


	public PrestadorServico getPrestadorServico() {
		return prestadorServico;
	}

	public void setPrestadorServico(PrestadorServico prestadorServico) {
		this.prestadorServico = prestadorServico;
	}

	public String addPrestadorServico() throws BusinessException {
		try {
			prestadorServicoBusiness.create(prestadorServico);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"prestadorServico adicionada com sucesso","Detalhe...?"));
			return "readPrestadorServico";
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Deu erro",e.getLocalizedMessage()));
			e.printStackTrace();
			return "createPrestadorServico";
		}
		
	}

	public String limpar() {
		this.prestadorServico = new PrestadorServico();

		return null;
	}

}

