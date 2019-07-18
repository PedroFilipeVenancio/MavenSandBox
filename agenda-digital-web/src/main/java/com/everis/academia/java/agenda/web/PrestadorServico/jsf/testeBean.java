package com.everis.academia.java.agenda.web.PrestadorServico.jsf;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.everis.academia.java.agenda.digital.business.PrestadorServico.IPrestadorServicoBusiness;
import com.everis.academia.java.agenda.digital.business.Telefone.ITelefoneBusiness;
import com.everis.academia.java.agendadigital.entity.PrestadorServico;
import com.everis.academia.java.agendadigital.entity.Telefone;

@Component("testeBean")
@ManagedBean(name = "testeBean")
//@ViewScoped
public class testeBean {
	
	private Integer ddd;
	private Integer numero;
	
	@Autowired
	private IPrestadorServicoBusiness business;
	private PrestadorServico prestadorServico = new PrestadorServico();
	
	@Autowired
	private ITelefoneBusiness TelefoneBusiness;
	private Telefone phone = new Telefone();
	private Telefone novo = new Telefone();
	private Set<Telefone> lista = new HashSet<Telefone>();
	private static int id = 0;
	
//	   @PostConstruct
//	    public void init() {
////		   lista.add(new Telefone(3,4,5));
//		   System.out.println("codigo no post" + this.phone.getNumero());
//		   lista.add(new Telefone(this.phone.getDdd(),this.phone.getNumero()));
//		   System.out.println(this.lista.size() + "OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
//	    }
	
	public String addPhone() {
		if (!(lista.add(new Telefone(this.ddd,this.numero)))) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Deu erro ao adicionar telefone","numero Repetido"));
		}
		return "";
	}
	
	public Telefone getPhone() {
		return phone;
	}
	public void setPhone(Telefone phone) {
		this.phone = phone;
	}



	public Set<Telefone> getLista() {
		return lista;
	}

	public void setLista(Set<Telefone> lista) {
		this.lista = lista;
	}

	public Integer getDdd() {
		return ddd;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	

	
	

}
