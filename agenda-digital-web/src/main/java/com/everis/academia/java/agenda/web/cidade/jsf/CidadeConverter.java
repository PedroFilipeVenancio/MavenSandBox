package com.everis.academia.java.agenda.web.cidade.jsf;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.everis.academia.java.agendadigital.entity.Cidade;

@FacesConverter(value = "CidadeConverter", forClass = Cidade.class)
public class CidadeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Cidade cidade = null;
		
		if (value !=null && !value.trim().isEmpty()) {
			cidade = new Cidade(Integer.valueOf(value.trim()));	
		}	
		return cidade;

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Cidade) {
			return String.valueOf(((Cidade) value).getCodigo());
		}
		return null;

	}

}
