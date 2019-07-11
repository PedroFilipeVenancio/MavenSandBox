package com.everis.academia.java.agenda.web.ServicoPrestado.jsf;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.everis.academia.java.agenda.digital.business.ServicoPrestado.IServicoPrestadoBusiness;
import com.everis.academia.java.agenda.digital.business.ServicoPrestado.ServicoPrestadoBusiness;
import com.everis.academia.java.agendadigital.entity.ServicoPrestado;


//@ViewScoped


@ManagedBean(name = "ReadServicoPrestadoJSF")

public class ReadServicoPrestadoJSF {

	ServicoPrestado servicoPrestado = new ServicoPrestado();
	
//	@Autowired
//	private IPrestadorServicoBusiness cidadebusiness;

	IServicoPrestadoBusiness servicoPrestadoBusiness = new ServicoPrestadoBusiness();

	private Collection<ServicoPrestado> ServicosPrestados = null;

	//TODO: the name is not important , but the PostConstruct executes after this class starts,
	@PostConstruct
	public void init() {
		this.ServicosPrestados = servicoPrestadoBusiness.read();
	}

	public ServicoPrestado getServicoPrestado() {
		return servicoPrestado;
	}


	public void setServicoPrestado(ServicoPrestado servicoPrestado) {
		this.servicoPrestado = servicoPrestado;
	}

	public Collection<ServicoPrestado> getServicosPrestados() {
		return ServicosPrestados;
	}

	public void setServicosPrestados(Collection<ServicoPrestado> servicosPrestados) {
		ServicosPrestados = servicosPrestados;
	}

	public String delete(){	
		
		try {
			servicoPrestadoBusiness.delete(servicoPrestado);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, servicoPrestado.getCodigo().toString(), ": eliminado com sucesso!"));
			return null;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao eliminar!", e.getMessage()));
		}
		
		return null;
	}

	public String updateServicoPrestado(ServicoPrestado ServicoPrestadoVar) {
		return "updateServicoPrestado";
	}
	
}
