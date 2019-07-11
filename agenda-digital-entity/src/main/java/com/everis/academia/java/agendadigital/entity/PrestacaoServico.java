package com.everis.academia.java.agendadigital.entity;
import java.util.Date;
import java.util.Set;

//@Entity
//@Table(name="prestacaoServico")
public class PrestacaoServico {

//	@Id
//	@Column(name="id")
	private Integer codigo;

//	@Column(name="data")
	private Date data;

//	@Column(name="prestador")
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