package com.everis.academia.java.agendadigital.entity;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//@Entity
//@Table(name="prestacaoServico")

//@Entity
//@Table(name="TB_PRESTACAO_SERV", schema = "public")
//@SequenceGenerator(name = "SQ_PRESTACAO_SERV", sequenceName = "SQ_PRESTACAO_SERV", schema = "public", initialValue = 1, allocationSize =  1)
public class PrestacaoServico {

//	@Id
//	@Column(name="id")
	
//	@Id
//	@GeneratedValue(generator = "SQ_PRESTACAO_SERV", strategy = GenerationType.SEQUENCE)
//	@Column(name="COD_PRESTACAO_SERV")
	private Integer codigo;

//	@Column(name="data")
//	@Column(name="NOME_PRESTACAO_SERV")
	private Date data;

//	@Column(name="prestador")
//	@Column(name="PRESTADOR_PRESTACAO_SERV")
	private PrestadorServico prestador;

	private Set<ServicoPrestado> servicoPrestados;

	public PrestacaoServico(Integer codigo, Date data, PrestadorServico prestador) {
		super();
		this.codigo = codigo;
		this.data = data;
		this.prestador = prestador;
	}
	
	
	public PrestacaoServico() {
		super();
	}


	public PrestacaoServico(Integer codigo) {
		super();
		this.codigo = codigo;
	}



	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public PrestadorServico getPrestador() {
		return prestador;
	}

	public void setPrestador(PrestadorServico prestador) {
		this.prestador = prestador;
	}

	public Set<ServicoPrestado> getServicoPrestados() {
		return servicoPrestados;
	}

	public void setServicoPrestados(Set<ServicoPrestado> servicoPrestados) {
		this.servicoPrestados = servicoPrestados;
	}

}