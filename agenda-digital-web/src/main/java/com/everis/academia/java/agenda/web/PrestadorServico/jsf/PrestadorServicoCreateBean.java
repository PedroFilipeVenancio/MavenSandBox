package com.everis.academia.java.agenda.web.PrestadorServico.jsf;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.everis.academia.java.agenda.digital.business.BusinessException;
import com.everis.academia.java.agenda.digital.business.Cidade.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.business.PrestadorServico.IPrestadorServicoBusiness;
import com.everis.academia.java.agenda.digital.business.Telefone.ITelefoneBusiness;
import com.everis.academia.java.agenda.digital.business.TipoServico.ITipoServicoBusiness;
import com.everis.academia.java.agendadigital.entity.Cidade;
import com.everis.academia.java.agendadigital.entity.PrestadorServico;
import com.everis.academia.java.agendadigital.entity.Telefone;
import com.everis.academia.java.agendadigital.entity.TipoServico;

import Enums.TipoLogradouro;

@Component("prestadorServicoCreate")
@ManagedBean(name = "prestadorServicoCreate")
@RequestScope
public class PrestadorServicoCreateBean {

	@Autowired
	private IPrestadorServicoBusiness business;
	private PrestadorServico prestadorServico = new PrestadorServico();
	
	@Autowired
	private ITelefoneBusiness TelefoneBusiness;
	private Telefone newPhone = new Telefone();
	Set<Telefone> numeros = new HashSet<Telefone>();
	private static int id = 0;
	
	@Autowired
	private ICidadeBusiness cidadebusiness;
	private Cidade cidade = new Cidade();
	private Collection<Cidade> cidades = null;
	
	@Autowired
	private ITipoServicoBusiness tiposServicoBusiness;
	private Collection<TipoServico> tiposServico = null;
	
	public TipoLogradouro[] getAreas(){
		return TipoLogradouro.values();
	}
	
	//TODO: the name is not important , but the PostConstruct executes after this class starts,
	@PostConstruct
	public void init() {
		this.cidades = cidadebusiness.read();
		this.tiposServico = tiposServicoBusiness.read();
	}

	public Cidade getCidade() {
		return cidade;
	}
	
	public Collection<TipoServico> getTiposServico() {
		return tiposServico;
	}

	public void setTiposServico(Collection<TipoServico> tiposServico) {
		this.tiposServico = tiposServico;
	}

	public Telefone getNewPhone() {
		return newPhone;
	}

	public void setNewPhone(Telefone newPhone) {
		this.newPhone = newPhone;
	}

	public Collection<Telefone> getNumeros() {
		return numeros;
	}

	public void setNumeros(Set<Telefone> numeros) {
		this.numeros = numeros;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}



	public Collection<Cidade> getCidades() {
		return cidades;
	}



	public void setCidades(Collection<Cidade> cidades) {
		this.cidades = cidades;
	}



	public PrestadorServico getPrestadorServico() {
		
		return prestadorServico;
	}
	
	public void setPrestadorServico(PrestadorServico prestadorServico) {

		this.prestadorServico = prestadorServico;
	}
	
	public String createPrestadorServico() {
		try {
			prestadorServico.setTelefones(numeros);
			for (Telefone numero : numeros) {
				numero.setPrestadorServico(prestadorServico);
			}
			this.prestadorServico.setTelefones(numeros);
			this.prestadorServico.addTelefone(newPhone);
			business.create(prestadorServico);

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, prestadorServico.getNome(), ": registado com sucesso!"));
			return "read";
		} catch (BusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao registar!", e.getMessage()));
		}
		return null;
	}
	
	public String cleanPrestadorServico() {
		this.prestadorServico = new PrestadorServico();
		return null;
	}
	
	public void  insertPhone() {
		newPhone.setPrestadorServico(prestadorServico);
		numeros.add(newPhone);
		prestadorServico.setTelefones(numeros);
		prestadorServico.addTelefone(newPhone);
		}	
}