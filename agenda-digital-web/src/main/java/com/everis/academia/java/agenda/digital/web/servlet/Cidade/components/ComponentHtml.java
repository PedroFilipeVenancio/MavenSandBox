package com.everis.academia.java.agenda.digital.web.servlet.Cidade.components;



import java.util.ArrayList;
import java.util.List;

public abstract class ComponentHtml {

	private List<ComponentHtml> components = new ArrayList<ComponentHtml>();

	public ComponentHtml(){
	}

	public List<ComponentHtml> getComponents() {

		return components;
	}

	public void setComponents(List<ComponentHtml> components) {

		this.components = components;
	}

	public void addComponent(ComponentHtml component) throws Exception {

		validateAddComponent(component);

		components.add(component);
	}

	protected void validateAddComponent(ComponentHtml component)
			throws Exception {

	}

	public abstract String getHtml();
}
