package com.everis.academia.java.agenda.web.PrestadorServico.jsf;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.everis.academia.java.agenda.digital.business.PrestadorServiços.IPrestadorServicoBusiness;
import com.everis.academia.java.agenda.digital.business.PrestadorServiços.PrestadorServiçosBusiness;

import Entity.PrestadorServico;


//@ViewScoped

@Component
@ManagedBean(name = "ReadPrestadorServicoJSF")
@RequestScope
public class ReadPrestadorServicoJSF {

	IPrestadorServicoBusiness prestadorServicoBusiness = new PrestadorServiçosBusiness();
//	@Autowired
//	private ICidadeBusiness cidadebusiness;

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



	public String delete(PrestadorServico prestadorServicoVar) {
		try {
			prestadorServicoBusiness.delete(prestadorServicoVar);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"PrestadorServico apagada com sucesso",""));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"PrestadorServico não apagada",""));

			e.printStackTrace();
		}
		return null;
	}

	public String updateCity(PrestadorServico prestadorServicoVar) {
		return "updatePrestadorServico";
	}
	


}
