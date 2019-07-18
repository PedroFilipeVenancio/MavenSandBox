package com.everis.academia.java.agenda.web.PrestadorServico.jsf;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.omg.CosNaming.NamingContextPackage.NotEmpty;
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
//@RequestScope
@ViewScoped
public class PrestadorServicoCreateBean {

	@Autowired
	private IPrestadorServicoBusiness business;
	private PrestadorServico prestadorServico = new PrestadorServico();
	
	@Autowired
	private ITelefoneBusiness TelefoneBusiness;
	private Telefone newPhone = new Telefone();
//	Set<Telefone> numeros = new HashSet<Telefone>();
	Set<Telefone> numeros;
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
		numeros = new HashSet<Telefone>();
	}

	public String createPrestadorServico() {
		try {
			prestadorServico.setTelefones(numeros);
			business.create(prestadorServico);
			this.numeros.clear();
			this.prestadorServico = new PrestadorServico();
			this.newPhone = new Telefone();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Prestador adicionado com sucesso",""));
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
	
	public String  insertPhone() {

		Telefone ok = new Telefone();
		if ((newPhone.getDdd() != null) && (this.newPhone.getNumero() != null)) {
			ok.setDdd(newPhone.getDdd());
			ok.setNumero(newPhone.getNumero());
			ok.setPrestadorServico(prestadorServico);
			if (!numeros.add(ok)) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Deu erro ao adicionar telefone","numero Repetido"));
			}	
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Deu erro ao adicionar telefone","Adicione o ddd e o numero de telefone Correctamente"));
		}
		return null;
		}	
	
	public void delete (Telefone numero) {
		this.numeros.remove(numero);
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
		return this.numeros;
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
	
	
}