package com.everis.academia.java.agenda.web.PrestadorServico.jsf;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.everis.academia.java.agenda.digital.business.PrestadorServicos.IPrestadorServicoBusiness;
import com.everis.academia.java.agenda.digital.business.PrestadorServicos.PrestadorServicosBusiness;
import com.everis.academia.java.agendadigital.entity.PrestadorServico;


//@ViewScoped


@ManagedBean(name = "ReadPrestadorServicoJSF")

public class ReadPrestadorServicoJSF {

	IPrestadorServicoBusiness prestadorServicoBusiness = new PrestadorServicosBusiness();
//	@Autowired
//	private ICidadeBusiness cidadebusiness;
	
	PrestadorServico prestadorServico = new PrestadorServico();

	private Collection<PrestadorServico> prestadoresServico = null;

	//TODO: the name is not important , but the PostConstruct executes after this class starts,
	@PostConstruct
	public void init() {
		this.prestadoresServico = prestadorServicoBusiness.read();
	}

	public Collection<PrestadorServico> getPrestadoresServico() {
		return prestadoresServico;
	}

	public void setPrestadoresServico(Collection<PrestadorServico> prestadoresServico) {
		this.prestadoresServico = prestadoresServico;
	}
	



//	public String delete(PrestadorServico prestadorServicoVar) {
//		try {
//			prestadorServicoBusiness.delete(prestadorServicoVar);
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"PrestadorServico apagada com sucesso",""));
//		} catch (Exception e) {
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"PrestadorServico não apagada",""));
//
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	public PrestadorServico getPrestadorServico() {
		return prestadorServico;
	}

	public void setPrestadorServico(PrestadorServico prestadorServico) {
		this.prestadorServico = prestadorServico;
	}

	public String delete(){	
		
		try {
			prestadorServicoBusiness.delete(prestadorServico);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, prestadorServico.getNome(), ": eliminado com sucesso!"));
			return null;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao eliminar!", e.getMessage()));
		}
		
		return null;
	}

	public String updateCity(PrestadorServico prestadorServicoVar) {
		return "updatePrestadorServico";
	}
	


}
