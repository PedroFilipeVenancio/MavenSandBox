package com.everis.academia.java.agenda.web.TipoServico.jsf;

import java.util.Collection;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.everis.academia.java.agenda.digital.business.TipoServico.ITipoServicoBusiness;
import com.everis.academia.java.agendadigital.entity.TipoServico;

@Component("tipoServicoRead")
@ManagedBean(name = "tipoServicoRead")
@RequestScope
public class TipoServicoReadBean {
	
	@Autowired
	private ITipoServicoBusiness business;

	public Collection<TipoServico> getTiposServico() {
		return business.read();
	}
	
}
