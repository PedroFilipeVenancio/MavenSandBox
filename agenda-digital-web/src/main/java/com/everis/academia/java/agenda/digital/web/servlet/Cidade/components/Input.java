package com.everis.academia.java.agenda.digital.web.servlet.Cidade.components;

public class Input extends ComponentHtml {

	private String	type;

	private String	name;

	private String	value;

	public Input(String type, String name, String value){

		super();
		this.type = type;
		this.name = name;
		this.value = value;
	}

	@Override
	public String getHtml() {

		return "<input type=\"" + type + "\" name=\"" + name + "\" value=\""
				+ (value != null ? value : "") + "\"\\>";
	}
}
