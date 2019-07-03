package com.everis.academia.java.agenda.digital.web.servlet.Cidade.components;


public class Td extends ComponentHtml {

	@Override
	public String getHtml() {

		String html = "<td>";

		for (ComponentHtml component : getComponents()) {

			html = html.concat(component.getHtml());
		}

		return html.concat("</td>");
	}
}
