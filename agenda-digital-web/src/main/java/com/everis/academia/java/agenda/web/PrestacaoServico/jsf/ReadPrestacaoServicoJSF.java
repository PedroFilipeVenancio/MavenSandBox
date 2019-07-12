package com.everis.academia.java.agenda.web.PrestacaoServico.jsf;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.everis.academia.java.agenda.digital.business.PrestacaoServico.IPrestacaoServicoBusiness;
import com.everis.academia.java.agenda.digital.business.PrestacaoServico.PrestacaoServicoBusiness;
import com.everis.academia.java.agenda.digital.business.PrestadorServico.IPrestadorServicoBusiness;
import com.everis.academia.java.agenda.digital.business.PrestadorServico.PrestadorServicosBusiness;
import com.everis.academia.java.agendadigital.entity.PrestacaoServico;
import com.everis.academia.java.agendadigital.entity.PrestadorServico;


//@ViewScoped


@ManagedBean(name = "ReadPrestacaoServicoJSF")

public class ReadPrestacaoServicoJSF {

	IPrestacaoServicoBusiness prestacaoServicoBusiness = new PrestacaoServicoBusiness();
//	@Autowired
//	private ICidadeBusiness cidadebusiness;
	
	PrestacaoServico prestacaoServico = new PrestacaoServico();

	private Collection<PrestacaoServico> PrestacoesServico = null;

	//TODO: the name is not important , but the PostConstruct executes after this class starts,
	@PostConstruct
	public void init() {
		this.PrestacoesServico = prestacaoServicoBusiness.read();
	}



	public PrestacaoServico getPrestacaoServico() {
		return prestacaoServico;
	}


	public void setPrestacaoServico(PrestacaoServico prestacaoServico) {
		this.prestacaoServico = prestacaoServico;
	}


	public Collection<PrestacaoServico> getPrestacoesServico() {
		return PrestacoesServico;
	}


	public void setPrestacoesServico(Collection<PrestacaoServico> prestacoesServico) {
		PrestacoesServico = prestacoesServico;
	}


	public String delete(){	
		
		try {
			prestacaoServicoBusiness.delete(prestacaoServico);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, prestacaoServico.getCodigo().toString(), ": eliminado com sucesso!"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao eliminar!", e.getMessage()));
		}
		
		return null;
	}

	public String updateCity(PrestacaoServico prestacaoServicoVar) {
		return "updatePrestacaoServico";
	}
	


}
