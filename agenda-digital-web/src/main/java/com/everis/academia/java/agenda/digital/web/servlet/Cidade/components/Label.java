package com.everis.academia.java.agenda.digital.web.servlet.Cidade.components;

public class Label extends ComponentHtml {

	private String text;

	public Label(String text){

		super();
		this.text = text;
	}

	@Override
	public String getHtml() {

		return text;
	}
}