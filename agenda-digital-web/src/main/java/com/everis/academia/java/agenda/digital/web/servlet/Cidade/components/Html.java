package com.everis.academia.java.agenda.digital.web.servlet.Cidade.components;

public class Html extends ComponentHtml {

	@Override
	public void validateAddComponent(ComponentHtml component) throws Exception {

		// Verificar o tipo de componente � suportado.
		if (!(component instanceof Body)) {
			throw new Exception("Suportado somente component Body");
		}

		// Verficiar se j� existe um component Body.
		if (!getComponents().isEmpty()) {
			throw new Exception("Component Body j� atribu�do");
		}
	}

	@Override
	public String getHtml() {

		String html = "<html>";

		for (ComponentHtml component : getComponents()) {

			html = html.concat(component.getHtml());
		}

		return html.concat("</html>");
	}
}
