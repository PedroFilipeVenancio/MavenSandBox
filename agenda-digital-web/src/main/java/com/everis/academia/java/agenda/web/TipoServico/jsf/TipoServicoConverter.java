package com.everis.academia.java.agenda.web.TipoServico.jsf;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.everis.academia.java.agendadigital.entity.Cidade;
import com.everis.academia.java.agendadigital.entity.TipoServico;

@FacesConverter(value = "TipoServicoConverter", forClass = TipoServico.class)
public class TipoServicoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		TipoServico tipoServico = null;
		
		if (value !=null && !value.trim().isEmpty()) {
			tipoServico = new TipoServico(Integer.valueOf(value.trim()));	
		}	
		return tipoServico;

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof TipoServico) {
			return String.valueOf(((TipoServico) value).getCodigo());
		}
		return null;

	}

}
