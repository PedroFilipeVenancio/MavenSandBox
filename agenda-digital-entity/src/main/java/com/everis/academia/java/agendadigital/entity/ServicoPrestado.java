package com.everis.academia.java.agendadigital.entity;

//@Entity
//@Table(name="servicoPrestado")
public class ServicoPrestado {

//	@Id
//	@Column(name="id")
	private Integer codigo;

//	@Column(name="prestacaoServico")
	private PrestacaoServico prestacaoServico;

//	@Column(name="tipoServico")
	private TipoServico tipoServico;

//	@Column(name="valor")
	private Float valor;

	public ServicoPrestado(Integer codigo) {
		super();
		this.codigo = codigo;
	}

	
	
	public ServicoPrestado() {
		super();
	}



	public ServicoPrestado(PrestacaoServico prestacaoServico, TipoServico tipoServico, Float valor) {
		super();
		this.prestacaoServico = prestacaoServico;
		this.tipoServico = tipoServico;
		this.valor = valor;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public PrestacaoServico getPrestacaoServico() {
		return prestacaoServico;
	}

	public void setPrestacaoServico(PrestacaoServico prestacaoServico) {
		this.prestacaoServico = prestacaoServico;
	}

	public TipoServico getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(TipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

}