package com.everis.academia.java.agenda.web.ServicoPrestado.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.business.ServicoPrestado.IServicoPrestadoBusiness;
import com.everis.academia.java.agenda.digital.business.ServicoPrestado.ServicoPrestadoBusiness;
import com.everis.academia.java.agendadigital.entity.ServicoPrestado;

@ManagedBean(name = "CreateServicoPrestadoJSF")

public class CreateServicoPrestadoJSF {

	ServicoPrestado servicoPrestado = new ServicoPrestado();
	
//	@Autowired
//	private IPrestadorServicoBusiness cidadebusiness;

	IServicoPrestadoBusiness servicoPrestadoBusiness = new ServicoPrestadoBusiness();

	public ServicoPrestado getServicoPrestado() {
		return servicoPrestado;
	}

	public void setServicoPrestado(ServicoPrestado servicoPrestado) {
		this.servicoPrestado = servicoPrestado;
	}

	public String addServicoPrestado() throws BusinessException {
		try {
			servicoPrestadoBusiness.create(servicoPrestado);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"servicoPrestado adicionada com sucesso","Detalhe...?"));
			return "readServicoPrestado";
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Deu erro",e.getLocalizedMessage()));
			e.printStackTrace();
			return "createServicoPrestado";
		}
		
	}

	public String limpar() {
		this.servicoPrestado = new ServicoPrestado();
		return null;
	}

}

