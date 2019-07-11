package com.everis.academia.java.agendadigital.entity;

//@Entity
//@Table(name="tipoServico")
public class TipoServico {

//	@Id
//	@Column(name="id")
	private Integer codigo;

//	@Column(name="descricao")
	private String descricao;

//	private PrestadorServico prestadorServico;
	
	public TipoServico() {
		super();
	}
	
	public TipoServico(Integer codigo) {
	super();
	this.codigo = codigo;
}



	public TipoServico(Integer codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

//	public PrestadorServico getPrestadorServico() {
//		return prestadorServico;
//	}
//
//	public void setPrestadorServico(PrestadorServico prestadorServico) {
//		this.prestadorServico = prestadorServico;
//	}

}