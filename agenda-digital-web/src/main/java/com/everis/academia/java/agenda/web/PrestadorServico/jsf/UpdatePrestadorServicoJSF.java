package com.everis.academia.java.agenda.web.PrestadorServico.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.business.PrestadorServiços.IPrestadorServicoBusiness;
import com.everis.academia.java.agenda.digital.business.PrestadorServiços.PrestadorServiçosBusiness;
import com.everis.academia.java.agendadigital.entity.PrestadorServico;

@ManagedBean(name = "UpdatePrestadorServicoJSF")

public class UpdatePrestadorServicoJSF {
	PrestadorServico prestadorServico = new PrestadorServico();

	IPrestadorServicoBusiness prestadorServicoBusiness = new PrestadorServiçosBusiness();
//	@Autowired
//	private ICidadeBusiness cidadebusiness;

	public PrestadorServico getPrestadorServico() {
		return prestadorServico;
	}

	public void setPrestadorServico(PrestadorServico prestadorServico) {
		this.prestadorServico = prestadorServico;
	}

	public String updateprestadorServico() throws BusinessException {
		try {
			prestadorServicoBusiness.update(this.prestadorServico);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"prestadorServico actulizada com sucesso",""));
			return "readPrestadorServico";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("algum erro");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"prestadorServico não actulizada com sucesso ",""));

			e.printStackTrace();
			return "updatePrestadorServico";
		}
		
	}

	public String limpar() {
		PrestadorServico cleaner = new PrestadorServico();
		cleaner.setCodigo(prestadorServico.getCodigo());
		this.prestadorServico = cleaner;
		return null;
	}

	public String updateOK(PrestadorServico PrestadorServicoVar) {
		System.out.println("entrou");
		this.prestadorServico = PrestadorServicoVar;
		return "updatePrestadorServico";
	}

}
