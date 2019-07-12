package com.everis.academia.java.agenda.web.PrestacaoServico.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.business.PrestacaoServico.IPrestacaoServicoBusiness;
import com.everis.academia.java.agenda.digital.business.PrestacaoServico.PrestacaoServicoBusiness;
import com.everis.academia.java.agenda.digital.business.PrestadorServico.IPrestadorServicoBusiness;
import com.everis.academia.java.agenda.digital.business.PrestadorServico.PrestadorServicosBusiness;
import com.everis.academia.java.agendadigital.entity.PrestacaoServico;
import com.everis.academia.java.agendadigital.entity.PrestadorServico;

@ManagedBean(name = "UpdatePrestacaoServicoJSF")

public class UpdatePrestacaoServicoJSF {

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

	public String updateprestacaoServico() throws BusinessException {
		try {
			prestacaoServicoBusiness.update(this.prestacaoServico);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"prestacaoServico actulizada com sucesso",""));
			return "readPrestacaoServico";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("algum erro");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"prestacaoServico não actulizada com sucesso ",""));

			e.printStackTrace();
			return "updatePrestacaoServico";
		}
		
	}

	public String limpar() {
		PrestacaoServico cleaner = new PrestacaoServico();
		cleaner.setCodigo(prestacaoServico.getCodigo());
		this.prestacaoServico = cleaner;
		return null;
	}

	public String updateOK(PrestacaoServico prestacaoServicovar) {
		System.out.println("entrou");
		this.prestacaoServico = prestacaoServicovar;
		return "updatePrestacaoServico";
	}

}
