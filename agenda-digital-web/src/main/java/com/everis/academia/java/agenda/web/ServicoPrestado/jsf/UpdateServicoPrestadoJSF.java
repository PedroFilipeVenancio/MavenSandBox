package com.everis.academia.java.agenda.web.ServicoPrestado.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.business.ServicoPrestado.IServicoPrestadoBusiness;
import com.everis.academia.java.agenda.digital.business.ServicoPrestado.ServicoPrestadoBusiness;
import com.everis.academia.java.agendadigital.entity.ServicoPrestado;
import com.everis.academia.java.agendadigital.entity.Telefone;

@ManagedBean(name = "UpdateTelefoneJSF")

public class UpdateServicoPrestadoJSF {
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

	public String updateServicoPrestado() throws BusinessException {
		try {
			servicoPrestadoBusiness.update(this.servicoPrestado);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"servicoPrestado actulizada com sucesso",""));
			return "readServicoPrestado";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("algum erro");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"servicoPrestado não actulizada com sucesso ",""));

			e.printStackTrace();
			return "updateServicoPrestado";
		}
		
	}

	public String limpar() {
		ServicoPrestado cleaner = new ServicoPrestado();
		cleaner.setCodigo(servicoPrestado.getCodigo());
		this.servicoPrestado = cleaner;
		return null;
	}

	public String updateOK(ServicoPrestado ServicoPrestadoVar) {
		this.servicoPrestado = ServicoPrestadoVar;
		return "updateServicoPrestado";
	}

}
