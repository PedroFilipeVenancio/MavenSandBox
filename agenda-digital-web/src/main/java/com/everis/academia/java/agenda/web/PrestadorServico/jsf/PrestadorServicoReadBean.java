package com.everis.academia.java.agenda.web.PrestadorServico.jsf;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.everis.academia.java.agenda.digital.business.PrestadorServico.IPrestadorServicoBusiness;
import com.everis.academia.java.agenda.digital.business.TipoServico.ITipoServicoBusiness;
import com.everis.academia.java.agendadigital.entity.PrestadorServico;
import com.everis.academia.java.agendadigital.entity.TipoServico;

@Component("prestadorServicoRead")
@ManagedBean(name = "prestadorServicoRead")
@RequestScope
public class PrestadorServicoReadBean {
	
	@Autowired
	private IPrestadorServicoBusiness business;
	private Collection<PrestadorServico> prestadoresServico;
	
//	@PostConstruct
//	public void init() {
//		this.prestadoresServico = business.read();
//	}
	


	public Collection<PrestadorServico> getPrestadoresServico() {
		System.out.println(business.read().size() + "TAMANHOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
		return business.read();
	}
	
	public void setPrestadoresServico(Collection<PrestadorServico> prestadoresServico) {
		this.prestadoresServico = prestadoresServico;
	}
	
}