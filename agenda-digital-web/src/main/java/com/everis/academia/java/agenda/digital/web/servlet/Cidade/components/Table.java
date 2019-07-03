package com.everis.academia.java.agenda.digital.web.servlet.Cidade.components;

public class Table extends ComponentHtml {

	@Override
	public void validateAddComponent(ComponentHtml component) throws Exception {

		if (!(component instanceof Tr)) {
			throw new Exception("Tipo não suportado");
		}
	}

	@Override
	public String getHtml() {

		String html = "<table>";

		for (ComponentHtml component : getComponents()) {

			html = html.concat(component.getHtml());
		}

		return html.concat("</table>");
	}
}
