package com.everis.academia.java.agenda.digital.web.servlet.Cidade.components;

public class Form extends ComponentHtml {

	private String action;

	public Form(String action){

		super();

		this.action = action;
	}

	public String getAction() {

		return action;
	}

	@Override
	public String getHtml() {

		String html = "<form action=\"" + getAction() + "\">";

		for (ComponentHtml component : getComponents()) {

			html = html.concat(component.getHtml());
		}

		return html.concat("</form>");
	}
}