package com.everis.academia.java.agenda.web.PrestadorServico.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.business.IGeralBusiness;
import com.everis.academia.java.agenda.digital.business.Cidade.CidadeBusiness;
import com.everis.academia.java.agenda.digital.business.Cidade.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.business.PrestadorServiços.IPrestadorServicoBusiness;
import com.everis.academia.java.agenda.digital.business.PrestadorServiços.PrestadorServiçosBusiness;

import Entity.Cidade;
import Entity.PrestadorServico;
@Component
@ManagedBean(name = "CreatePrestadorServicoJSF")
@RequestScope
public class CreatePrestadorServicoJSF {

	PrestadorServico prestadorServico = new PrestadorServico();
	
//	@Autowired
//	private IPrestadorServicoBusiness cidadebusiness;

	IPrestadorServicoBusiness prestadorServicoBusiness = new PrestadorServiçosBusiness();


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

