package com.everis.academia.java.agenda.web.cidade.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.business.Cidade.ICidadeBusiness;
import com.everis.academia.java.agendadigital.entity.Cidade;

@ManagedBean(name = "updateJSF")
@Component
@RequestScope
public class updateJSF {
	Cidade cidade = new Cidade();

//	IGeralBusiness<Cidade> cidadebusiness = new CidadeBusiness();
	@Autowired
	private ICidadeBusiness cidadebusiness;

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String updateCity() throws BusinessException {
		try {
			cidadebusiness.update(this.cidade);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Cidade actulizada com sucesso",""));
			return "read";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("algum erro");
//			FacesContext.getCurrentInstance().addMessage("nome", new FacesMessage(FacesMessage.SEVERITY_INFO,"Cidade não actulizada com sucesso por causa do nome",""));
//			FacesContext.getCurrentInstance().addMessage("codigo", new FacesMessage(FacesMessage.SEVERITY_INFO,"Cidade não actulizada com sucesso por causa do codigo",""));
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cidade não actulizada!", e.getMessage()));

			e.printStackTrace();
			return "update";
		}
		
	}

	public String limpar() {
		Cidade cleaner = new Cidade();
		cleaner.setCodigo(cidade.getCodigo());
		this.cidade = cleaner;
		return null;
	}

	public String updateOK(Cidade cidade) {
		this.cidade = cidade;
		return "update";
	}

}
